package com.javid.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javid.exception.ApplicationServiceException;
import com.javid.service.BaseService;
import com.javid.util.ApplicationUtil;
import com.javid.vo.RequestVO;
import com.javid.vo.ResponseVO;

/**
 * The Class BaseController.
 */
@Controller
public class BaseController {

	/** The Constant logger. */
	private final static Logger logger = Logger.getLogger(BaseController.class);
	
	/** The base service. */
	@Autowired
	BaseService baseService = null;
	
	/** The data. */
	private StringBuffer data = null;

	/**
	 * Check database connection.
	 *
	 * @param requestVO the request VO
	 * @return the response VO
	 */
	@RequestMapping(value = "/checkDatabaseConnection", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	@ResponseBody public ResponseVO checkDatabaseConnection(@RequestBody RequestVO requestVO) {
		ResponseVO vo = new ResponseVO();
		try {
			baseService.checkDatabaseConnection(requestVO);
			vo.setResponseCode("success");
			vo.setResponseDesc("Database Connection Successful.");
		} catch(ApplicationServiceException e) {
			vo.setResponseCode("fail");
			vo.setResult(e.getErrorMessage());
			logger.error("BaseController.checkDatabaseConnection failed. Error details :: "+ ApplicationUtil.getExceptionStackTrace(e));
		}
		return vo;
	}
	
	/**
	 * Download data.
	 *
	 * @param requestVO the request VO
	 * @return the response VO
	 */
	@RequestMapping(value = "/downloadData", method = RequestMethod.POST)
	@ResponseBody public ResponseVO downloadData(@RequestBody RequestVO requestVO) {
		ResponseVO vo = new ResponseVO();
		try {
			data = baseService.downloadData(requestVO);
			vo.setResponseCode("success");
			vo.setResult(data);
		} catch(ApplicationServiceException e) {
			vo.setResponseCode("fail");
			vo.setResult(e.getErrorMessage());
			logger.error("BaseController.downloadData failed. Error details :: "+ ApplicationUtil.getExceptionStackTrace(e));
		} 
		return vo;
	}
	
	/**
	 * Download file.
	 *
	 * @param response the response
	 * @return the response VO
	 */
	@RequestMapping(value = "/downloadFile")
	@ResponseBody public ResponseVO downloadFile(HttpServletResponse response) {
		ResponseVO vo = new ResponseVO();
		try {
			InputStream is = new ByteArrayInputStream(data.toString().getBytes());
			String fileName = "DownloadData.csv";
			// MIME type of the file
			response.setContentType("text/csv");
			// Response header
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			// Read from the file and write into the response
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			os.flush();
			os.close();
			is.close();
			vo.setResponseCode("success");
			vo.setResult(data);
		} catch(Exception e){
			vo.setResponseCode("fail");
			vo.setResult(ApplicationUtil.getExceptionStackTraceFirstLine(e));
			logger.error("BaseController.downloadFile failed. Error details :: "+ ApplicationUtil.getExceptionStackTrace(e));
		} 
		return vo;
	}
	
}