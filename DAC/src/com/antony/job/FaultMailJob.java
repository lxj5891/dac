package com.antony.job;


import java.util.Date;

import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.antony.mail.task.RejectMailTask;
import com.antony.service.mail.biz.MailService;

public class FaultMailJob {
	
	private static final Log logger = LogFactory.getLog(FaultMailJob.class);
	private static MailManager mailManager;
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	private MailService mailService;



	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}



	protected void executeInternal()
			throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("发送失败邮件."+new Date());
		
		MailBEAN mBean = mailService.getFailedMail();
		if(mBean!=null){
			mailManager = MailManager.getInstance();
//			mailManager.sendMail(mBean);
			logger.info("发送失败邮件."+mBean.getReceiverAddr()+"success");
		}
		mBean = null;
	}
}