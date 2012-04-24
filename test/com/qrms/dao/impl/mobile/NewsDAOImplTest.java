package com.qrms.dao.impl.mobile;

import java.sql.Timestamp;

import com.qrms.bean.News;
import com.qrms.dao.INewsDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Wangxing
 * @version 1.0
 */
public class NewsDAOImplTest extends BaseDAOTestCase {

	private INewsDAO newsDao;
	private News news;
	private final String CONTENT = "Test Content";
	private final String TITLE = "Test Title";

	public INewsDAO getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(INewsDAO newsDao) {
		this.newsDao = newsDao;
	}

	public void onSetUpInTransaction() {
		news = new News();
		news.setContent(CONTENT);
		news.setDate(new Timestamp(System.currentTimeMillis()));
		news.setTitle(TITLE);
	}

	public void testSave() {
		newsDao.save(news);
		assertNotNull(newsDao.findById(news.getId()));
	}

	public void testDelete() {
		newsDao.save(news);
		newsDao.delete(news);
		assertNotNull(newsDao.findById(news.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(newsDao.findById(news.getId()));
	}

	public void testFindByExample() {
		assertNotNull(newsDao.findByExample(news));
	}

	public void testFindByProperty() {
		assertNotNull(newsDao.findByProperty("id", news.getId()));
	}

	public void testFindByTitle() {
		assertNotNull(newsDao.findByTitle(TITLE));
	}

	public void testFindByContent() {
		assertNotNull(newsDao.findByContent(CONTENT));
	}

	public void testFindAll() {
		assertTrue(newsDao.findAll().size() > 0);
	}

}
