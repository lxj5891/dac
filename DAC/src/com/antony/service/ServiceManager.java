package com.antony.service;

import com.antony.service.common.biz.MenuService;
import com.antony.service.mail.biz.MailService;
import com.antony.service.sm.biz.SM3001Service;

/**
 * @author LH
 * 
 */
public class ServiceManager {

	public static ServiceManager instance;

	public ServiceManager() {
	}

	public static ServiceManager getInstance() {
		if (instance == null) {
			instance = new ServiceManager();
		}
		return instance;
	}

	/* biz mail */
	private MailService mailService;

	/* biz main */
	private MenuService menuService;

	private SM3001Service sm3001Service;

	public SM3001Service getSm3001Service() {
		return sm3001Service;
	}

	public void setSm3001Service(SM3001Service sm3001Service) {
		this.sm3001Service = sm3001Service;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

}
