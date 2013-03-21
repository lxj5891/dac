package com.antony.web.main;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.process.BaseProcess;

import com.antony.vo.Cu0001;

public class IndexProcess extends BaseProcess {
	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		Cu0001 user = getUserMgr().getUser();
		List topMenuList = getServMgr().getMenuService().getTopMenu(user.getId());
		model.put("topMenuList", topMenuList);
		return model;

	}

}