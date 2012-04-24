package com.qrms.dao.impl.mobile;

import com.qrms.bean.Achievement;
import com.qrms.dao.IAchievementDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class AchievementDAOImplTest extends BaseDAOTestCase {
	private IAchievementDAO aDao;
	private Achievement achievement;
	private final int LEVEL = 5;
	private final int MONEY = 5000;
	private final int USERID = 5;

	public IAchievementDAO getaDao() {
		return aDao;
	}

	public void setaDao(IAchievementDAO aDao) {
		this.aDao = aDao;
	}

	public void onSetUpInTransaction() {
		achievement = new Achievement();
		achievement.setLevel(LEVEL);
		achievement.setMoney(MONEY);
		achievement.setUserid(USERID);

		aDao.save(achievement);
	}

	public void testSave() {
		aDao.save(achievement);
		assertNotNull(aDao.findById(achievement.getId()));
	}

	public void testDelete() {
		aDao.delete(achievement);
		assertNull(aDao.findById(achievement.getId()));
	}

	public void testFindById() {
		assertNotNull(aDao.findById(achievement.getId()));
	}

	public void testFindByExample() {
		assertTrue(aDao.findByExample(achievement).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(aDao.findByProperty("money", MONEY).size() > 0);
	}

	public void testFindByUserid() {
		assertTrue(aDao.findByUserid(USERID).size() > 0);
	}

	public void testFindByLevel() {
		assertTrue(aDao.findByLevel(LEVEL).size() > 0);
	}

	public void testFindByMoney() {
		assertTrue(aDao.findByMoney(MONEY).size() > 0);
	}

	public void testFindAll() {
		assertTrue(aDao.findAll().size() > 0);
	}

}
