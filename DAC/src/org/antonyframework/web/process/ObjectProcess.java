package org.antonyframework.web.process;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antony.service.ServiceManager;
import org.antonyframework.web.common.AppResult;

public class ObjectProcess extends BaseProcess {

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// TODO Auto-generated method stub
		AppResult r = new AppResult();
		String serviceName = request.getParameter("serviceName");
		String methodName = request.getParameter("methodName");

		log.info("###call  ajax  ################");
		log.info("###start    " + request.getSession().getId() + "  ###");
		log.info("###serviceName:" + serviceName + "#################");
		log.info("###methodName :" + methodName + "#################");
		try {
			ServiceManager servMgr = getServMgr();
			Method getBeanMethod = servMgr.getClass().getMethod(
					"get" + serviceName, null);
			Object beanObject = getBeanMethod.invoke(servMgr, null);
			Method method = beanObject.getClass().getMethod(methodName,
					HttpServletRequest.class);
			r = (AppResult) method.invoke(beanObject, request);
			log.info("##############################################");
			log.info("############     success     #################");
			log.info("##############################################");
			log.info("##############################################");
		} catch (Exception e) {
			log.info("##############################################");
			log.info("############     error       #################");
			log.info("##############################################");
			log.info("##############################################");
			e.printStackTrace();
			model.put("status", 500);
			model.put("e", e.getMessage());
			return model;
		}

		model.put("status", r.getStatus());
		model.put("result", r.getResult());
		model.put("totleCount", r.getTotleCount());
		model.put("msg", r.getMsg());
		return model;
	}

}
