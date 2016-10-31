package com.javid.connection;

public class DBConnectionFactoryProducer {

	public static DBConnectionFactory getDBConnectionFactory(String hostType, String host, int port, String sid, String service,
			 String dbUserName, String dbPassword) {
		DBConnectionFactory  f = null;
		switch (hostType.toUpperCase()){
			case "ORACLE" :
				f = new OracleDBConnectionFactory(host,port,sid,dbUserName,dbPassword,service);
				break;
		}
		return f;
	}
	
}
