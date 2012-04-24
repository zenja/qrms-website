package com.qrms.dao.impl.mobile;

import com.qrms.bean.ErrorReport;
import com.qrms.dao.IErrorReportDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class ErrorReportDAOImplTest extends BaseDAOTestCase {
	private IErrorReportDAO errorReportDao;
	private ErrorReport errorReport;

	private final String MSG = "Test msg";
	private final int REPORTERID = 1;
	private final int STRONGHOLDID = 1;

	public IErrorReportDAO getErrorReportDao() {
		return errorReportDao;
	}

	public void setErrorReportDao(IErrorReportDAO errorReportDao) {
		this.errorReportDao = errorReportDao;
	}

	public void onSetUpInTransaction() {
		errorReport = new ErrorReport();
		errorReport.setErrormsg(MSG);
		errorReport.setReporterid(REPORTERID);
		errorReport.setStrongholdid(STRONGHOLDID);
		// errorReportDao.save(errorReport);
	}

	public void testSave() {
		errorReportDao.save(errorReport);
		assertNotNull(errorReportDao.findById(errorReport.getId()));
	}

	public void testDelete() {
		errorReportDao.save(errorReport);
		errorReportDao.delete(errorReport);
		assertNull(errorReportDao.findById(errorReport.getId()));
	}

	public void testFindById() {
		assertNotNull(errorReportDao.findById(errorReport.getId()));
	}

	public void testFindByExample() {
		assertTrue(errorReportDao.findByExample(errorReport).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(errorReportDao.findByProperty("id", errorReport.getId())
				.size() > 0);
	}

	public void testFindByStrongholdid() {
		assertTrue(errorReportDao.findByStrongholdid(STRONGHOLDID).size() > 0);
	}

	public void testFindByReporterid() {
		assertTrue(errorReportDao.findByReporterid(REPORTERID).size() > 0);
	}

	public void testFindByErrormsg() {
		assertTrue(errorReportDao.findByErrormsg(MSG).size() > 0);
	}

	public void testFindAll() {
		assertTrue(errorReportDao.findAll().size() > 0);
	}

}
