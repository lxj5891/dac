package com.antony.mail;

import java.util.List;

import org.antonyframework.support.mail.MailBEAN;
import org.antonyframework.support.mail.MailManager;

import com.antony.mail.task.RejectMailTask;
import com.antony.mail.task.Sm3001MailTask;

public class MailTest {
	private static MailManager mailManager;
	public static void main(String[] args) {
		Sm3001MailTask task = new Sm3001MailTask();
		try {
			List<MailBEAN> mailList = task.getMailList();
			if(mailList != null &&mailList.size() > 0){
				MailBEAN mailBEAN = mailList.get(0);
				mailManager = MailManager.getInstance();
				mailManager.sendMail(mailBEAN);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
