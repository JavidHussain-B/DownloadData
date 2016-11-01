package com.javid.serviceImpl;

import org.apache.log4j.Logger;

import com.javid.connection.DBConnectionFactory;
import com.javid.connection.DBConnectionFactoryProducer;
import com.javid.exception.ApplicationServiceException;
import com.javid.service.BaseService;
import com.javid.util.ApplicationUtil;
import com.javid.vo.RequestVO;

/**
 * The Class BaseServiceImpl.
 */
public class BaseServiceImpl implements BaseService {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(BaseServiceImpl.class);

	/**
	 * Check database connection.
	 *
	 * @param requestVO the request VO
	 * @throws ApplicationServiceException the application service exception
	 */
	public void checkDatabaseConnection(RequestVO requestVO) throws ApplicationServiceException {
		DBConnectionFactory factory = null;
		try {
			if(requestVO.getDbType().equals("ORACLE")) {
				factory = DBConnectionFactoryProducer.getDBConnectionFactory(requestVO.getDbType(), requestVO.getHostName(), requestVO.getPort(), requestVO.getSid(), requestVO.getServiceName(),
						requestVO.getDbUserName(), requestVO.getDbPassword());
				factory.getConnection();
				if(factory.getErrorMsg() != null) {
					throw new ApplicationServiceException("ERROR-500",factory.getErrorMsg());
				}
			}
		} catch(Exception e) {
			logger.error("Error Occurred in BaseServiceImpl.checkDatabaseConnection" + ApplicationUtil.getExceptionStackTrace(e));
			throw new ApplicationServiceException("ERROR-500",ApplicationUtil.getExceptionStackTraceFirstLine(e));
		} finally {
			if(factory != null) {
				factory.closeConnection();
			}
		}
		
	}

	/**
	 * Download data.
	 *
	 * @param requestVO the request VO
	 * @return the string buffer
	 * @throws ApplicationServiceException the application service exception
	 */
	@Override
	public StringBuffer downloadData(RequestVO requestVO) throws ApplicationServiceException {
		StringBuffer data = null;
		DBConnectionFactory factory = null;
		try {
			factory = DBConnectionFactoryProducer.getDBConnectionFactory(requestVO.getDbType(), requestVO.getHostName(), requestVO.getPort(), requestVO.getSid(), requestVO.getServiceName(),
					requestVO.getDbUserName(), requestVO.getDbPassword());
			factory.getConnection();
			if(factory.getErrorMsg() != null) {
				throw new ApplicationServiceException("ERROR-500",factory.getErrorMsg());
			}
			data = factory.getData(requestVO.getSqlQuery());
			if(factory.getErrorMsg() != null) {
				throw new ApplicationServiceException("ERROR-500",factory.getErrorMsg());
			}
		} catch(Exception e) {
			logger.error("Error Occurred in BaseServiceImpl.downloadData" + ApplicationUtil.getExceptionStackTrace(e));
			throw new ApplicationServiceException("ERROR-500",ApplicationUtil.getExceptionStackTraceFirstLine(e));
		} finally {
			if(factory != null) {
				factory.closeConnection();
			}
		}
		return data;
	}
}
