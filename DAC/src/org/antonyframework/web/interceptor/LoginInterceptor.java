package org.antonyframework.web.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;

/**
 * 登录拦截器实现类
 * 
 * @author Nanlei
 * 
 */
public class LoginInterceptor extends AbstractLoginInterceptor {

	@Override
	public boolean alreadyLogin(HttpServletRequest request,
			HttpServletResponse response) {
		Object authUser = request.getSession()
				.getAttribute(Constants.LOGIN_USER);
		System.out.println("?");
		if (authUser != null) {
			return true;
		}
		return false;
	}

}
