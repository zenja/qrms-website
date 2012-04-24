package com.qrms.service.mobile;

import com.qrms.bean.ErrorReport;

/**
 * Description: the interface of the ErrorReportServiceImpl,it provides the
 * reportError methods to save the error infos to DB
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public interface IErrorReportService {

	public void reportError(ErrorReport err);

}
