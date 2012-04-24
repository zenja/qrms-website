package com.qrms.action.user;

import junit.framework.TestCase;
import org.easymock.MockControl;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.service.ISaveNotValidatedUserService;
import com.qrms.service.IUserService;

/**
 * @author Zhaolu & Yinshunming
 * @version 1.
 */
public class UserRegisterActionTest extends TestCase {

	UserRegisterAction ura;
	UserNotValidatedInfo nvUser;
	IUserService mockUs;
	ISaveNotValidatedUserService mockNvus;
	MockControl controlUs;
	MockControl controlNvus;

	public void setUp() {
		nvUser = new UserNotValidatedInfo();
		nvUser.setLoginEmail("a");

		controlUs = MockControl.createControl(IUserService.class);
		mockUs = (IUserService) controlUs.getMock();
		controlUs.expectAndDefaultReturn(mockUs.isUserExists("a"), false);
		controlUs.replay();

		controlNvus = MockControl
				.createControl(ISaveNotValidatedUserService.class);
		mockNvus = (ISaveNotValidatedUserService) controlNvus.getMock();
		controlNvus.expectAndReturn(mockNvus.isExists("a"), false);
		mockNvus.save(nvUser);
		controlNvus.replay();

		ura = new UserRegisterAction();
		ura.setNvuser(nvUser);
		ura.setNvuserService(mockNvus);
		ura.setUserService(mockUs);
	}

	public void testExecute() {
		assertEquals(ura.execute(), "success");
	}

	public void tearDown() {
		controlUs.verify();
		controlNvus.verify();
	}
}
