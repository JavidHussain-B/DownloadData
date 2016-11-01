package com.javid.connection;

/**
 * The Class DBConnectionFactoryProducer.
 */
public class DBConnectionFactoryProducer {

	/**
	 * Gets the DB connection factory.
	 *
	 * @param hostType the host type
	 * @param host the host
	 * @param port the port
	 * @param sid the sid
	 * @param service the service
	 * @param dbUserName the db user name
	 * @param dbPassword the db password
	 * @return the DB connection factory
	 */
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
