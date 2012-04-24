package com.qrms.dao.impl;

import java.util.Date;

import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.dao.IInspiringGameInfoDAO;
/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class InspiringGameInfoDAOImplTest extends BaseDAOTestCase {
	private IInspiringGameInfoDAO gameInfoDao;
	private InspiringGameInfo gameInfo;
	private final String CITY = "Test_Beijing";
	private final String GAMENAME = "Test Game Name";
	private final String HINT = "Test Hint";
	private final double LATITUDE = 44.444;
	private final double LONGITUDE = 33.333;
	private final String NATION = "Test_China";
	private final String PICTUREURL = "Test_picURL";
	private final String PROVINCE = "Test Province";
	private final int QRCONTENTID = 1;
	private final int USERID = 1;

	public IInspiringGameInfoDAO getGameInfoDao() {
		return gameInfoDao;
	}

	public void setGameInfoDao(IInspiringGameInfoDAO gameInfoDao) {
		this.gameInfoDao = gameInfoDao;
	}

	public void onSetUpInTransaction() {
		gameInfo = new InspiringGameInfo();
		gameInfo.setCity(CITY);

		QRContent qrContent = new QRContent();
		qrContent.setId(QRCONTENTID);
		gameInfo.setQrContent(qrContent);

		gameInfo.setGameName(GAMENAME);
		gameInfo.setHint(HINT);
		gameInfo.setLatitude(LATITUDE);
		gameInfo.setLongitude(LONGITUDE);
		gameInfo.setNation(NATION);
		gameInfo.setPictureUrl(PICTUREURL);
		gameInfo.setPlaceDate(new Date(25443525));
		gameInfo.setProvince(PROVINCE);

		User gameLauncer = new User();
		gameLauncer.setId(1);
		gameInfo.setUser(gameLauncer);

		gameInfoDao.save(gameInfo);
	}

	public void testSave() {
		gameInfoDao.save(gameInfo);
		assertNotNull(gameInfoDao.findById(gameInfo.getId()));
	}

	public void testDelete() {
		gameInfoDao.save(gameInfo);
		gameInfoDao.delete(gameInfo);
		assertNull(gameInfoDao.findById(gameInfo.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(gameInfoDao.findById(gameInfo.getId()));
	}

	public void testFindByExample() {
		assertNotNull(gameInfoDao.findByExample(gameInfo));
	}

	public void testFindByProperty() {
		assertNotNull(gameInfoDao.findByProperty("id", gameInfo.getId()));
	}

	public void testFindByGameName() {
		assertTrue(gameInfoDao.findByGameName(GAMENAME).size() > 0);
	}

	public void testFindByLatitude() {
		assertTrue(gameInfoDao.findByLatitude(LATITUDE).size() > 0);
	}

	public void testFindByLongitude() {
		assertTrue(gameInfoDao.findByLongitude(LONGITUDE).size() > 0);
	}

	public void testFindByHint() {
		assertTrue(gameInfoDao.findByHint(HINT).size() > 0);
	}

	public void testFindByCity() {
		assertTrue(gameInfoDao.findByCity(CITY).size() > 0);
	}

	public void testFindByProvince() {
		assertTrue(gameInfoDao.findByProvince(PROVINCE).size() > 0);
	}

	public void testFindByNation() {
		assertTrue(gameInfoDao.findByNation(NATION).size() > 0);
	}

	public void testFindByPictureUrl() {
		assertTrue(gameInfoDao.findByPictureUrl(PICTUREURL).size() > 0);
	}

	public void testFindAll() {
		assertTrue(gameInfoDao.findAll().size() > 0);
	}

	public void testFindByArea() {
		assertTrue(gameInfoDao.findByArea(LATITUDE, LONGITUDE, 10).size() > 0);
	}

	public void testFindByUserId() {
		assertTrue(gameInfoDao.findByUserId(USERID).size() > 0);
	}

}
