package com.qrms.service.impl.mobile;

import com.qrms.bean.ErrorReport;
import com.qrms.dao.IErrorReportDAO;
import com.qrms.service.mobile.IErrorReportService;

/**
 * Description: this service deals with the Error-reporting functions
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public class ErrorReportService implements IErrorReportService {
	IErrorReportDAO errorReportDao = null;

	public IErrorReportDAO getErrorReportDao() {
		return errorReportDao;
	}

	public void setErrorReportDao(IErrorReportDAO errorReportDao) {
		this.errorReportDao = errorReportDao;
	}

	/**
	 * save the error information to the database
	 * 
	 * @param err:the error information
	 */
	public void reportError(ErrorReport err) {
		errorReportDao.save(err);
	}

}
