package org.antonyframework.service;

import com.antony.service.mail.biz.MailService;

/**
 * @author LH
 * 
 */
public class ServiceManager {
	private MailService ymailService;

	
	
	public MailService getYmailService() {
		return ymailService;
	}

	public void setYmailService(MailService ymailService) {
		this.ymailService = ymailService;
	}


}
