package com.javid.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * The Class DBUtil.
 */
public class DBUtil {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DBUtil.class);

	/**
	 * Close connection.
	 *
	 * @param con the con
	 * @param rs the rs
	 * @param ps the ps
	 */
	public static void closeConnection(Connection con,ResultSet rs,PreparedStatement ps) {
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Error occured while closing the ResultSet. Error Message::" + e.getMessage());
			}
		}
		if (ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error("Error occured while closing the PreparedStatement. Error Message::" + e.getMessage());
			}
		}
		if (con != null){
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				logger.error("Error occured while closing the connection. Error Message::" + e.getMessage());
			}
		}
	}

	/**
	 * Gets the oracle SID connection.
	 *
	 * @param host the host
	 * @param port the port
	 * @param sid the sid
	 * @param username the username
	 * @param password the password
	 * @return the oracle SID connection
	 */
	public static Connection getOracleSIDConnection(String host, int port, String sid, String username, String password) {
		Connection conn = null;
		Driver driver = null;
		Properties properties = null;
		String URL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
		try {
			properties = new Properties();
			properties.put("user", username);
			properties.put("password", password);
			//properties.put("oracle.jdbc.allowedLogonVersion", 8);
			driver = (Driver) Class.forName("oracle.jdbc.driver.OracleDriver",true, DBUtil.class.getClassLoader()).newInstance();
			conn = driver.connect(URL, properties);
		} catch (SQLException e) {
			logger.error("Got error while creating oracle connection." + ApplicationUtil.getExceptionStackTrace(e));
		} catch (Exception e) {
			logger.error("Got error while creating oracle connection." + ApplicationUtil.getExceptionStackTrace(e));
		}
		return conn;
	}

	/**
	 * Gets the oracle service connection.
	 *
	 * @param host the host
	 * @param port the port
	 * @param serviceName the service name
	 * @param username the username
	 * @param password the password
	 * @return the oracle service connection
	 */
	public static Connection getOracleServiceConnection(String host, int port, String serviceName, String username, String password) {
		Connection conn = null;
		Driver driver = null;
		Properties properties = null;
		String URL = "jdbc:oracle:thin:@" + host + ":" + port + "/"	+ serviceName;
		try {
			properties = new Properties();
			properties.put("user", username);
			properties.put("password", password);
			//properties.put("oracle.jdbc.allowedLogonVersion", 8);
			driver = (Driver) Class.forName("oracle.jdbc.driver.OracleDriver",true, DBUtil.class.getClassLoader()).newInstance();
			conn = driver.connect(URL, properties);
		} catch (SQLException e) {
			logger.error("Got error while creating oracle connection." + ApplicationUtil.getExceptionStackTrace(e));
		} catch (Exception e) {
			logger.error("Got error while creating oracle connection." + ApplicationUtil.getExceptionStackTrace(e));
		}
		return conn;
	}

}
