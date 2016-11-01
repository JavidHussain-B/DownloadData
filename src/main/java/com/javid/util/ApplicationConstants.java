package com.javid.util;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ApplicationConstants.
 */
public class ApplicationConstants {
	
	/**
	 * Instantiates a new Application constants.
	 */
	private ApplicationConstants() {
		
	}

	/** The Constant SUCCESS. */
	public static final String SUCCESS = "SUCCESS";
	
	/** The Constant FAILURE. */
	public static final String FAILURE = "ERROR";
	
	/** The Constant REC_FETCH_SIZE. */
	public static final int REC_FETCH_SIZE = 500;

	/** The Constant ERROR_CODES_RESOL. */
	// Map to handle exceptions
	public static final Map<String, String> ERROR_CODES_RESOL;
	static {
		ERROR_CODES_RESOL = new HashMap<String, String>();
		ERROR_CODES_RESOL.put("ERROR-500", "{0}");
	}
	
}
