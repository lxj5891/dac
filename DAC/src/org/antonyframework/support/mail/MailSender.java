package org.antonyframework.support.mail;

import java.util.Date;
import java.util.Properties;
import java.util.List;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.antony.mail.task.RejectMailTask;

public class MailSender {

	// 判断运行的 环境
	private final boolean DEBUG = false;

	private static final Log log = LogFactory.getLog(RejectMailTask.class);

	// 配置smtp
	private static final String SMTP = "42.121.96.228";

	private static final String USERNAME = "test";

	private static final String PASSWORD = "1234";

	private static final String ENCODING = "utf-8";

	private static InternetAddress TEST_ADDRESS;

	static {
		try {
			TEST_ADDRESS = new InternetAddress("ycombo@ycombo.com");
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}

	public void send(MailBEAN mail) {
		log.info("邮件发送开始");
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", SMTP);
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.port", "25");
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ycombo@ycombo.com"));
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

			InternetAddress[] receiverList = mail.getReceiverList();
			for (InternetAddress r : receiverList) {
				log.info("邮件发送至:  -->" + r.getAddress());
			}

			Transport tran = session.getTransport("smtp");
			tran.connect(SMTP, USERNAME, PASSWORD);
			tran.sendMessage(msg, msg.getAllRecipients()); // 发送
			log.info("邮件发送成功");
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
