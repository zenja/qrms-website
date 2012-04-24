package com.qrms.action.mobile;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.User;
import com.qrms.service.ILoginService;

/**
 * @author zhaoLu & YinShunming
 * @version 1.0 20 July 2010
 * 
 */
public class MobileLoginActionTest extends TestCase {

	MockControl control;
	MobileLoginAction action;
	ILoginService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(ILoginService.class);
		mock = (ILoginService) control.getMock();

		mock.isUser("test", "test");
		control.setReturnValue(true);
		mock.findUserByLoginEmail("test");
		control.setReturnValue(new User());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new MobileLoginAction();
		User u = new User();
		u.setLoginEmail("test");
		u.setPassword("test");
		action.setUser(u);
		action.setUls(mock);
		assertEquals(action.execute(), "mapArrayResult");
		assertNotNull(action.getMapArrayResult());
	}

}
