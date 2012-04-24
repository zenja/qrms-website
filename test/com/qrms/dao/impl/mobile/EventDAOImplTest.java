package com.qrms.dao.impl.mobile;

import java.sql.Timestamp;

import com.qrms.bean.Event;
import com.qrms.dao.IEventDAO;
import com.qrms.dao.impl.BaseDAOTestCase;

/**
 * @author  Zhangzu & Zhaolu
 * @version 1.0
 */
public class EventDAOImplTest extends BaseDAOTestCase {
	private IEventDAO eventDao;
	private Event event;
	private final String CONTENT = "Test content";
	private final String TITLE = "test title";

	public IEventDAO getEventDao() {
		return eventDao;
	}

	public void setEventDao(IEventDAO eventDao) {
		this.eventDao = eventDao;
	}

	public void onSetUpInTransaction() {
		event = new Event();
		event.setContent(CONTENT);
		event.setDate(new Timestamp(System.currentTimeMillis()));
		event.setTitle(TITLE);

		eventDao.save(event);
	}

	public void testSave() {
		eventDao.save(event);
		assertNotNull(eventDao.findById(event.getId()));
	}

	public void testDelete() {
		eventDao.save(event);
		eventDao.delete(event);
		assertNotNull(eventDao.findById(event.getId()));
		flushSession();
	}

	public void testFindById() {
		assertNotNull(eventDao.findById(event.getId()));
	}

	public void testFindByExample() {
		assertNotNull(eventDao.findByExample(event));
	}

	public void testFindByProperty() {
		assertEquals(1, eventDao.findByProperty("id", event.getId()));
	}

	public void testFindByTitle() {
		assertTrue(eventDao.findByTitle(TITLE).size() > 0);
	}

	public void testFindByContent() {
		assertTrue(eventDao.findByContent(CONTENT).size() > 0);
	}

	public void testFindAll() {
		assertTrue(eventDao.findAll().size() > 0);
	}

}
