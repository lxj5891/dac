/*
 * @(#) EPMSMTP.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */

package org.antonyframework.support.mail;

import java.util.Date;
import java.util.Properties;
import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Mail Sender Class
 * 
 * @system : Utility
 * @sub system :
 * @author : Hong Y.C
 * @date : 2002/11/23
 * 
 * @modifying developer : Hong Y.C
 * @modifying date : 2002/11/30
 * @modifying description : Creating Class
 */

public class EPMSMTP {

	private static final Log LOG = LogFactory.getLog(EPMSMTP.class);
	private static final String HOST = "dev.ycombo.com";
	private static final String MAILER = "EPMSendMailer";
	private static final String ENCODING = "utf-8";
	private static final String USERNAME = "test";
	private static final String PASSWORD = "combo1234";

	public EPMSMTP(String mailHost, String mailer, String encoding) {
	}

	private static InternetAddress TEST_ADDRESS;
	// private static String ENVIRONMENT =
	// PropFactoryManager.getFactory(IPropFactory.PARAM).getProperty("environment");

	private static String ENVIRONMENT = "LIVE";
	static {
		try {
			TEST_ADDRESS = new InternetAddress("ycombo@ycombo.com ");
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}

	public boolean send(MailBEAN mail) {
		LOG.info("邮件发送开始");
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", "25");
			LOG.info("邮件发送 中   1");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mail.getSenderAddr(),mail.getSenderName()));
			msg.setSentDate(new Date()); // 发送日期
			msg.setSubject(mail.getSubject()); // 主题
			
			// 첨부파일 처리
			List fileList = mail.getFileList();
			if ((fileList == null) || (fileList.size() == 0)) {
				// 첨부가 없을 경우
				// msg.setContent(mail.getContent(), "text/html; charset=" +
				// ENCODING);
				msg.setContent(mail.getHtmlContent(), "text/html; charset="
						+ ENCODING);
			} else {
				// 첨부가 있을 경우
				// create the Multipart and its parts to it
				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setText(mail.getContent(), ENCODING);
				// mbp1.setContent(mail.getContent(), "text/html; charset=" +
				// ENCODING);
				mbp1.setContent(mail.getHtmlContent(), "text/html; charset="
						+ ENCODING);
				mp.addBodyPart(mbp1);
				for (int i = 0; i < fileList.size(); i++) {
					String tmpFileName = (String) fileList.get(i);
					MimeBodyPart mbp2 = new MimeBodyPart();
					// attach the file to the message
					FileDataSource fds = new FileDataSource(tmpFileName);
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());
					mp.addBodyPart(mbp2);
				}
				msg.setContent(mp);
			}
			msg.setRecipients(Message.RecipientType.TO, mail.getReceiverList());
			LOG.info("邮件发送 中   2");
			InternetAddress[] receiverList = mail.getReceiverList();
			for (InternetAddress r : receiverList) {
				LOG.info("邮件发送至:  -->" + r.getAddress());
			}
			LOG.info("邮件发送 中  3");
			Transport tran = session.getTransport("smtp");
			tran.connect(HOST, USERNAME, PASSWORD);
			tran.sendMessage(msg, msg.getAllRecipients()); // 发送
			
			LOG.info("邮件发送 中   4");
			LOG.info("邮件发送成功");
			return true;
		} catch (Exception ex) {
			LOG.info("邮件发送失败 ERROR"+ex.getMessage());
			throw new RuntimeException(ex.getMessage());
		}
	}

	public boolean sendHtml(int aprvId, String fromAddr, String fromName,
			String toAddr, InternetAddress[] ccsList,
			InternetAddress[] bccList, String subject, String body,
			List fileList) {
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", HOST);
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			if (fromName != null)
				msg.setFrom(new InternetAddress(fromAddr, fromName, ENCODING));
			else
				msg.setFrom(new InternetAddress(fromAddr));

			if (ENVIRONMENT.trim().equals("LIVE"))
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(toAddr, false));
			else
				msg.setRecipient(Message.RecipientType.TO, TEST_ADDRESS);

			if (ccsList != null) {
				if (ENVIRONMENT.trim().equals("LIVE"))
					msg.setRecipients(Message.RecipientType.CC, ccsList);
				else
					msg.setRecipient(Message.RecipientType.CC, TEST_ADDRESS);
			}

			if (bccList != null) {
				if (ENVIRONMENT.trim().equals("LIVE"))
					msg.setRecipients(Message.RecipientType.BCC, bccList);
				else
					msg.setRecipient(Message.RecipientType.BCC, TEST_ADDRESS);
			}

			msg.setSubject(subject, ENCODING);

			if ((fileList == null) || (fileList.size() == 0)) {
				msg.setContent(body, "text/html; charset=" + ENCODING);
			} else {
				for (int i = 0; i < fileList.size(); i++) {
					String tmpFileName = (String) fileList.get(i);
					MimeBodyPart mbp1 = new MimeBodyPart();
					mbp1.setContent(tmpFileName, "text/html; charset="
							+ ENCODING);

					MimeBodyPart mbp2 = new MimeBodyPart();
					// attach the file to the message
					FileDataSource fds = new FileDataSource(tmpFileName);
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());

					// create the Multipart and its parts to it
					Multipart mp = new MimeMultipart();
					mp.addBodyPart(mbp1);
					mp.addBodyPart(mbp2);

					// add the Multipart to the message
					msg.setContent(mp);
				}
			}

			String aprvID = Integer.toString(aprvId);
			msg.setHeader("X-Mailer", MAILER + aprvID);

			msg.setSentDate(new Date());

			Transport.send(msg);
			return true;
		} catch (Exception e) {
			LOG.error("Cannot send mail. From=" + fromAddr + ", To=" + toAddr
					+ ",CCS=" + asString(ccsList) + ",BCC=" + asString(bccList)
					+ ", Subject=" + subject, e);
			return false;
		}
	}

	public boolean sendHtml(int aprvId, String fromAddr, String fromName,
			InternetAddress[] toList, InternetAddress[] ccsList,
			InternetAddress[] bccList, String subject, String body,
			List fileList) {
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", HOST);
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);

			if (fromName != null)
				msg.setFrom(new InternetAddress(fromAddr, fromName, ENCODING));
			else
				msg.setFrom(new InternetAddress(fromAddr));

			if (ENVIRONMENT.trim().equals("LIVE"))
				msg.setRecipients(Message.RecipientType.TO, toList);
			else
				msg.setRecipient(Message.RecipientType.TO, TEST_ADDRESS);

			if (ccsList != null) {
				if (ENVIRONMENT.trim().equals("LIVE"))
					msg.setRecipients(Message.RecipientType.CC, ccsList);
				else
					msg.setRecipient(Message.RecipientType.CC, TEST_ADDRESS);
			}

			if (bccList != null) {
				if (ENVIRONMENT.trim().equals("LIVE"))
					msg.setRecipients(Message.RecipientType.BCC, bccList);
				else
					msg.setRecipient(Message.RecipientType.BCC, TEST_ADDRESS);
			}

			msg.setSubject(subject, ENCODING);

			if ((fileList == null) || (fileList.size() == 0)) {
				msg.setContent(body, "text/html; charset=" + ENCODING);
			} else {
				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setText(body);
				mbp1.setContent(body, "text/html; charset=" + ENCODING);
				mp.addBodyPart(mbp1);
				for (int i = 0; i < fileList.size(); i++) {
					String tmpFileName = (String) fileList.get(i);

					MimeBodyPart mbp2 = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(tmpFileName);
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(fds.getName());

					mp.addBodyPart(mbp2);
				}
				msg.setContent(mp);
			}

			String aprvID = Integer.toString(aprvId);
			msg.setHeader("X-Mailer", MAILER + aprvID);

			msg.setSentDate(new Date());
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			LOG.error("Cannot send mail. From=" + fromAddr + ", To="
					+ asString(toList) + ",CCS=" + asString(ccsList) + ",BCC="
					+ asString(bccList) + ", Subject=" + subject, e);
			return false;
		}
	}

	public String asString(InternetAddress[] addresses) {
		String result = "";
		for (int i = 0; i < addresses.length; i++) {
			result += (addresses[i].getAddress() + ";");
		}
		return result;
	}

}