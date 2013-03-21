package com.antony.web.mail;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antonyframework.web.process.BaseProcess;
import org.antonyframework.web.process.ExecuteResultBaseProcess;

import com.antony.Message;

public class SendProcess extends ExecuteResultBaseProcess {

//	public HashMap<String, Object> execute(HttpServletRequest request,
//			HttpServletResponse response, HashMap<String, Object> model)
//			throws Exception {
//		// TODO Auto-generated method stub
//		String title = request.getParameter("title");
//		String[] emailId = request.getParameterValues("id");
//		String content = request.getParameter("content");
//		System.out.println("test mail title:" + title + "userId:" + emailId);
//
//		String sendEmail = getServMgr().getYmailService().sendEmail(title,
//				content, emailId);
//		return model;
//	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String title = request.getParameter("title");
			String[] emailId = request.getParameterValues("id");
			String content = request.getParameter("content");
			System.out
					.println("test mail title:" + title + "userId:" + emailId);

			String sendEmail = getServMgr().getMailService().sendEmail(title,
					content, emailId);
			setResult(SUCCESS_200, request);
			addMessage(Message.SEND_MAIL_SUCCESS, request);
			addRedirURL(Message.GOBACK, Message.URL_MAIL, request);
			
		} catch (Exception e) {
			setResult(ERROR, request);
			addMessage(Message.SEND_MAIL_FAILURE, request);
			addRedirURL(Message.GOBACK, Message.URL_GOBACK, request);
			
		}

	}

}