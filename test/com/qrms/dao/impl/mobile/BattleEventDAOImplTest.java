package com.qrms.dao.impl.mobile;

import java.sql.Timestamp;

import com.qrms.bean.BattleEvent;
import com.qrms.dao.IBattleEventDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author Zhaolu & Wangxing
 * @version 1.0
 */
public class BattleEventDAOImplTest extends BaseDAOTestCase {
	private IBattleEventDAO beDao;
	private BattleEvent be;

	private final int ATTACKERID = 1;
	private final int DEFENDERID = 2;
	private final String EVENTTYPE = "2";
	private final int STRONGHOLDID = 1;

	public IBattleEventDAO getBeDao() {
		return beDao;
	}

	public void setBeDao(IBattleEventDAO beDao) {
		this.beDao = beDao;
	}

	public void onSetUpInTransaction() {
		be = new BattleEvent();
		be.setAttackerid(ATTACKERID);
		be.setBattletime(new Timestamp(System.currentTimeMillis()));
		be.setDefenderid(DEFENDERID);
		be.setEventtype(EVENTTYPE);
		be.setStrongholdid(STRONGHOLDID);

		beDao.save(be);
	}

	public void testSave() {
		beDao.save(be);
		assertNotNull(beDao.findById(be.getId()));
	}

	public void testDelete() {
		// beDao.save(be);
		beDao.delete(be);
		flushSession();
		assertNull(beDao.findById(be.getId()));
	}

	public void testFindById() {
		assertNotNull(beDao.findById(be.getId()));
	}

	public void testFindByExample() {
		assertTrue(beDao.findByExample(be).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(beDao.findByProperty("attackerid", ATTACKERID).size() > 0);
	}

	public void testFindByAttackerid() {
		assertTrue(beDao.findByAttackerid(ATTACKERID).size() > 0);
	}

	public void testFindByDefenderid() {
		assertTrue(beDao.findByDefenderid(DEFENDERID).size() > 0);
	}

	public void testFindByStrongholdid() {
		assertTrue(beDao.findByStrongholdid(STRONGHOLDID).size() > 0);
	}

	public void testFindByEventtype() {
		assertTrue(beDao.findByEventtype(EVENTTYPE).size() > 0);
	}

	public void testFindAll() {
		assertTrue(beDao.findAll().size() > 0);
	}

}
