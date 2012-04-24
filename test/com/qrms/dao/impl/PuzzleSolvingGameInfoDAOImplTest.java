package com.qrms.dao.impl;

import java.util.Date;
import java.util.List;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.User;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
/**
 * @author Zhangzu & Wangxing
 * @version 1.0
 */
public class PuzzleSolvingGameInfoDAOImplTest extends BaseDAOTestCase {
	private IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO;

	public IPuzzleSolvingGameInfoDAO getPuzzleSolvingGameInfoDAO() {
		return puzzleSolvingGameInfoDAO;
	}

	public void setPuzzleSolvingGameInfoDAO(
			IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO) {
		this.puzzleSolvingGameInfoDAO = puzzleSolvingGameInfoDAO;
	}

	private PuzzleSolvingGameInfo puzzleSolvingGameInfo;

	public void onSetUpInTransaction() {
		puzzleSolvingGameInfo = new PuzzleSolvingGameInfo();
		puzzleSolvingGameInfo.setCity("Test_Beijing");
		puzzleSolvingGameInfo.setDifficultyLevel(3);
		puzzleSolvingGameInfo.setTerrainLevel(2);
		puzzleSolvingGameInfo.setGameName("Test Game Name");
		puzzleSolvingGameInfo.setHint("Test Hint");
		puzzleSolvingGameInfo.setLatitude(44.444);
		puzzleSolvingGameInfo.setLongitude(33.333);
		puzzleSolvingGameInfo.setLongDescription("Test Long Description");
		puzzleSolvingGameInfo.setNation("Test_China");
		puzzleSolvingGameInfo.setPictureUrl("Test_picURL");
		puzzleSolvingGameInfo.setPlaceDate(new Date(25443525));
		puzzleSolvingGameInfo.setProvince("Test_Beijing Province");
		puzzleSolvingGameInfo.setQrNum(9);

		puzzleSolvingGameInfo.setDefaultLL(0);

		User gameLauncer = new User();
		gameLauncer.setId(1);

		puzzleSolvingGameInfo.setTblUserinfo(gameLauncer);

	}

	public void testSave() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		assertNotNull(puzzleSolvingGameInfo.getId());
	}

	public void testDelete() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		puzzleSolvingGameInfoDAO.delete(puzzleSolvingGameInfo);
		flushSession();
		assertNull(puzzleSolvingGameInfoDAO.findById(puzzleSolvingGameInfo
				.getId()));
	}

	public void testFindById() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		assertNotNull(puzzleSolvingGameInfoDAO.findById(puzzleSolvingGameInfo
				.getId()));
	}

	public void testFindByExample() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		assertNotNull(puzzleSolvingGameInfoDAO
				.findByExample(puzzleSolvingGameInfo));
	}

	public void testfindByProperty() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);

		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("id",
				puzzleSolvingGameInfo.getId()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("gameName",
				puzzleSolvingGameInfo.getGameName()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("placeDate",
				puzzleSolvingGameInfo.getPlaceDate()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("pictureUrl",
				puzzleSolvingGameInfo.getPictureUrl()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("nation",
				puzzleSolvingGameInfo.getNation()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("province",
				puzzleSolvingGameInfo.getProvince()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty(
				"difficultyLevel", puzzleSolvingGameInfo.getDifficultyLevel()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("terrainLevel",
				puzzleSolvingGameInfo.getTerrainLevel()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty(
				"longDescription", puzzleSolvingGameInfo.getLongDescription()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("hint",
				puzzleSolvingGameInfo.getHint()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("longitude",
				puzzleSolvingGameInfo.getLongitude()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("latitude",
				puzzleSolvingGameInfo.getLatitude()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("qrNum",
				puzzleSolvingGameInfo.getQrNum()));
		assertNotNull(puzzleSolvingGameInfoDAO.findByProperty("city",
				puzzleSolvingGameInfo.getCity()));
	}

	@SuppressWarnings("unchecked")
	public void testFindByGameName() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("id",
				puzzleSolvingGameInfo.getId());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByPlaceDate() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("placeDate",
				puzzleSolvingGameInfo.getPlaceDate());
		assertNotNull(list);
	}

	@SuppressWarnings("unchecked")
	public void testFindByPictureUrl() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("pictureUrl",
				puzzleSolvingGameInfo.getPictureUrl());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByNation() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("nation",
				puzzleSolvingGameInfo.getNation());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByProvince() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("province",
				puzzleSolvingGameInfo.getProvince());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByCity() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("city",
				puzzleSolvingGameInfo.getCity());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByDifficultyLevel() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("difficultyLevel",
				puzzleSolvingGameInfo.getDifficultyLevel());
		assertNotNull(list);
	}

	@SuppressWarnings("unchecked")
	public void testFindByTerrainLevel() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("terrainLevel",
				puzzleSolvingGameInfo.getTerrainLevel());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByLongDescription() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("longDescription",
				puzzleSolvingGameInfo.getLongDescription());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByHint() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("hint",
				puzzleSolvingGameInfo.getHint());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByLongitude() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("longitude",
				puzzleSolvingGameInfo.getLongitude());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByLatitude(Object value) {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("latitude",
				puzzleSolvingGameInfo.getLatitude());
		assertEquals(list.size(), 1);
	}

	@SuppressWarnings("unchecked")
	public void testFindByQrNum(Object value) {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		List list = puzzleSolvingGameInfoDAO.findByProperty("qrNum",
				puzzleSolvingGameInfo.getQrNum());
		assertEquals(list.size(), 1);
	}

	public void testFindAll() {
		puzzleSolvingGameInfoDAO.save(puzzleSolvingGameInfo);
		assertNotNull(puzzleSolvingGameInfoDAO.findAll());
	}

}
