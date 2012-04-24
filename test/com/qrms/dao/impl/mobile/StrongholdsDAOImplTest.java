package com.qrms.dao.impl.mobile;

import java.util.Date;

import com.qrms.bean.Strongholds;
import com.qrms.dao.IStrongholdsDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class StrongholdsDAOImplTest extends BaseDAOTestCase {
	IStrongholdsDAO strongholdsDao;
	Strongholds strongholds;
	private final String CITY = "China-Fujian-Xiamen";
	private final int HEALTH = 10;
	private final double LATITUDE = 24.463;
	private final double LONGITUDE = 118.1;
	private final String NAME = "test1";
	private final String QRINFO = "haha";
	private final int SETBY = 1;

	public IStrongholdsDAO getStrongholdsDao() {
		return strongholdsDao;
	}

	public void setStrongholdsDao(IStrongholdsDAO strongholdsDao) {
		this.strongholdsDao = strongholdsDao;
	}

	public void onSetUpInTransaction() {
		strongholds = new Strongholds();
		strongholds.setCity(CITY);
		strongholds.setHealth(HEALTH);
		strongholds.setLatitude(LATITUDE);
		strongholds.setLongitude(LONGITUDE);
		strongholds.setName(NAME);
		strongholds.setQrinfo(QRINFO);
		strongholds.setSetby(SETBY);
		strongholds.setOwnerid(SETBY);
		strongholds.setSetdate(new Date(System.currentTimeMillis()));
	}

	public void testSave() {
		strongholdsDao.save(strongholds);
		assertNotNull(strongholdsDao.findById(strongholds.getId()));
	}

	public void testDelete() {
		strongholdsDao.save(strongholds);
		strongholdsDao.delete(strongholds);

		assertNull(strongholdsDao.findById(strongholds.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(strongholdsDao.findById(1));
	}

	public void testFindByQrinfo() {
		assertNotNull(strongholdsDao.findByQrinfo(QRINFO));
	}

	public void testFindByName() {
		assertNotNull(strongholdsDao.findByName(NAME));
	}

	public void testFindByNameLike() {
		assertNotNull(strongholdsDao.findByName(NAME.substring(0, 2)));
		assertNotNull(strongholdsDao.findByName(NAME.substring(1, 4)));
	}

	public void testFindByCity() {
		assertNotNull(strongholdsDao.findByCity(CITY));
	}

	public void testFindByCityLike() {
		assertNotNull(strongholdsDao.findByCityLike(CITY.substring(0, 5)));
	}

	public void testFindBySetby() {
		assertNotNull(strongholdsDao.findBySetby(SETBY));
	}

	public void testFindByOwnerid() {
		assertNotNull(strongholdsDao.findByOwnerid(SETBY));
	}

	public void testFindAll() {
		assertTrue(strongholdsDao.findAll().size() > 0);
	}

	/*
	 * public void testUpdate() { strongholds.setCity("a");
	 * strongholdsDao.update(strongholds); flushSession();
	 * assertEquals("a",strongholdsDao.findById(strongholds.getId()).getCity());
	 * }
	 */
	@Override
	protected void onTearDownAfterTransaction() throws Exception {
		super.onTearDownAfterTransaction();
	}
}
