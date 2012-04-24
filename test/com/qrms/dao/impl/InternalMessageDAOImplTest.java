package com.qrms.dao.impl;

import java.sql.Timestamp;

import com.qrms.bean.InternalMessage;
import com.qrms.bean.User;
import com.qrms.dao.IInternalMessageDAO;
/**
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public class InternalMessageDAOImplTest extends BaseDAOTestCase {
	private IInternalMessageDAO internalMsgDao;
	private InternalMessage internalMsg;

	private final String CONTENT = "Nice To Meet You";
	private final String TITLE = "Hi~";
	private final int USERID1 = 1;
	private final int USERID2 = 2;

	public IInternalMessageDAO getInternalMsgDao() {
		return internalMsgDao;
	}

	public void setInternalMsgDao(IInternalMessageDAO internalMsgDao) {
		this.internalMsgDao = internalMsgDao;
	}

	public void onSetUpInTransaction() {
		internalMsg.setContent(CONTENT);
		internalMsg.setTime(new Timestamp(System.currentTimeMillis()));
		internalMsg.setTitle(TITLE);

		User userFrom = new User();
		User userTo = new User();
		userFrom.setId(USERID1);
		userTo.setId(USERID2);
		internalMsg.setUserByUserFrom(userFrom);
		internalMsg.setUserByUserTo(userTo);

		internalMsgDao.save(internalMsg);
	}

	public void testSave() {
		internalMsgDao.save(internalMsg);
		assertNotNull(internalMsgDao.findById(internalMsg.getId()));
	}

	public void testDelete() {
		internalMsgDao.save(internalMsg);
		internalMsgDao.delete(internalMsg);
		assertNotNull(internalMsgDao.findById(internalMsg.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(internalMsgDao.findById(internalMsg.getId()));
	}

	public void testFindByExample() {
		assertTrue(internalMsgDao.findByExample(internalMsg).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(internalMsgDao.findByProperty("id", internalMsg.getId())
				.size() > 0);
	}

	public void testFindByTitle() {
		assertTrue(internalMsgDao.findByTitle(TITLE).size() > 0);
	}

	public void testFindByContent() {
		assertTrue(internalMsgDao.findByContent(CONTENT).size() > 0);
	}

	public void testFindAll() {
		assertTrue(internalMsgDao.findAll().size() > 0);
	}

	public void testFindByReceiverId() {
		assertTrue(internalMsgDao.findByReceiverId(USERID2).size() > 0);
	}

}
