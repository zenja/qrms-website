package com.qrms.dao.impl.mobile;

import java.sql.Timestamp;

import com.qrms.bean.MsgBox;
import com.qrms.dao.IMsgBoxDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class MsgBoxDAOImplTest extends BaseDAOTestCase {
	IMsgBoxDAO msgBoxDao;

	MsgBox msgBox;

	private final String CONTENT = "Happy New Year !";
	private final int RECIEVERID = 0;
	private final boolean CHECKED = false;

	public IMsgBoxDAO getMsgBoxDao() {
		return msgBoxDao;
	}

	public void setMsgBoxDao(IMsgBoxDAO msgBoxDao) {
		this.msgBoxDao = msgBoxDao;
	}

	public void onSetUpInTransaction() {
		msgBox = new MsgBox();
		msgBox.setChecked(CHECKED);
		msgBox.setContent(CONTENT);
		msgBox.setReceiverid(RECIEVERID);
		msgBox.setTime(new Timestamp(System.currentTimeMillis()));
		msgBoxDao.save(msgBox);
	}

	public void testSave() {
		msgBoxDao.save(msgBox);
		assertNotNull(msgBoxDao.findById(msgBox.getId()));
	}

	public void testDelete() {
		msgBoxDao.save(msgBox);
		msgBoxDao.delete(msgBox);
		assertNull(msgBoxDao.findById(msgBox.getId()));
		flushSession();
	}

	public void testFindById() {
		msgBoxDao.save(msgBox);
		assertNotNull(msgBoxDao.findById(msgBox.getId()));
	}

	public void testFindByExample() {
		msgBoxDao.save(msgBox);
		// assertEquals(msgBox.getId(),msgBox.getId());
		assertTrue(msgBoxDao.findByExample(msgBox).size() > 0);
	}

	public void testFindByProperty() {
		assertNotNull(msgBoxDao.findByProperty("content", CONTENT));
	}

	public void testFindByReceiverid() {
		assertNotNull(msgBoxDao.findByReceiverid(RECIEVERID));
	}

	public void testFindByContent() {
		assertTrue(msgBoxDao.findByContent(CONTENT).size() > 0);
		assertNotNull(msgBoxDao.findByContent(CONTENT));
	}

	public void testFindByChecked() {
		assertTrue(msgBoxDao.findByChecked(CHECKED).size() > 0);
		assertNotNull(msgBoxDao.findByChecked(false));
	}

	public void testFindAll() {
		assertTrue(msgBoxDao.findAll().size() > 0);
	}

}
