package com.qrms.action.user;

import junit.framework.TestCase;
/**
 * @author Yinshunming & Zhangzu
 * @version 2.0
 * 
 * @modify 1 Wangxing & Yinshunming
 * Description:remember me function deleted
 * 
 */
public class UserLogoutActionTest extends TestCase {
	private UserLogoutAction ulAction;

	@Override
	protected void setUp() {
		ulAction = new UserLogoutAction();
	}

	public void testExecute() {
		assertEquals(ulAction.execute(), "success");
	}

	@Override
	protected void tearDown() {
	}
}
