package com.qrms.service;

import java.util.List;

import com.qrms.bean.Event;

/**
 * Descrption:This class is the interface for AdminServiceImpl It abstracts some
 * methods from the service to provide service to actions
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public interface IEventService {

	public void addEvent(String title, String content);

	public void deleteEvent(Integer id);

	public List<Event> getAllEvents();

	public Event findById(Integer id);
}
