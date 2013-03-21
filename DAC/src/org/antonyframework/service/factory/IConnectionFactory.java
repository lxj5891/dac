package org.antonyframework.service.factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DataBase Connection 
*/
public interface IConnectionFactory {

	public static final int DB_COMBO = 0; 

	public static final int DB_DEV = 1; 
	
	public static final int DB_SYS = 2; 
	
	public abstract Connection getConnection()throws SQLException;
	
}