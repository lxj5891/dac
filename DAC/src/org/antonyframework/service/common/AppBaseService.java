package org.antonyframework.service.common;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.common.AppResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.service.ServiceManager;

public class AppBaseService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String AppResult = null;

	protected final Log log = LogFactory.getLog(AppBaseService.class);

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String serviceName = request.getParameter("serviceName");
		String methodName = request.getParameter("methodName");
		try {
			ServiceManager servMgr = ServiceManager.getInstance();
			Method getBeanMethod = servMgr.getClass().getMethod(
					"get" + serviceName, null);
			Object beanObject = getBeanMethod.invoke(servMgr, null);
			Method method;

			method = beanObject.getClass().getMethod(methodName,
					HttpServletRequest.class);
			Object invoke = method.invoke(beanObject, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("app result system error  %\n% appBaseServive  \tserviceName:"
					+ serviceName
					+ "\tmethodName:"
					+ methodName
					+ "%\n\t%"
					+ e.getMessage());
		}
		super.service(request, response);
	}

}
