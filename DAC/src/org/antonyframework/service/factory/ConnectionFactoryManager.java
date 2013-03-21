/*
 * @(#) ConFactoryMgr.java
 * Copyright 2002 by SK C&C. All rights reserved.
 * �� Program�� �Ϻ� �Ǵ� ��θ� SK C&C���� ���Ǿ��� 
 * ����, ����, �����ϴ� ������ ������ �����Ǿ� �ֽ��ϴ�.
 */
package org.antonyframework.service.factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DataBase Connection Factory Class�� Manager
 */
public abstract class ConnectionFactoryManager implements IConnectionFactory {

	public abstract Connection getConnection() throws SQLException;

	public static synchronized IConnectionFactory getFactory(int factoryType) {
		switch (factoryType) {
		case IConnectionFactory.DB_COMBO:
			return COMBOConnectionFactory.getInstance();
		case IConnectionFactory.DB_DEV:
			return DEVConnectionFactory.getInstance();
		case IConnectionFactory.DB_SYS:
			return SYSConnectionFactory.getInstance();
		default:
			return DEVConnectionFactory.getInstance();
		}
	}
}