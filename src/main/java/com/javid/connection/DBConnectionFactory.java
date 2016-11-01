package com.javid.connection;

import java.sql.Connection;

public abstract class DBConnectionFactory {

	public Connection connection = null;

	public abstract void getConnection();

	public abstract void closeConnection();
	
	public abstract String getErrorMsg();

	public abstract StringBuffer getData(String sqlQuery);

}
