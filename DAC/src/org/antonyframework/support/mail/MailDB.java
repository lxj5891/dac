/*
 * @(#) MailDB.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ���
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */

package org.antonyframework.support.mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.antonyframework.service.factory.ConnectionFactoryManager;
import org.antonyframework.service.factory.IConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ���� Data Access Ŭ����
 * 
 * @system : common
 * @sub system :
 * @author : Grace
 * @date : 2003/11/14
 * 
 * @modifying developer :
 * @modifying date :
 * @modifying description :
 */
public class MailDB {

	private static final Log LOG = LogFactory.getLog(MailDB.class);
	private static MailDB instance = null;
	private static IConnectionFactory connectionFactory = ConnectionFactoryManager
			.getFactory(IConnectionFactory.DB_COMBO);

	protected Connection getConnection() throws SQLException {
		return connectionFactory.getConnection();
	}

	private MailDB() {
	}

	public static MailDB getInstance() {
		if (instance == null) {
			instance = new MailDB();
		}
		return instance;
	}

	public int insertMail(MailBEAN mail) {
		try {
			return insertMail(mail, getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}

	public int insertMail(MailBEAN mail, Connection con) throws SQLException {
		StringBuffer query1 = new StringBuffer();
		query1.append("\n insert into  ");
		query1.append("\n 	CM_MAIL_HB(id, sender_addr,sender_name,receiver_addr, ccs, bccs, subject, content, send_date, resend_no, send_status, pjt_no, schedule_type ) ");
		query1.append("\n values  ");
		query1.append("\n 		( seq_cm_mail_hb_id.nextval  ,?,?,?,?,?,?,?,sysdate,?,?,?,?) ");

		int num = 0;
		PreparedStatement pstmt = null;
		LOG.info("insertMail(MailBEAN mail , PJT_NO)  : " + mail);
		try {
			int pstmtNum = 1;
			pstmt = con.prepareStatement(query1.toString());
			pstmt.setString(pstmtNum++, mail.getSenderAddr());
			pstmt.setString(pstmtNum++, mail.getSenderName());
			pstmt.setString(pstmtNum++, mail.getReceiverAddr());
			pstmt.setString(pstmtNum++, mail.getCcs());
			pstmt.setString(pstmtNum++, mail.getBcc());
			pstmt.setString(pstmtNum++, mail.getSubject());
			String content = mail.getContent();

			if (mail.getContent().length() > 1000)
				content = content.substring(0, 1000);
			pstmt.setString(pstmtNum++, content);

			if (mail.getSendStatus().trim().equals("Y"))
				pstmt.setInt(pstmtNum++, 0);
			else
				pstmt.setInt(pstmtNum++, 1);
			pstmt.setString(pstmtNum++, mail.getSendStatus());

			num = pstmt.executeUpdate();
		} catch (SQLException se) {
			LOG.info(
					"insertMail(MailBEAN mail , Connection con)  : \n"
							+ se.toString(), se);
			throw se;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ee) {
			}
		}
		return num;
	}

	/**
	 * ������ ������ �����Ŀ� ������ update�Ѵ�.
	 * 
	 * @param mailID
	 *            ���� ID
	 * @param isSend
	 *            boolean ��ۻ��� (���� �۽�: Y ���� : N )
	 * @param con
	 *            Connection
	 * @return int ������ ���ϰ�
	 * @exception SQLException
	 */
	public int updateMailFailed(long mailID, boolean isSend, Connection con)
			throws SQLException {

		StringBuffer query1 = new StringBuffer();
		query1.append("\n update  ");
		query1.append("\n 		cm_mail_hb ");
		query1.append("\n set ");
		if (!isSend) // �Ǵٽ� ������ ����
			query1.append("\n 		resend_no=resend_no+1   ");
		else
			// ���������� ��۵ɶ�
			query1.append("\n 		send_date=sysdate, send_status='Y' ");
		query1.append("\n where  ");
		query1.append("\n 		id=? ");

		int num = 0;
		PreparedStatement pstmt = null;
		LOG.debug("updateMailFailed(MailBEAN mail, boolean isError, Connection con)  :\n "
				+ query1.toString());
		try {
			pstmt = con.prepareStatement(query1.toString());
			pstmt.setLong(1, mailID);
			num = pstmt.executeUpdate();
		} catch (SQLException se) {
			LOG.error(
					"updateMailFailed(MailBEAN mail, boolean isError, Connection con)  :\n "
							+ se.toString(), se);
			throw se;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ee) {
			}
		}
		return num;
	}

	/**
	 * ���� ��� ������ List�� ��ȯ�Ѵ�.
	 * 
	 * @param con
	 *            Connection
	 * @return List MailBEAN Type List
	 * @exception SQLException
	 */
	public List getMailFailedList(Connection con) throws SQLException {

		StringBuffer query1 = new StringBuffer();
		query1.append("\n select   ");
		query1.append("\n 		id,sender_addr,sender_name, receiver_addr, subject, content  ");
		query1.append("\n from  ");
		query1.append("\n 		cm_mail_hb  ");
		query1.append("\n where   ");
		query1.append("\n 		send_status='N'  ");
		query1.append("\n and	schedule_type is null  ");
		query1.append("\n order by send_date  ");

		List mList = new ArrayList();
		LOG.debug("getMailFailedList(Connection con) : \n" + query1.toString());
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(query1.toString());
			while (rs.next()) {
				MailBEAN mail = new MailBEAN();
				mail.setId(rs.getLong("id"));
				mail.setSenderAddr(rs.getString("sender_addr"));
				mail.setSenderName(rs.getString("sender_name"));
				mail.setReceiverAddr(rs.getString("receiver_addr"));
				mail.setSubject(rs.getString("subject"));
				mail.setContent(rs.getString("content"));
				mList.add(mail);
			}

		} catch (SQLException se) {
			LOG.error("getMailFailedList(Connection con) : \n" + se.toString(),
					se);
			throw se;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ee) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception ee) {
			}

		}
		return mList;
	}

	/**
	 * ���� ��� ������ List�� ��ȯ�Ѵ�.
	 * 
	 * @param con
	 *            Connection
	 * @return List MailBEAN Type List
	 * @exception SQLException
	 */
	public List getScheduleFailedList(Connection con) throws SQLException {

		StringBuffer query1 = new StringBuffer();
		query1.append("\n select   ");
		query1.append("\n 		id,sender_addr,sender_name, receiver_addr, ccs, subject, content  ");
		query1.append("\n from  ");
		query1.append("\n 		cm_mail_hb  ");
		query1.append("\n where   ");
		query1.append("\n 		send_status='N'  ");
		query1.append("\n and	schedule_type is not null  ");
		query1.append("\n order by send_date  ");

		List mList = new ArrayList();
		LOG.debug("getScheduleFailedList(Connection con) : \n"
				+ query1.toString());
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(query1.toString());
			while (rs.next()) {
				MailBEAN mail = new MailBEAN();
				mail.setId(rs.getLong("id"));
				mail.setSenderAddr(rs.getString("sender_addr"));
				mail.setSenderName(rs.getString("sender_name"));
				mail.setReceiverAddr(rs.getString("receiver_addr"));
				mail.setCcs(rs.getString("ccs"));
				mail.setSubject(rs.getString("subject"));
				mail.setContent(rs.getString("content"));
				mList.add(mail);
			}

		} catch (SQLException se) {
			LOG.error("getMailFailedList(Connection con) : \n" + se.toString(),
					se);
			throw se;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ee) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception ee) {
			}

		}
		return mList;
	}
};
