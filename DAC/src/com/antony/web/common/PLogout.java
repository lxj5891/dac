package com.antony.web.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.web.Message;
import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 退出后台管理
 * 
 * @author Nanlei
 * 
 */
public class PLogout extends Process {
	private static final Log log = LogFactory.getLog(PLogout.class);

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		request.getSession().removeAttribute(Constants.LOGIN_USER_ID);
		request.getSession().removeAttribute(Constants.LOGIN_USER);
		request.getSession().removeAttribute(Constants.USER_ROLE_ID);
		request.getSession().invalidate();
		model.put("logout", Message.LOGOUT);
		return new Result(null, null, Message.URL_ROOT, true, model);
	}

}
