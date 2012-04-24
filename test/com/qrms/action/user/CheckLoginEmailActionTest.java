package com.qrms.action.user;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.ISaveNotValidatedUserService;
import com.qrms.service.IUserService;

/**
 * @author YinShunMing & ZhaoLu
 * @version 1.0
 */
public class CheckLoginEmailActionTest extends TestCase {
	private CheckLoginEmailAction action;
	private MockControl usMock;
	private IUserService userService;

	private MockControl snvuMock;
	private ISaveNotValidatedUserService snvuService;

	private String loginEmail = "testEmail";

	protected void setUp() throws Exception {
		usMock = MockControl.createControl(IUserService.class);
		userService = (IUserService) usMock.getMock();

		snvuMock = MockControl
				.createControl(ISaveNotValidatedUserService.class);
		snvuService = (ISaveNotValidatedUserService) snvuMock.getMock();

		action = new CheckLoginEmailAction();
		action.setLoginEmail(loginEmail);
		action.setNvuserService(snvuService);
		action.setUserService(userService);

	}

	public void testExecute() {
		usMock.reset();
		snvuMock.reset();
		usMock.expectAndReturn(
				userService.isUserExists(action.getLoginEmail()), true);
		snvuMock.expectAndReturn(snvuService.isExists(action.getLoginEmail()),
				false);
		usMock.replay();
		snvuMock.replay();

		String result = "";
		try {
			result = action.execute();
		} catch (Exception e) {
		}
		assertEquals(result, "success");
	}

	protected void tearDown() {
		/*
		 * usMock.verify(); snvuMock.verify();
		 */
	}
}
