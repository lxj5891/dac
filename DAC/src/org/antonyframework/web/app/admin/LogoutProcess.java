package org.antonyframework.web.app.admin;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.web.Message;
import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;

/**
 * 退出后台管理
 * 
 * @author Nanlei
 * 
 */
public class LogoutProcess extends Process {

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		request.getSession().removeAttribute(Constants.LOGIN_USER);
		request.getSession().invalidate();
		model.put("logout", Message.LOGOUT);
		return new Result(this.getSuccessView(), model);
	}

}
