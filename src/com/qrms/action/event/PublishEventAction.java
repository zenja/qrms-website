package com.qrms.action.event;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.IEventService;

/**
 * Decription: this action is for users to publish events
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class PublishEventAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IEventService eventService;

	private String title;

	private String content;

	public IEventService getEventService() {
		return eventService;
	}

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * it stores the Events into database
	 * @return INPUT if inputs are not complete SUCCESS if all go successfully
	 */
	@Override
	public String execute() {
		if (title == null || title.trim().equals("")) {
			return INPUT;
		}

		if (content == null || content.trim().equals("")) {
			return INPUT;
		}

		eventService.addEvent(title, content);

		return SUCCESS;
	}

}
