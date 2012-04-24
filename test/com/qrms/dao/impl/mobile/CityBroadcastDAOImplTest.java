package com.qrms.dao.impl.mobile;

import java.sql.Timestamp;

import com.qrms.bean.CityBroadcast;
import com.qrms.dao.ICityBroadcastDAO;
import com.qrms.dao.impl.BaseDAOTestCase;
/**
 * @author Zhaolu & Wangxing
 * @version 1.0
 */
public class CityBroadcastDAOImplTest extends BaseDAOTestCase {
	private ICityBroadcastDAO cbDao;
	private CityBroadcast cb;

	private final String CITY = "Test City";
	private final int SPEAKERID = 1;
	private final String CONTENT = "test content";

	public ICityBroadcastDAO getCbDao() {
		return cbDao;
	}

	public void setCbDao(ICityBroadcastDAO cbDao) {
		this.cbDao = cbDao;
	}

	public void onSetUpInTransaction() {
		cb = new CityBroadcast();
		cb.setCity(CITY);
		cb.setContent(CONTENT);
		cb.setSpeakerid(SPEAKERID);
		cb.setTime(new Timestamp(System.currentTimeMillis()));
		cbDao.save(cb);
	}

	public void testSave() {
		cbDao.save(cb);
		assertNotNull(cbDao.findById(cb.getId()));
	}

	public void testDelete() {
		cbDao.delete(cb);
		assertNull(cbDao.findById(cb.getId()));
	}

	public void testFindById() {
		assertNotNull(cbDao.findById(cb.getId()));
	}

	public void testFindByExample() {
		assertTrue(cbDao.findByExample(cb).size() > 0);
	}

	public void testFindByProperty() {
		assertTrue(cbDao.findByProperty("id", cb.getId()).size() > 0);
	}

	public void testFindBySpeakerid() {
		assertTrue(cbDao.findBySpeakerid(SPEAKERID).size() > 0);
	}

	public void testFindByCity() {
		assertTrue(cbDao.findByCity(CITY).size() > 0);
	}

	public void testFindByContent() {
		assertTrue(cbDao.findByContent(CONTENT).size() > 0);
	}

	public void testFindAll() {
		assertTrue(cbDao.findAll().size() > 0);
	}

}
