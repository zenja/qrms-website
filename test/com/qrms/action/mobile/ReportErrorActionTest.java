package com.qrms.action.mobile;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.ErrorReport;
import com.qrms.service.mobile.IErrorReportService;

/**
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class ReportErrorActionTest extends TestCase {

	MockControl control;
	ReportErrorAction action;
	IErrorReportService mock;
	ErrorReport er;

	protected void setUp() throws Exception {
		super.setUp();
		er = new ErrorReport();
		control = MockControl.createControl(IErrorReportService.class);
		mock = (IErrorReportService) control.getMock();

		mock.reportError(er);
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new ReportErrorAction();
		action.setErrorReportService(mock);
		action.setErrorReport(er);
		action.execute();
		assertNotNull(action.getStrResult());
	}
}
