package org.antonyframework.web.process;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.core.bean.BeanManager;
import com.antony.service.ServiceManager;
import org.antonyframework.web.common.ExecuteResult;
import org.antonyframework.web.common.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;

/**
 * 文件上传操作基类Process
 * 
 * @author Nanlei
 * 
 */
public abstract class FileUploadBaseProcess extends FileUploadProcess {
	/**
	 * 获取系统管理的Service管理器
	 * 
	 * @return
	 */
	/**
	 * 获取前台的Service管理器
	 * 
	 * @return
	 */
	public ServiceManager getFrontServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}

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

	/**
	 * 执行方法
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@Override
	public Result process(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		HashMap<String, Object> model = new HashMap<String, Object>();
		HashMap<String, Object> finalModel = execute(request, response, model,
				command, errors);
		return new Result(this.getSuccessView(), finalModel);
	}

	public abstract HashMap execute(HttpServletRequest request,
			HttpServletResponse response, HashMap model, Object command,
			BindException errors);

	/* 通用操作结果返回页 */
	public static final String EXECUTE_RESULT = Constants.EXECUTE_RESULT;
	public static final String ERROR = Constants.ERROR;
	public static final String SUCCESS = Constants.SUCCESS;

	private ExecuteResult executeResult;

	private ExecuteResult buildExecuteResult(HttpServletRequest request) {
		if (executeResult == null) {
			executeResult = new ExecuteResult();
			request.getSession().setAttribute(EXECUTE_RESULT, executeResult);
		}
		return executeResult;
	}

	public void setResult(String result, HttpServletRequest request) {
		buildExecuteResult(request).setResult(result);
	}

	public void addMessage(String message, HttpServletRequest request) {
		buildExecuteResult(request).getMessages().clear();
		buildExecuteResult(request).addMessage(message);
	}

	public void addRedirURL(String desc, String url, HttpServletRequest request) {
		buildExecuteResult(request).addRedirURL(desc, url);
	}

	public ExecuteResult getExecuteResult(HttpServletRequest request) {
		return (ExecuteResult) request.getSession()
				.getAttribute(EXECUTE_RESULT);
	}

}
