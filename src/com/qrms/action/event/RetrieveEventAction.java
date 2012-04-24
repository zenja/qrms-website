package com.qrms.action.event;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.Event;
import com.qrms.service.IEventService;
import org.apache.struts2.json.annotations.*;

/**
 * Description: This is a class mapping to the functions that retrieving Events
 * to the pages
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class RetrieveEventAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static final int MAX_EVENT_NUM = 5;

	private IEventService eventService;

	private List<Event> latestEventsList;

	private List<Event> allEventsList;

	/** passed by user to retrieve theSingleEvent */
	private Integer id;

	private Event theSingleEvent;

	/* use JSON annotations to indicate this variable doesn't need to sequence */
	@JSON(serialize = false)
	public IEventService getEventService() {
		return eventService;
	}

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

	public List<Event> getLatestEventsList() {
		return latestEventsList;
	}

	public void setLatestEventsList(List<Event> latestEventsList) {
		this.latestEventsList = latestEventsList;
	}

	public List<Event> getAllEventsList() {
		return allEventsList;
	}

	public void setAllEventsList(List<Event> allEventsList) {
		this.allEventsList = allEventsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Event getTheSingleEvent() {
		return theSingleEvent;
	}

	public void setTheSingleEvent(Event theSingleEvent) {
		this.theSingleEvent = theSingleEvent;
	}

	/**
	 * This function uses service to fetch lastest events from database. The
	 * number is decided by the variable MAX_EVENT_NUM
	 * @return SUCESS if latest events are taken out
	 */
	public String retrieveLatestEvents() {
		List<Event> allEventsList = eventService.getAllEvents();

		latestEventsList = new ArrayList<Event>();

		int itemNum = allEventsList.size() < MAX_EVENT_NUM ? allEventsList
				.size() : MAX_EVENT_NUM;

		for (int i = 0; i < itemNum; i++) {
			latestEventsList.add(allEventsList.get(i));
		}

		return SUCCESS;
	}

	public String retrieveAllEvents() {
		allEventsList = eventService.getAllEvents();
		return SUCCESS;
	}

	public String retrieveSingleEvent() {
		if (id == null) {
			return INPUT;
		}

		theSingleEvent = eventService.findById(id);

		return SUCCESS;
	}

}
