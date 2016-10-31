package com.javid.service;

import com.javid.exception.ApplicationServiceException;
import com.javid.vo.RequestVO;

public interface BaseService {

	void checkDatabaseConnection(RequestVO requestVO) throws ApplicationServiceException;

}
