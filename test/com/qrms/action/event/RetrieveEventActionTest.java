package com.qrms.action.event;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.Event;
import com.qrms.service.IEventService;
/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class RetrieveEventActionTest extends TestCase {

	IEventService mock;
	MockControl control;
	RetrieveEventAction action;
	Event event = new Event();
	List<Event> list = new ArrayList<Event>();

	protected void setUp() throws Exception {
		super.setUp();
		event.setContent("test");
		list.add(event);

		control = MockControl.createControl(IEventService.class);
		mock = (IEventService) control.getMock();

		action = new RetrieveEventAction();
		action.setEventService(mock);
		action.setId(1);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRetrieveAllEvents() {
		control.reset();
		mock.getAllEvents();
		control.setReturnValue(list);
		control.replay();
		assertEquals(action.retrieveAllEvents(), "success");
		control.verify();
	}

	public void testRetrieveLatestEvents() {
		control.reset();
		mock.getAllEvents();
		control.setReturnValue(list);
		control.replay();
		assertEquals(action.retrieveLatestEvents(), "success");
		control.verify();
	}

	public void testRetrieveSingleEvent() {
		mock.findById(1);
		control.setReturnValue(event);
		control.replay();
		assertEquals(action.retrieveSingleEvent(), "success");
		control.verify();
	}

}
