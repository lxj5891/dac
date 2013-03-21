package com.antony.mail;

import java.util.List;

import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailSender;

import com.antony.mail.task.RejectMailTask;

public class TestMail {
	public static void main(String[] args) {

		RejectMailTask task = new RejectMailTask();

		try {
			List<MailBEAN> mailList = task.getMailList();
			for (MailBEAN m : mailList) {
				MailSender sender = new MailSender();
				sender.send(m);
				Thread.sleep(60000);

			}
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
