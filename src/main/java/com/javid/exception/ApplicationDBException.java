package com.javid.exception;

public class ApplicationDBException extends Exception {
	
	private static final long serialVersionUID = -2719409975957714611L;
	private String errorCode = "Unknown_Exception";
	private String errorResolution = "Unknown_Resolution";

	public ApplicationDBException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationDBException(String message, String errorCode, String errorResolution) {
		super(message);
		this.errorCode = errorCode;
		this.errorResolution = errorResolution;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorResolution() {
		return this.errorResolution;
	}

}