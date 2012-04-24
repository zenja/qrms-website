package com.qrms.dao.impl.mobile;

import com.qrms.bean.RankByOccupyingNum;
import com.qrms.dao.IRankByOccupyingNumDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class RankByOccupyingNumDAOImplTest extends BaseDAOTestCase {
	IRankByOccupyingNumDAO rankByNumDao;

	RankByOccupyingNum rankByNum;
	private final int USERID = 1;
	private final int EXP = 1000;
	private final String NAME = "ZZ";
	private final int OCCUPYINGNUM = 20;
	private final int SETUPNUM = 32;

	public IRankByOccupyingNumDAO getRankByNumDao() {
		return rankByNumDao;
	}

	public void setRankByNumDao(IRankByOccupyingNumDAO rankByNumDao) {
		this.rankByNumDao = rankByNumDao;
	}

	public void onSetUpInTransaction() {
		rankByNum = new RankByOccupyingNum();
		rankByNum.setExp(EXP);
		rankByNum.setName(NAME);
		rankByNum.setOccupyingnum(OCCUPYINGNUM);
		rankByNum.setSetupnum(SETUPNUM);
		rankByNum.setUserid(USERID);

		rankByNumDao.save(rankByNum);
	}

	public void testSave() {
		rankByNumDao.save(rankByNum);
		assertNotNull(rankByNumDao.findById(rankByNum.getUserid()));
	}

	public void testDelete() {
		rankByNumDao.delete(rankByNum);
		assertNull(rankByNumDao.findById(rankByNum.getUserid()));
	}

	public void testFindById() {
		assertNotNull(rankByNumDao.findById(rankByNum.getUserid()));
	}

	public void testFindByExample() {
		assertTrue(rankByNumDao.findByExample(rankByNum).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(rankByNumDao.findByProperty("userid", rankByNum.getUserid())
				.size() > 0);
	}

	public void testFindByExp() {
		assertTrue(rankByNumDao.findByExp(EXP).size() > 0);
	}

	public void testFindBySetupnum() {
		assertTrue(rankByNumDao.findBySetupnum(SETUPNUM).size() > 0);
	}

	public void testFindByOccupyingnum() {
		assertTrue(rankByNumDao.findByOccupyingnum(OCCUPYINGNUM).size() > 0);
	}

	public void testFindByName() {
		assertTrue(rankByNumDao.findByName(NAME).size() > 0);
	}

	public void testFindAll() {
		assertTrue(rankByNumDao.findAll().size() > 0);
	}

}
