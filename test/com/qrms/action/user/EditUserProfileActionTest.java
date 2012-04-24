package com.qrms.action.user;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IUserService;

/**
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class EditUserProfileActionTest extends TestCase {
	private IUserService userService;
	private MockControl usMock;

	private EditUserProfileAction action;

	protected void setUp() throws Exception {
		usMock = MockControl.createNiceControl(IUserService.class);
		userService = (IUserService) usMock.getMock();

		action = new EditUserProfileAction();
		action.setUserService(userService);
	}

	protected void tearDown() throws Exception {
		usMock.verify();
	}

	public void testExecute() throws Exception {
		usMock.reset();
		usMock.replay();
		assertEquals(action.execute(), "success");
	}

}
