package com.antony.service.mail.biz;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.antonyframework.service.common.BaseService;
import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailManager;
import org.antonyframework.web.common.AppResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.antony.dao.Sm3001Mapper;
import com.antony.mail.task.ForgetMailTask;
import com.antony.mail.task.RejectMailTask;
import com.antony.mail.task.Sm3001MailTask;
import com.antony.service.mail.db.Cm3001Mapper;
import com.antony.service.mail.db.MailMapper;
import com.antony.service.mail.vo.Cm3001;
import com.antony.service.mail.vo.Cm3001Example;
import com.antony.vo.Sm3001;
import com.antony.vo.Sm3001Example;

public class MailService extends BaseService {

	@Autowired
	private Cm3001Mapper cm3001mapper;
	@Autowired
	private MailMapper mapper;
	private static MailManager mailManager;
	@Autowired
	private Sm3001Mapper sm3001Mapper;

	@Override
	public int add(HttpServletRequest request) throws RuntimeException {
		// TODO Auto-generated method stub
		try {
			Cm3001 vo = (Cm3001) convert(request, Cm3001.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.add(request);
	}

	public MailService() {
		log.info("*******邮件系统*************");
		mailManager = MailManager.getInstance();
		log.info("******* 初始化 *************");
	}

	public AppResult createStep1(HttpServletRequest request) {
		AppResult result = new AppResult();

		return result;
	}

	public List getTestUser() {
		// TODO Auto-generated method stub
		List<Map> emailTestUser = mapper.getEmailTestUser();
		return emailTestUser;

	}

	public String sendEmail(String title, String content, String[] emailId) {
		for (String id : emailId) {
			RejectMailTask task = new RejectMailTask();
			task.setTitle(title);
			task.setText(content);
			task.setId(id);
			try {
				List<MailBEAN> mailList = task.getMailList();
				for (MailBEAN m : mailList) {
					m.setSubject(title);
					int mailId = mailManager.sendMail(m, cm3001mapper);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return " ";
	}
	
	public int IF00067Mail(String mail,String pass){
		ForgetMailTask task  = new ForgetMailTask();
		task.setEmail(mail);
		task.setPass(pass);
		try {
			List<MailBEAN> mailList = task.getMailList();
			for(MailBEAN m : mailList){
				boolean mailId = mailManager.sendMail(m);
			}
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
		
	
	
	public int inventMail(String[] id){
		Sm3001MailTask task = new Sm3001MailTask();
		task.setSm3001Id(id);
		try {
			List<MailBEAN> mailList = task.getMailList();
			for(MailBEAN m : mailList){
				int mailId = mailManager.sendMail(m, cm3001mapper);
				Sm3001Example example = new Sm3001Example();
				Sm3001 sm = new Sm3001();
				Map mailInfo = m.getMailInfo();
				example.createCriteria().andUidEqualTo((String)mailInfo.get("UID"));
				sm.setEmailid(mailId);
				sm3001Mapper.updateByExampleSelective(sm , example);
				
			}
			return 1;
		} catch (Exception e) {
		}
		
		return -1;
	}
	

	public MailBEAN getFailedMail() {
		MailBEAN mBean = new MailBEAN();
		Cm3001Example example = new Cm3001Example();

		example.createCriteria().andStatusEqualTo("N");
		example.setOrderByClause(" SENDDATE  limit 0 ,1 ");
		List<Cm3001> failedMailDB = cm3001mapper
				.selectByExampleWithBLOBs(example);
		if (failedMailDB != null && !failedMailDB.isEmpty()) {
			Cm3001 cm3001 = failedMailDB.get(0);
			mBean.setSubject(cm3001.getSubject());
			mBean.setFromAddr(cm3001.getSenderaddr(), cm3001.getSendername());
			mBean.addReceiver(cm3001.getReceiveraddr());
			mBean.setSenderAddr(cm3001.getSenderaddr());
			mBean.setSenderName(cm3001.getSendername());
			mBean.setContent(cm3001.getContent());
			mBean.setId(cm3001.getId());
			failedMailDB = null;
			example = null;
			return mBean;
		} else {
			return null;
		}
	}
	
}
