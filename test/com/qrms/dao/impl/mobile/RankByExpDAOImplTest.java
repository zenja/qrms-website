package com.qrms.dao.impl.mobile;

import com.qrms.bean.RankByExp;
import com.qrms.dao.IRankByExpDAO;
import com.qrms.dao.impl.BaseDAOTestCase;


/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class RankByExpDAOImplTest extends BaseDAOTestCase {
	IRankByExpDAO rankByExpDao;
	RankByExp rankByExp;
	private final int USERID = 1;
	private final int EXP = 1000;
	private final String NAME = "ZZ";
	private final int OCCUPYINGNUM = 20;
	private final int SETUPNUM = 32;

	public IRankByExpDAO getRankByExpDao() {
		return rankByExpDao;
	}

	public void setRankByExpDao(IRankByExpDAO rankByExpDao) {
		this.rankByExpDao = rankByExpDao;
	}

	public void onSetUpInTransaction() {
		rankByExp = new RankByExp();
		rankByExp.setExp(EXP);
		rankByExp.setName(NAME);
		rankByExp.setOccupyingnum(OCCUPYINGNUM);
		rankByExp.setSetupnum(SETUPNUM);
		rankByExp.setUserid(USERID);

		rankByExpDao.save(rankByExp);
	}

	public void testSave() {
		rankByExpDao.save(rankByExp);
		assertNotNull(rankByExpDao.findById(rankByExp.getUserid()));
	}

	public void testDelete() {
		rankByExpDao.delete(rankByExp);
		assertNull(rankByExpDao.findById(rankByExp.getUserid()));
	}

	public void testFindById() {
		assertNotNull(rankByExpDao.findById(rankByExp.getUserid()));
	}

	public void testFindByExample() {
		assertTrue(rankByExpDao.findByExample(rankByExp).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(rankByExpDao.findByProperty("userid", rankByExp.getUserid())
				.size() > 0);
	}

	public void testFindByExp() {
		assertTrue(rankByExpDao.findByExp(EXP).size() > 0);
	}

	public void testFindBySetupnum() {
		assertTrue(rankByExpDao.findBySetupnum(SETUPNUM).size() > 0);
	}

	public void testFindByOccupyingnum() {
		assertTrue(rankByExpDao.findByOccupyingnum(OCCUPYINGNUM).size() > 0);
	}

	public void testFindByName() {
		assertTrue(rankByExpDao.findByName(NAME).size() > 0);
	}

	public void testFindAll() {
		assertTrue(rankByExpDao.findAll().size() > 0);
	}

}
