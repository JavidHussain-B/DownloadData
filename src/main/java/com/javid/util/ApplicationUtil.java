package com.javid.util;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * This class is utility class, which will provide some utility method to WBS Self Care app.
 * 
 * @author Javid Hussain
 *
 */
public class ApplicationUtil {
	
	public static final String YES = "YES";

	private ApplicationUtil() {
		
	}

	/**
	 * @author Javid Hussain
	 * Gets the exception stack trace.
	 *
	 * @param exception the exception
	 * @return the error stack trace
	 */
	public static String getExceptionStackTrace(Exception exception) {
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	/**
	 * @author Javid Hussain
	 * Gets the error stack trace.
	 *
	 * @param error the error
	 * @return the error stack trace
	 */
	public static String getErrorStackTrace(Error error) {
		StringWriter sw = new StringWriter();
		error.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}
	
	
	/**
	 * Gets the system user name.
	 * @author Javid Hussain
	 *
	 * @return the system user name
	 */
	public static String getSystemUserName() {
		return System.getProperty("user.name");
	}

	/**
	 * Gets the exception stack trace first line.
	 *
	 * @param e the e
	 * @return the exception stack trace first line
	 */
	public static String getExceptionStackTraceFirstLine(Exception e) {
		String[] errorMsg = e.getMessage().split("\\r?\\n");
		return errorMsg[0];
	}

}
