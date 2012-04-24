package com.qrms.dao.impl;

import java.sql.Timestamp;

import com.qrms.bean.GameComment;
import com.qrms.bean.User;
import com.qrms.dao.IGameCommentDAO;
/**
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class GameCommentDAOImplTest extends BaseDAOTestCase {
	IGameCommentDAO commentDao;

	public IGameCommentDAO getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(IGameCommentDAO commentDao) {
		this.commentDao = commentDao;
	}

	GameComment comment;

	private final int TYPE = 1;
	private final int GAMEID = 1;
	private final int GAMETYPE = 1;
	private final String PHOTO = "TEST Photo";
	private final String TEXTCOMMENT = "Test comment";
	private final int USERID = 1;

	public void onSetUpInTransaction() {
		comment = new GameComment();
		comment.setCommentType(TYPE);
		comment.setGameId(GAMEID);
		comment.setGameType(GAMETYPE);
		comment.setPhoto(PHOTO);
		comment.setTextcomment(TEXTCOMMENT);
		comment.setTime(new Timestamp(System.currentTimeMillis()));

		User user = new User();
		user.setId(USERID);
		comment.setUser(user);

		commentDao.save(comment);
	}

	public void testSave() {
		commentDao.save(comment);
		assertNotNull(commentDao.findById(comment.getCommentId()));
	}

	public void testDelete() {
		commentDao.save(comment);
		commentDao.delete(comment);
		assertNull(commentDao.findById(comment.getCommentId()));
	}

	public void testFindById() {
		assertNotNull(commentDao.findById(comment.getCommentId()));
	}

	public void testFindByExample() {
		assertNotNull(commentDao.findByExample(comment));
	}

	public void testFindByProperty() {
		assertEquals(commentDao.findByProperty("id", comment.getCommentId())
				.size(), 1);
	}

	public void testFindByGameId() {
		assertTrue(commentDao.findByGameId(GAMEID).size() > 0);
	}

	public void testFindByTextcomment() {
		assertTrue(commentDao.findByTextcomment(TEXTCOMMENT).size() > 0);
	}

	public void testFindByPhoto() {
		assertTrue(commentDao.findByPhoto(PHOTO).size() > 0);
	}

	public void testFindByGameType() {
		assertTrue(commentDao.findByGameType(GAMETYPE).size() > 0);
	}

	public void testFindByCommentType() {
		assertTrue(commentDao.findByCommentType(TYPE).size() > 0);
	}

	public void testFindAll() {
		assertTrue(commentDao.findAll().size() > 0);
	}

	public void testFindByGameTypeAndGameId() {
		assertTrue(commentDao.findByGameTypeAndGameId(GAMETYPE, GAMEID).size() > 0);
	}

}
