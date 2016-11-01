package com.javid.connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.log4j.Logger;

import com.javid.util.ApplicationConstants;
import com.javid.util.ApplicationUtil;
import com.javid.util.DBUtil;

/**
 * A factory for creating OracleDBConnection objects.
 */
public class OracleDBConnectionFactory extends DBConnectionFactory {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(OracleDBConnectionFactory.class);

	/** The host. */
	private String host;
	
	/** The port. */
	private int port;
	
	/** The sid. */
	private String sid;
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The service. */
	private String service;
	
	/** The error msg. */
	private String errorMsg;
	
	/**
	 * Instantiates a new oracle DB connection factory.
	 *
	 * @param host the host
	 * @param port the port
	 * @param sid the sid
	 * @param username the username
	 * @param password the password
	 * @param service the service
	 */
	public OracleDBConnectionFactory(String host, int port, String sid, String username, String password, String service) {
		super();
		this.host = host;
		this.port = port;
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.service = service;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	@Override
	public void getConnection() {
		try {
			if (host != null && port != 0 && sid != null && username != null && password != null){
			    connection = DBUtil.getOracleSIDConnection(host,port,sid,username,password);
			}else if (host != null && port != 0 && service != null && username != null && password != null){
				connection = DBUtil.getOracleServiceConnection(host,port,service,username,password);
			}
		} catch(Exception e) {
			logger.error("Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTrace(e));
			errorMsg = "Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTraceFirstLine(e);
		}
	}

	/**
	 * Close connection.
	 */
	@Override
	public void closeConnection() {
		try {
			DBUtil.closeConnection(connection,null,null);
		} catch(Exception e) {
			logger.error("Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTrace(e));
			errorMsg = "Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTraceFirstLine(e);
		}
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Gets the data.
	 *
	 * @param sqlQuery the sql query
	 * @return the data
	 */
	@Override
	public StringBuffer getData(String sqlQuery) {
		StringBuffer data = new StringBuffer();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setFetchSize(ApplicationConstants.REC_FETCH_SIZE);
			rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int size = 1;
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				data.append(rsmd.getColumnLabel(i)).append(",");
				size++;
			}
			data.append("\n");
			while (rs.next()) {
				for(int i = 1; i < size; i++) {
					if(null != rs.getObject(i)) {
						data.append(rs.getObject(i)).append(",");
					} else {
						data.append("").append(",");
					}
				}
				data.append("\n");
		    }
		} catch (Exception e) {
			logger.error("Exception occured in getData()" + ApplicationUtil.getExceptionStackTrace(e));
			errorMsg = "Error occurred while getting Data :: " + ApplicationUtil.getExceptionStackTraceFirstLine(e);
		} finally {
			DBUtil.closeConnection(connection,rs,preparedStatement);
			logger.debug("Exiting getData method...!!");
		}
		return data;
	}

}
