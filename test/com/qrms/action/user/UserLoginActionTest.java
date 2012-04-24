package com.qrms.action.user;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.User;
import com.qrms.service.ILoginService;

/**
 * @author Yinshunming & Zhangzu
 * @version 2.0
 * modify 1 Wangxing & Yinshunming

 */
public class UserLoginActionTest extends TestCase {
	private UserLoginAction uLoginAction;
	private ILoginService usMock;
	private MockControl usMockCtrl;
	private User user;
	private final String loginEmail = "w@126.com";
	private final String password = "12345";

	@Override
	protected void setUp() {
		user = new User();
		user.setLoginEmail(loginEmail);
		user.setPassword(password);

		usMockCtrl = MockControl.createControl(ILoginService.class);
		usMock = (ILoginService) usMockCtrl.getMock();

		uLoginAction = new UserLoginAction();
		uLoginAction.setUls(usMock);
		uLoginAction.setUser(user);
	}

	public void testExecute() {
		usMockCtrl.reset();
		usMockCtrl.expectAndReturn(usMock.isUser(loginEmail, password), false);
		usMockCtrl.replay();
		assertEquals(uLoginAction.execute(), "error");
	}

	@Override
	protected void tearDown() {
		usMockCtrl.verify();
	}
}
