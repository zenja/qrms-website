package com.qrms.dao.impl.mobile;

import com.qrms.bean.QRContent;
import com.qrms.dao.IQRContentDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Wangxing
 * @version 1.0
 */
public class QRContentDAOImplTest extends BaseDAOTestCase {
	IQRContentDAO qrContentDao;

	QRContent qrContent;

	private final String CODE = "LPTAQLTBKFDNSNILCNNOHQFETCNTRSED";
	private final int TYPE = 1;
	private final String CONTENT = "<p><span style=\"font-size: large; color: #000080; background-color: #ffff00;\"><em><strong>Hello, World!!!</strong></em></span></p>";
	private final int GAME_ID = 1;
	private final int SEQUENCE = 0;

	public IQRContentDAO getQrContentDao() {
		return qrContentDao;
	}

	public void setQrContentDao(IQRContentDAO qrContentDao) {
		this.qrContentDao = qrContentDao;
	}

	public void onSetUpInTransaction() {
		qrContent = new QRContent();
		qrContent.setCode(CODE);
		qrContent.setContent(CONTENT);
		qrContent.setGameId(GAME_ID);
		qrContent.setSequence(SEQUENCE);
		qrContent.setType(TYPE);
	}

	public void testSave() {
		qrContentDao.save(qrContent);
		assertNotNull(qrContentDao.findById(qrContent.getId()));
	}

	public void testDelete() {
		qrContentDao.save(qrContent);
		qrContentDao.delete(qrContent);
		assertNull(qrContentDao.findById(qrContent.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(qrContentDao.findById(qrContent.getGameId()));
	}

	public void testFindByExample() {
		assertNotNull(qrContentDao.findByExample(qrContent));
	}

	public void testFindByProperty() {
		assertNotNull(qrContentDao.findByProperty("code", CODE));
	}

	public void testFindByType() {
		assertNotNull(qrContentDao.findByType(TYPE));
	}

	public void testFindByCode() {
		assertNotNull(qrContentDao.findByCode(CODE));
	}

	public void testFindByContent() {
		assertNotNull(qrContentDao.findByContent(CONTENT));
	}

	public void testFindByGameId() {
		assertNotNull(qrContentDao.findByGameId(GAME_ID));
	}

	public void testFindAll() {
		assertTrue(qrContentDao.findAll().size() > 0);
	}

	/*
	 * public void testUpdate() { fail("Not yet implemented"); }
	 */

	public void testFindByGameTypeAndGameId() {
		assertNotNull(qrContentDao.findByGameTypeAndGameId(TYPE, GAME_ID));
	}

}
