package com.javid.exception;

import java.text.MessageFormat;

import com.javid.util.ApplicationConstants;

public class ApplicationServiceException extends Exception {

	private static final long serialVersionUID = 8564913943688143354L;
	private String errorMessage = null;
	private String errorCode = "Unknown_Exception";
	private String errorResolution = "Unknown_Resolution";

	public ApplicationServiceException(String errorCode, Object... message) {
		this.errorMessage = MessageFormat.format(ApplicationConstants.ERROR_CODES_RESOL.get(errorCode), message);
		this.errorCode = errorCode;
	}

	public ApplicationServiceException(String message, String errorCode, String errorResolution) {
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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorResolution(String errorResolution) {
		this.errorResolution = errorResolution;
	}

}