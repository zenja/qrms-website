package com.qrms.action.mobile;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.ErrorReport;
import com.qrms.service.mobile.IErrorReportService;

/**
 * Description: this action maps the error reporting function
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class ReportErrorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	IErrorReportService errorReportService = null;
	String strResult;
	ErrorReport errorReport = null;

	public IErrorReportService getErrorReportService() {
		return errorReportService;
	}

	public void setErrorReportService(IErrorReportService errorReportService) {
		this.errorReportService = errorReportService;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public ErrorReport getErrorReport() {
		return errorReport;
	}

	public void setErrorReport(ErrorReport errorReport) {
		this.errorReport = errorReport;
	}

	/**
	 * call the ErrorReportService to do the error reporting function
	 * 
	 * @return String
	 */
	public String execute() {
		strResult = SUCCESS;
		errorReportService.reportError(errorReport);
		return "strResult";
	}
}
