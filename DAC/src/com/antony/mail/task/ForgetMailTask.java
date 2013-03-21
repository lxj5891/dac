package com.antony.mail.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.antonyframework.support.mail.MailBEAN;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.mail.bean.MailTask;

public class ForgetMailTask extends MailTask {

	private static final Log logger = LogFactory.getLog(ForgetMailTask.class);

	private String title = "忘记密码";
	private String text = "text";
	private String pass = "";
	private String email = "";

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List getMailList() throws Exception {
		try {
			MailBEAN mail = new MailBEAN();
			String content = "";
			mail.setSenderName("YCOMBO玩伴");
			mail.setSenderAddr("ycombo@ycombo.com");
			mail.setSubject(title);
			mail.addReceiver(email + ";");
			// mail content
			content = " \n";
			content += "<P style=\"margin:10px 0 20px\"><STRONG style=\"font-size:14px\">新密码："
					+ pass + "</STRONG></P>\n";
			mail.setContent(content);
			mail.setLink(false);
			result.add(mail);
		} catch (Exception e) {
			logger.info(this.getClass().getName() + " Exception : "
					+ e.getMessage());
			throw e;
		} finally {
		}

		return result;
	}
}
