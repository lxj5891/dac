package com.antony.mail.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.antonyframework.service.factory.ConnectionFactoryManager;
import org.antonyframework.service.factory.IConnectionFactory;
import org.antonyframework.support.mail.MailBEAN;

public abstract class MailTask {
	protected String id;
	protected int length;
	protected List<MailBEAN> result = new ArrayList<MailBEAN>();
	public abstract List getMailList() throws Exception;

	protected Connection getConnection(int i) throws Exception {

		IConnectionFactory connectionFactory = ConnectionFactoryManager
				.getFactory(i);
		return connectionFactory.getConnection();
	}

	protected void closeConnection(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	protected void closeStatement(Statement st) throws Exception {
		if (st != null) {
			st.close();
		}
	}
	
	public void init() throws Exception {
		
	}

}
