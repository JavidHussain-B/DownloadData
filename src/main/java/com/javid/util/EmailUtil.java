package com.javid.util;

import org.apache.log4j.Logger;

public class EmailUtil {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EmailUtil.class);
	
	/*public static void triggerMail(EmailVO vo) throws WbsServiceException {
	    try{
	    	Properties properties = System.getProperties();  
		    properties.setProperty("mail.smtp.host", vo.getSmtpServerAddress());
		    Session session = Session.getDefaultInstance(properties);
	    	MimeMessage message = new MimeMessage(session);  
	        message.setFrom(new InternetAddress(vo.getFromAddress()));  
	        message.addRecipient(Message.RecipientType.TO,new InternetAddress(vo.getToAddress().get(0)));  
	        message.setSubject(vo.getSubject());  
	        message.setText(vo.getEmailBody());  
	        Transport.send(message);  
        }catch (Exception e) {
        	logger.error("Error occurred while triggering email :: " + ApplicationUtil.getExceptionStackTrace(e));
        	throw new WbsServiceException("ERROR-504",ApplicationUtil.getExceptionStackTraceFirstLine(e));
    	}  
	}*/
	
}
