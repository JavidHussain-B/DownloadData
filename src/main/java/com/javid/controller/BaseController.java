package com.javid.controller;

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

@Controller
public class BaseController {

	private final static Logger logger = Logger.getLogger(BaseController.class);
	
	@Autowired
	BaseService baseService = null;

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
			logger.error("UserManagementController.AddUserGroup failed. Error details :: "+ ApplicationUtil.getExceptionStackTrace(e));
		}
		return vo;
	}


}