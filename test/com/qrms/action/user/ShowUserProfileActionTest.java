package com.qrms.action.user;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.InspiringGameInfo;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.User;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IUserService;

/**
 * @author Wangxing & Yinshunming
 * @version 2.0
 * modify 1: Wangxing & Yinshunming
 */
public class ShowUserProfileActionTest extends TestCase {
	private MockControl spsgMock;
	private MockControl igMock;
	private MockControl usMock;

	private ShowUserProfileAction supAction;
	private IShowPuzzleSolvingGameDetailService spsgService;
	private IInspiringGameService igService;
	private IUserService userService;

	private Integer userId;
	private User user;

	@Override
	protected void setUp() {
		usMock = MockControl.createControl(IUserService.class);
		userService = (IUserService) usMock.getMock();

		spsgMock = MockControl
				.createControl(IShowPuzzleSolvingGameDetailService.class);
		spsgService = (IShowPuzzleSolvingGameDetailService) spsgMock.getMock();

		igMock = MockControl.createControl(IInspiringGameService.class);
		igService = (IInspiringGameService) igMock.getMock();

		userId = new Integer(0);
		user = new User();
		supAction = new ShowUserProfileAction();
		supAction.setUserInfo(user);
		supAction.setUserId(userId);
		supAction.setInspiringGameService(igService);
		supAction.setPuzzleSolvingGameService(spsgService);
		supAction.setUserService(userService);
	}

	public void testExecute() {
		spsgMock.reset();
		igMock.reset();
		usMock.reset();
		igMock.expectAndReturn(igService.getInspiringGameInfoByUserId(userId),
				new ArrayList<InspiringGameInfo>());
		spsgMock.expectAndReturn(spsgService
				.getPuzzleSolvingGameInfoByUserId(userId),
				new ArrayList<PuzzleSolvingGameInfo>());
		usMock.expectAndReturn(userService.findById(userId), user);
		spsgMock.replay();
		igMock.replay();
		usMock.replay();

		String result = "";
		try {
			result = supAction.execute();
		} catch (Exception e) {
		}

		assertEquals(result, "success");
	}

	@Override
	protected void tearDown() {
		usMock.verify();
		spsgMock.verify();
		igMock.verify();
	}
}
