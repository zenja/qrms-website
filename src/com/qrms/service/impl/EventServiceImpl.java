package com.qrms.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.qrms.bean.Event;
import com.qrms.dao.IEventDAO;
import com.qrms.service.IEventService;

/**
 * Description: This is the implemention of the interface IEventService. It
 * provides some methods which are related to Evnets
 * 
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public class EventServiceImpl implements IEventService {

	/** the dao to do operations related to events */
	private IEventDAO eventDAO;

	public IEventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(IEventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	/**
	 * @param title : title of the event
	 * @param content : content of the event
	 * Save the Event to DB
	 */

	public void addEvent(String title, String content) {
		Event event = new Event();
		event.setTitle(title);
		event.setContent(content);
		event.setDate(new Timestamp(System.currentTimeMillis()));
		eventDAO.save(event);
	}

	/**
	 * @param id: the id of the event
	 * Delete the Devent from DB
	 */
	public void deleteEvent(Integer id) {
		Event event = new Event();
		event.setId(id);

		eventDAO.delete(event);
	}

	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents() {
		return eventDAO.findAll();
	}

	public Event findById(Integer id) {
		return eventDAO.findById(id);
	}

}
