package org.antonyframework.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ChatSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		// TODO Auto-generated method stub
		String id = e.getSession().getId();
		System.out.println("#################"+id);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		// TODO Auto-generated method stub
		String id = e.getSession().getId();
		System.out.println("#################"+id);
	}

}
