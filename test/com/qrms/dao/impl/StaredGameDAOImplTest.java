package com.qrms.dao.impl;

import com.qrms.bean.StaredGame;
import com.qrms.bean.User;
import com.qrms.dao.IStaredGameDAO;
/**
 * @author Zhangzu & Wangxing
 * @version 1.0
 */
public class StaredGameDAOImplTest extends BaseDAOTestCase {
	private IStaredGameDAO staredGameDao;
	StaredGame staredGame;
	private final int GAMETYPE = 0;
	private final int GAMEID = 4;
	private final int USERID = 1;

	public IStaredGameDAO getStaredGameDao() {
		return staredGameDao;
	}

	public void setStaredGameDao(IStaredGameDAO staredGameDao) {
		this.staredGameDao = staredGameDao;
	}

	public void onSetUpInTransaction() {
		staredGame = new StaredGame();
		User user = new User();
		user.setId(USERID);
		staredGame.setGameType(GAMETYPE);
		staredGame.setGameId(GAMEID);
		staredGame.setUser(user);
		staredGameDao.save(staredGame);
	}

	public void testSave() {
		staredGameDao.save(staredGame);
		assertNotNull(staredGameDao.findById(staredGame.getId()));
	}

	public void testDelete() {
		staredGameDao.save(staredGame);
		staredGameDao.delete(staredGame);
		assertNull(staredGameDao.findById(staredGame.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(staredGameDao.findById(staredGame.getId()));
	}

	public void testFindByExample() {
		assertTrue(staredGameDao.findByExample(staredGame).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(staredGameDao.findByProperty("id", staredGame.getId())
				.size() > 0);
	}

	public void testFindByGameType() {
		assertTrue(staredGameDao.findByGameType(GAMETYPE).size() > 0);
	}

	public void testFindByGameId() {
		assertTrue(staredGameDao.findByGameId(GAMEID).size() > 0);
	}

	public void testFindAll() {
		assertTrue(staredGameDao.findAll().size() > 0);
	}

	public void testFindByUserIdAndGameTypeAndGameId() {
		assertTrue(staredGameDao.findByUserIdAndGameTypeAndGameId(USERID,
				GAMETYPE, GAMEID).size() > 0);
	}

	public void testFindByUserId() {
		assertTrue(staredGameDao.findByUserId(USERID).size() > 0);
	}

}
