package org.antonyframework.service.common;

import java.sql.Connection;
import java.sql.SQLException;

import org.antonyframework.service.factory.ConnectionFactoryManager;
import org.antonyframework.service.factory.IConnectionFactory;

/**
 * Service基类
 * 
 * @author Nanlei
 * 
 */
public abstract class BaseService extends CommonBaseService {

	private static IConnectionFactory connectionFactory = ConnectionFactoryManager
			.getFactory(IConnectionFactory.DB_COMBO);

	protected Connection getConnection() throws SQLException {
		return connectionFactory.getConnection();
	}

	protected void closeConnection(Connection con) {
		if (con == null)
			return;
		try {
			if (!con.getAutoCommit())
				con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void rollback(Connection con) {
		if (con == null)
			return;
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void commit(Connection con) {
		if (con == null)
			return;
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
