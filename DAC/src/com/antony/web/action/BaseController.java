package com.antony.web.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.core.bean.BeanManager;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.antony.service.ServiceManager;
import com.antony.service.UserManager;
import com.google.gson.Gson;


public abstract class BaseController {
//	@Autowired
//	protected ResourceBundleMessageSource _res;
//	
//	@Autowired
//	protected SpringContextHolder _contextHolder;

	public ServiceManager getServMgr() {
		return (ServiceManager) BeanManager.getBean("ServiceManager");
	}
	public UserManager getUserMgr(){
		return (UserManager) BeanManager.getBean("UserManager");
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message,String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		if(forwardUrl!=null)
			mav.addObject("callbackType", "forward");
		else
			mav.addObject("callbackType", "");
		if(forwardUrl!=null)
			mav.addObject("forwardUrl", forwardUrl);
		else
			mav.addObject("forwardUrl", "");
		return mav;
	}
	

	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message,null);
	}
	protected ModelAndView ajaxDoneSuccess(String message,String forwardUrl) {
		return ajaxDone(200, message,forwardUrl);
	}

	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message,null);
	}
	protected ModelAndView ajaxDoneError(String message,String forwardUrl) {
		return ajaxDone(300, message,forwardUrl);
	}
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}

//	protected String getMessage(String code, Object[] args) {
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//		Locale locale = localeResolver.resolveLocale(request);
//
//		return _res.getMessage(code, args, locale);
//	}
	public void sendJson(HttpServletResponse resp,Map<String,Object> m){
		resp.setContentType("text/html;charset=UTF-8");  
		try {
			resp.getWriter().print(new Gson().toJson(m));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
