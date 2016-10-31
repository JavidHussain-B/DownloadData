package com.javid.connection;

import org.apache.log4j.Logger;

import com.javid.util.ApplicationUtil;
import com.javid.util.DBUtil;

public class OracleDBConnectionFactory extends DBConnectionFactory {
	
	private static final Logger logger = Logger.getLogger(OracleDBConnectionFactory.class);

	private String host;
	private int port;
	private String sid;
	private String username;
	private String password;
	private String service;
	private String errorMsg;
	
	public OracleDBConnectionFactory(String host, int port, String sid, String username, String password, String service) {
		super();
		this.host = host;
		this.port = port;
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.service = service;
	}

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

	@Override
	public void closeConnection() {
		try {
			DBUtil.closeConnection(connection,null,null);
		} catch(Exception e) {
			logger.error("Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTrace(e));
			errorMsg = "Error occurred while establishing connection :: " + ApplicationUtil.getExceptionStackTraceFirstLine(e);
		}
	}

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

}
