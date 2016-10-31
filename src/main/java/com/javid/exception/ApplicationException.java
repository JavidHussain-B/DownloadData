package com.javid.exception;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionMsg;

	public ApplicationException(String exceptionMsg){
		this.exceptionMsg = exceptionMsg;
	}
	
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	
	public void setExceptionMsg(String exceptionMsg){
		this.exceptionMsg = exceptionMsg;
	}
}