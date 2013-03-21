package com.antony.service;

import org.antonyframework.core.bean.BeanManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.service.common.biz.UserService;
import com.antony.vo.Cu0001;

public class UserManager {

	private static final Log log = LogFactory.getLog(UserManager.class);
	private static UserManager instance;
	private UserService userService;
	private static Cu0001 user;
	
	public Cu0001 getUser() {
		return user;
	}

	public void setUser(Cu0001 user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	public UserService getUserService() {
		return userService;
	}


	public UserManager() {
	}

	public static UserManager getInstance() {
		if (instance == null) {
			instance = (UserManager) BeanManager.getBean("UserManager");
			log.info("UserManager instance create success");
		}
		return instance;
	}
	
	public Cu0001 getSupserUserInfo(){
		return userService.getSuperUserInfo();
	}


	public Cu0001 getLoginUser(String userName) {
		// TODO Auto-generated method stub
		try {
			return userService.getLoginUserBean(userName);
		} catch (Exception e) {
			return null;
		}
		
	}


}
