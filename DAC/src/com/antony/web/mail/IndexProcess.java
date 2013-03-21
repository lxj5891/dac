package com.antony.web.mail;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.process.BaseProcess;

public class IndexProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test mail");
		List testUser = getServMgr().getMailService().getTestUser();
		model.put("users", testUser);
		return model;
	}

}