/*
 * @(#) MailManager.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */

package org.antonyframework.support.mail;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.antonyframework.service.factory.ConnectionFactoryManager;
import org.antonyframework.service.factory.IConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.service.mail.db.Cm3001Mapper;
import com.antony.service.mail.vo.Cm3001;

/**
 * ���� ����� ����ϴ� Manager��. �� Ŭ������ Asynchronus����� Ŭ���� �̹Ƿ�, ��� ���
 * true�� ��ȯ�Ѵ�. ��� ������ ���� DB�� �����ؼ� ������ ó�� �� �Ѵ�.
 * 
 * @system : Utilily
 * @sub system :
 * @author : Hong Y.C
 * @date : 2002/12/03
 */
public class MailManager {

	private static final Log LOG = LogFactory.getLog(MailManager.class);

	private static IConnectionFactory connectionFactory = ConnectionFactoryManager
			.getFactory(IConnectionFactory.DB_DEV);

	protected Connection getConnection() throws SQLException {
		return connectionFactory.getConnection();
	}
	
	private static MailManager mail;

	private static int mailid;
	
	private String mailContent = "<html><meta name=\"seq_no\" content=\"{0}\"><body><script language=\"javascript\">"
			+ "if (opener)opener.RefreshOnNewMail();"
			+ " window.open (\"http://{1}/epm/EBPServlet?act=MAILLOGIN&&moveAct={2}&username={3}&{4}\", \"_WindorFromMail\",\"\");"
			+ " parent.close();" + "</script></body></html>";

	private MailManager() {
		init();
	}

	public static MailManager getInstance() {
		if (mail == null) {
			mail = new MailManager();
			mail.init();
		}
		return mail;
	}

	private void init() {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select max(id)+1 as id from cm3001");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				mailid = rs.getInt(1);
			}
		} catch (Exception e) {
			mailid = -1;
		}
		
		
		
		
		Properties prop = System.getProperties();
		Object obj = prop.get("MailThread");
		if (obj == null) {
			try {
				MailThread mailThread = new MailThread();
				prop.put("MailThread", mailThread);
			} catch (Exception e) {
				LOG.fatal("Cannot create MailThread", e);
			}
		} else {
			Class mtClass = obj.getClass();
			try {
				Method closeMethod = mtClass.getMethod("close", new Class[0]);
				closeMethod.invoke(obj, new Object[0]);
				MailThread mailThread = new MailThread();
				prop.put("MailThread", mailThread);
			} catch (Exception e) {
				LOG.fatal("Cannot close MailThread", e);
			}
		}
	}

	/**
	 * ���� ��û ������ �߼��Ѵ�.
	 * 
	 * @param fromEmpNo
	 *            ������ ���
	 * @param toEmpNo
	 *            �޴� ���
	 * @param subject
	 *            ����
	 * @param actName
	 *            act ��
	 * @param param
	 *            �ĸ����� ����Ʈ
	 * @return
	 */
	public boolean sendApprovalMail(String fromEmpNo, String toEmpNo,
			String subject, String actName, String param) {
		MailBEAN mBEAN = new MailBEAN();
		mBEAN.setSenderAddr(fromEmpNo);
		mBEAN.setReceiverAddr(toEmpNo);
		mBEAN.setSubject(subject);
		int apprId = 0;
		return sendApprovalMail(apprId, mBEAN, actName, param);
	}

	public boolean sendApprovalMail(int apprId, String fromEmpNo,
			String toEmpNo, String subject, String actName, String param) {
		MailBEAN mBEAN = new MailBEAN();
		mBEAN.setSenderAddr(fromEmpNo);
		mBEAN.setReceiverAddr(toEmpNo);
		mBEAN.setSubject(subject);
		return sendApprovalMail(apprId, mBEAN, actName, param);
	}

	/**
	 * ���� ��û ������ �߼��Ѵ�.
	 * 
	 * @param mBean
	 *            ���� ����
	 * @param actName
	 *            act ��
	 * @param param
	 *            �Ķ���� ����Ʈ
	 * @return
	 */
	public boolean sendApprovalMail(int apprId, MailBEAN mBean, String actName,
			String param) {
		if (mBean == null)
			return false;
		if (mBean.getSenderAddr() == null || mBean.getReceiverAddr() == null
				|| mBean.getSubject() == null || actName == null)
			return false;
		mBean.setContent(getMailContent(apprId, mBean.getReceiverAddr(),
				actName, param));
		return sendMail(mBean);
	}

	/**
	 * �Ϲ� ������ �߼��Ѵ�.
	 * 
	 * @param fromEmpNo
	 *            ������ ���
	 * @param toEmpNo
	 *            �޴� ���
	 * @param subject
	 *            ����
	 * @param content
	 *            ����
	 * @return
	 */
	public boolean sendMail(String fromEmpNo, String toEmpNo, String subject,
			String content) {
		MailBEAN mBEAN = new MailBEAN();
		mBEAN.setSenderAddr(fromEmpNo);
		mBEAN.setReceiverAddr(toEmpNo);
		mBEAN.setSubject(subject);
		mBEAN.setContent(content);
		return sendMail(mBEAN);
	}
	public int sendMail(MailBEAN mBean, Cm3001Mapper cm3001mapper) {
		// TODO Auto-generated method stub
		if(mailid != -1)
			mBean.setId(mailid++);
		else
			mBean.setId(cm3001mapper.MailNextId());
		if(sendMail(mBean)){
			mBean.getId();
			Cm3001 mailVo = new Cm3001();
			mailVo.setId((int) mBean.getId());
			mailVo.setSenderaddr(mBean.getSenderAddr());
			mailVo.setSendername(mBean.getSenderName());
			mailVo.setSubject(mBean.getSubject());
			mailVo.setContent(mBean.getContent());
			mailVo.setReceiveraddr(mBean.asString(mBean.getReceiverList()));
			mailVo.setSenddate(new Date());
			mailVo.setStatus("N");
			cm3001mapper.insertSelective(mailVo);
			mailVo = null;
			return mailid;
		}else{
			return -1;
		}
	}
	/**
	 * �Ϲ� ������ �߼��Ѵ�.
	 * 
	 * @param mBean
	 *            ���� ����
	 * @return
	 */
	public boolean sendMail(MailBEAN mBean) {
		if (mBean == null)
			return false;
		if ((mBean.getReceiverList() == null)
				|| (mBean.getReceiverList().length < 1)
				|| (mBean.getSubject() == null))
			return false;
		putMail(mBean);
		return true;
	}

	private void putMail(MailBEAN mailBean) {
		Properties prop = System.getProperties();
		Object obj = prop.get("MailThread");
		Class mtClass = obj.getClass();
		try {
			Method putMail = mtClass.getMethod("putMail",
					new Class[] { MailBEAN.class });
			putMail.invoke(obj, new Object[] { mailBean });
		} catch (Exception e) {
			LOG.error("cannot call putMail method of MailThread", e);
		}
	}

	public String getMailContent(String toEmpNo, String actName, String param) {
		return getMailContent(0, actName, param, toEmpNo, "");
	}

	public String getMailContent(int apprId, String toEmpNo, String actName,
			String param) {
		return getMailContent(apprId, actName, param, toEmpNo, "");
	}

	public List getMailFailedList(){
		return null;
	}
	private String getMailContent(int apprId, String moveAct, String param,
			String username, String password) {
		String apprIdString = Integer.toString(apprId);
		return MessageFormat.format(mailContent, new Object[] { apprIdString,
				"", moveAct, username, param });
	}


}