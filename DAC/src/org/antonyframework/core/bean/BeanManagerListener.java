package org.antonyframework.core.bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Bean管理器的监听器，监听Web应用上下文初始化
 * 
 * @author Nanlei
 * 
 */
public class BeanManagerListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		BeanManager.init(event.getServletContext());
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
}
