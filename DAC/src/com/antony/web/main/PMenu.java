package com.antony.web.main;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.process.BaseProcess;

public class PMenu extends BaseProcess  {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		String topIndex = request.getParameter("MID");
		List leftMenuList = getServMgr().getMenuService().getLeftMenu(topIndex);
		model.put("leftMenuList", leftMenuList);
		return model;
	}
	

}
