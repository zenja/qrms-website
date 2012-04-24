package com.qrms.action.internalmessage;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IInternalMessageService;
import com.qrms.service.IUserService;

/**
 * @author Yinshunming & Zhangzu
 * @version 1.0
 * note : ignore ActionContext before test
 */
public class SendInternalMessageActionTest extends TestCase {
	private IInternalMessageService internalMessageService;
	private MockControl imMock;
	private IUserService userService;
	private MockControl userMock;

	private SendInternalMessageAction action;
	private Integer userIdTo = 1;
	private String title = "test title";
	private String content = "test content";

	protected void setUp() throws Exception {
		imMock = MockControl.createNiceControl(IInternalMessageService.class);
		userMock = MockControl.createNiceControl(IUserService.class);

		internalMessageService = (IInternalMessageService) imMock.getMock();
		userService = (IUserService) userMock.getMock();

		action = new SendInternalMessageAction();
		action.setInternalMessageService(internalMessageService);
		action.setUserService(userService);
		action.setUserIdTo(userIdTo);
		action.setTitle(title);
		action.setContent(content);
	}

	public void testExecute() {
		imMock.reset();
		userMock.reset();

		imMock.replay();
		userMock.replay();

		assertEquals(action.execute(), "error");
	}

	protected void tearDown() throws Exception {
		imMock.verify();
		userMock.verify();
	}

}
