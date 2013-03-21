package com.antony.mail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	public static void main(String[] args) {
		try {
			Properties p = new Properties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.host", "smtp.ym.163.com");
			p.put("mail.smtp.port", "25");
			// 建立会话
			Session session = Session.getInstance(p);
			Message msg = new MimeMessage(session);
			// 建立信息

			msg.setFrom(new InternetAddress("admin@ycombo.com"));
			// 发件人
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					"lihao@ycombo.com"));
			// 收件人

			msg.setSentDate(new Date()); // 发送日期
			msg.setSubject("答话稀有"); // 主题
			msg.setText("快点下在"); // 内容
			// 邮件服务器进行验证
			Transport tran = session.getTransport("smtp");
			tran.connect("smtp.ym.163.com", "admin@ycombo.com", "admin1234");
			// bluebit_cn是用户名，xiaohao是密码
			tran.sendMessage(msg, msg.getAllRecipients()); // 发送
			System.out.println("邮件发送成功");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}