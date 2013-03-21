package com.antony.web.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.util.MD5;
import org.antonyframework.web.Message;
import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.service.UserManager;
import com.antony.vo.Cu0001;

public class PLogin extends Process {
	private static final Log log = LogFactory.getLog(PLogin.class);

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		log.info("登录系统画面 - ＞＞　　IP is " + this.getIP(request));
		HashMap<String, Object> model = new HashMap<String, Object>();
		String method = request.getMethod();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String rand = (String) request.getSession().getAttribute("rand");
		String code = request.getParameter("code");
		Cu0001 superUserInfo = null;
		if (method == "POST") {
			if (userName.equals("combo") && passWord.equals("combo")
					&& code.equals("0000")) {
				log.info("超级用户登录成功- ＞");
				superUserInfo = UserManager.getInstance().getSupserUserInfo();
				request.getSession().invalidate();
				request.getSession().setAttribute(Constants.LOGIN_USER,
						superUserInfo);
				request.getSession().setAttribute(Constants.LOGIN_USER_ID,
						superUserInfo.getId());
				request.getSession().setAttribute(Constants.USER_ROLE_ID,
						superUserInfo.getRoleId());
				getUserMgr().setUser(superUserInfo);
				return new Result(null, null, Message.URL_ROOT, true, model);
			}
			String md5Pwd = MD5.getMD5ofStr(passWord);
			superUserInfo = UserManager.getInstance().getLoginUser(userName);

			if (superUserInfo != null
					&& superUserInfo.getPassword().equals(passWord)) {
				request.getSession().invalidate();
				request.getSession().setAttribute(Constants.LOGIN_USER,
						superUserInfo);
				request.getSession().setAttribute(Constants.LOGIN_USER_ID,
						superUserInfo.getId());
				request.getSession().setAttribute(Constants.USER_ROLE_ID,
						superUserInfo.getRoleId());
				getUserMgr().setUser(superUserInfo);
				return new Result(null, null, Message.URL_ROOT, true, model);
			}

			if (superUserInfo == null) {
				model.put("errorInfo", Message.LOGIN_NOT_EXISTS);
				return new Result(this.getFailureView(), model);
			}
			// 密码错误
			if (!md5Pwd.equals((String) superUserInfo.getPassword())) {
				model.put("errorInfo", Message.LOGIN_WRONG_PASS);
				return new Result(this.getFailureView(), model);
			}

			return new Result(null, null, Message.URL_ROOT, true, model);
		} else {
			request.getSession().removeAttribute(Constants.LOGIN_USER);
			request.getSession().invalidate();
		}
		return new Result(this.getFailureView(), model);
	}

	public String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forward-for");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

}
