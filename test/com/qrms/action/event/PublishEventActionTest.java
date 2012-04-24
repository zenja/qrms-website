package com.qrms.action.event;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IEventService;
/** 
* @author Yinshunming & Wangxing
* @version 1.0
*/
public class PublishEventActionTest extends TestCase {

	MockControl control;
	IEventService mock;

	protected void setUp() throws Exception {
		super.setUp();

		control = MockControl.createControl(IEventService.class);
		mock = (IEventService) control.getMock();

		mock.addEvent("test", "test");
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		PublishEventAction action1, action2, action3;
		action1 = new PublishEventAction();
		action1.setContent("test");
		action1.setTitle("test");
		action2 = new PublishEventAction();
		action2.setContent("");
		action2.setTitle("test");
		action3 = new PublishEventAction();
		action3.setContent("test");
		action3.setTitle("");
		action1.setEventService(mock);
		action2.setEventService(mock);
		action3.setEventService(mock);
		assertEquals(action1.execute(), "success");
		assertEquals(action2.execute(), "input");
		assertEquals(action3.execute(), "input");
	}
}
