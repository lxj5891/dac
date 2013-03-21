/*
 * @(#) MailThread.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */
//by ������.2012.05.17. �����ϴ� �����Դϴ�.
package org.antonyframework.support.mail;

import javax.mail.internet.InternetAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

import org.antonyframework.service.factory.ConnectionFactoryManager;
import org.antonyframework.service.factory.IConnectionFactory;
import org.antonyframework.support.mail.MailBEAN;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  sendmail class
 * 
 * @system : Utilily
 * @sub system : Project Standard Infomation
 * @author : Hong Y.C
 * @date : 2002/11/23
 * 
 * 
 */

public class MailThread implements Runnable {

	private static final Log LOG = LogFactory.getLog(MailThread.class);

	private static IConnectionFactory connectionFactory = ConnectionFactoryManager
			.getFactory(IConnectionFactory.DB_DEV);

	protected Connection getConnection() throws SQLException {
		return connectionFactory.getConnection();
	}

	/** member description */
	private Vector vector = new Vector();
	private boolean runFlag = true;

	private EPMSMTP smtp = new EPMSMTP(null, null, null);
	private YMSMTP ysmtp = new YMSMTP(null, null, null);
	private String ENVIRONMENT = "LIVE";
	/* Getting EJB Object, and Using to invoke EJB Object */
	Timer timer = null;
	Thread thread = null;

	private static Connection con;
	private static PreparedStatement pstm;
	private static final String SET_MAIL_STATUS_Y = "update cm3001 set status  = 'Y',senddate = now() where id = ?";
	private static final String SET_MAIL_STATUS_N = "update cm3001 set status  = 'N',senddate = now() where id = ?";

	public MailThread() {
		try {
			con = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		int delay = 1000;
		// timer = new Timer(true);
		// timer.schedule(new EPMTimerTask(), 10000, delay * 60000);
	}

	public void putMail(MailBEAN mBean) {
		synchronized (vector) {
			if (mBean == null)
				return;
			if (vector.isEmpty() && (thread == null || !thread.isAlive())) {
				vector.add(mBean);
				thread = new Thread(this);
				thread.start();
				LOG.debug("Mail Thread started.");
			} else {
				vector.add(mBean);
			}
		}
	}

	public MailBEAN getMail() {
		MailBEAN mBean = null;
		if (!vector.isEmpty()) {
			mBean = (MailBEAN) vector.firstElement();
			vector.remove(0);
		}
		return mBean;
	}

	public void close() {
		try {
			runFlag = false;
			// timer.cancel();
			// timer = null;
		} catch (Exception e) {
			LOG.warn("Cannot close MailThread.", e);
		}
	}

	protected void finalize() {
		try {
			runFlag = false;
			// timer.cancel();
			// thread.destroy();
		} catch (Exception e) {
		}
	}

	public void run() {
		while (runFlag) {
			try {
				LOG.info("Runing MailThread.");
				Thread.sleep(500);
				MailBEAN mBean = null;
				synchronized (vector) {
					mBean = getMail();
					if (mBean == null)
						break;
				}
				sendMail(mBean);
			} catch (Exception e) {
				LOG.error("Cannot run MailThread.", e);
			}
		}
	}

	private boolean sendMail(MailBEAN mBean) throws Exception {
		boolean flag = false;
		try {
			InternetAddress[] receiverList = mBean.getReceiverList();
			LOG.info("test:" + mBean.asString(receiverList));
			String str = mBean.asString(receiverList);
			if (receiverList.length == 1
					&& (str.indexOf("sina") > -1 || str.indexOf("@ycombo") > -1 || str
							.indexOf("@gmail") > -1))
				ysmtp.send(mBean);
			else
				smtp.send(mBean);

			if (mBean.dbFlag) {
				if (con == null)
					con = getConnection();
				pstm = con.prepareStatement(SET_MAIL_STATUS_Y);

				pstm.setObject(1, mBean.getId());
				LOG.info("set maildb success  mail id is " + mBean.getId()
						+ "flag" + pstm.execute());

				pstm.close();
			}
		} catch (Exception e) {
			if (mBean.dbFlag) {
				pstm = con.prepareStatement(SET_MAIL_STATUS_N);

				pstm.setObject(1, mBean.getId());
				LOG.error("set maildb success  mail id is " + mBean.getId()
						+ "flag" + pstm.execute());

				LOG.error("Cannot send Mail.", e);
			}
			return false;
		}
		return flag;
	}

	class EPMTimerTask extends TimerTask {
		public void run() {
			if (ENVIRONMENT.trim().equals("LIVE")) {
				LOG.info("Try to send failed mail.");
				try {
					/*
					 * MailEO mEO = (MailEO)
					 * ejbFactory.getInstance(MailHO.class); List mailList =
					 * mEO.getMailFailedList(); for (int i = 0; i <
					 * mailList.size(); i++) { MailBEAN mail = (MailBEAN)
					 * mailList.get(i); String from = mail.getSenderAddr();
					 * String name = mail.getSenderName(); String to =
					 * mail.getReceiverAddr(); String subject =
					 * mail.getSubject() ; String content = mail.getContent();
					 * boolean flag = smtp.sendHtml(0,from, name, to, null,
					 * null, subject, content); if (flag) //��� ���� update
					 * mEO.updateMailFailed(mail.getId(), true); else //��� ����
					 * update mEO.updateMailFailed(mail.getId(), false); }
					 */
				} catch (Exception e) {
					LOG.warn("Cannot send failed mail.");
				}
			}
		}
	}
}