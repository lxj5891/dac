package org.antonyframework.web.process;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.Constants;
import org.antonyframework.core.bean.BeanManager;
import com.antony.service.ServiceManager;
import org.antonyframework.util.QueryUtil;
import org.antonyframework.web.common.Process;
import org.antonyframework.web.common.Result;
import org.apache.commons.lang.StringUtils;

/**
 * 分页处理基类
 * 
 * @author Nanlei
 * 
 */
public abstract class PagingBaseProcess extends Process {

	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}


	/**
	 * 获取登录用户对象
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
		return String.valueOf(getUser(request).get("UID"));
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
		// 放置分页信息
		model.put("maxPageSize", getMaxPageSize());
		model.put("defaultPageSize", getDefaultPageSize());
		model.put("fullUrlWithoutPageNum", getFullUrlWithoutPageNum(request));
		model.put("fullUrlWithoutPageInfo", getFullUrlWithoutPageInfo(request));
		return new Result(this.getSuccessView(), finalModel);
	}

	/**
	 * 供子类实现的抽象方法
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public abstract HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception;

	/* 分页信息 */
	protected int pageNum = 1;

	protected int pageSize = Constants.DEFAULT_PAGE_SIZE;

	protected int maxPageSize = Constants.MAX_PAGE_SIZE;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize, HttpServletRequest request) {
		this.pageSize = pageSize;
		request.setAttribute("pageSize", pageSize);
	}

	public int getMaxPageSize() {
		return maxPageSize;
	}

	public int getDefaultPageSize() {
		return Constants.DEFAULT_PAGE_SIZE;
	}

	@SuppressWarnings("unchecked")
	public String getQueryStringWithoutPageNum(HttpServletRequest request) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		Map m = request.getParameterMap();
		hashMap.putAll(m);
		hashMap.remove("pageNum");
		return QueryUtil.getQueryString(hashMap);
	}

	public String getFullUrlWithoutPageNum(HttpServletRequest request) {
		return request.getServletPath() + "?"
				+ getQueryStringWithoutPageNum(request);
	}

	@SuppressWarnings("unchecked")
	public String getQueryStringWithoutPageInfo(HttpServletRequest request) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		Map  m = request.getParameterMap();
		hashMap.putAll(m);
		hashMap.remove("pageNum");
		hashMap.remove("pageSize");
		return QueryUtil.getQueryString(hashMap);
	}

	public String getFullUrlWithoutPageInfo(HttpServletRequest request) {
		return request.getServletPath() + "?"
				+ getQueryStringWithoutPageInfo(request);
	}

}
