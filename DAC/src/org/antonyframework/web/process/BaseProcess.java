package org.antonyframework.web.process;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.core.bean.BeanManager;

import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.antony.service.ServiceManager;
/**
 * Process基类
 * 
 * @author Nanlei
 * 
 */
public abstract class BaseProcess extends Process {

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 获取系统管理的Service管理器
	 * 
	 * @return
	 */
	

	/**
	 * 获取登录用户对象
	 * 
	 * @param request
	 * @return
	 */
	public Map getUser(HttpServletRequest request) {
		return (Map) request.getSession().getAttribute(Constants.LOGIN_USER);
	}

	/**
	 * 获取登录用户的ID
	 * 
	 * @param request
	 * @return
	 */
	public String getUserId(HttpServletRequest request) {
		return String.valueOf(getUser(request).get("ID"));
	}

	/**
	 * 获取IP的方法，加入了通过代理服务器跳转过来请求的判断
	 * 
	 * @param request
	 * @return
	 */
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

	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		HashMap<String, Object> finalModel = this.execute(request, response,
				model);
		return new Result(this.getSuccessView(), finalModel);
	}

	public abstract HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception;

}
