package com.qrms.action.staredgame;


import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.StaredGame;
import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
import com.qrms.service.IStaredGameService;

/**
 * @author WangXing & ZhangZu
 * @version 1.0
 */
public class ViewStaredGameActionTest extends TestCase {
	private IStaredGameService staredGameService;
	private MockControl staredGameMock;

	private IInspiringGameService inspiringGameService;
	private MockControl inspiringGameMock;

	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;
	private MockControl psGameMock;

	private Integer userId;
	private ViewStaredGameAction action;

	protected void setUp() throws Exception {
		staredGameMock = MockControl.createControl(IStaredGameService.class);
		inspiringGameMock = MockControl
				.createControl(IInspiringGameService.class);
		psGameMock = MockControl
				.createControl(IShowPuzzleSolvingGameDetailService.class);

		staredGameService = (IStaredGameService) staredGameMock.getMock();
		inspiringGameService = (IInspiringGameService) inspiringGameMock
				.getMock();
		puzzleSolvingGameService = (IShowPuzzleSolvingGameDetailService) psGameMock
				.getMock();

		userId = 1;

		action = new ViewStaredGameAction();
		action.setStaredGameService(staredGameService);
		action.setInspiringGameService(inspiringGameService);
		action.setPuzzleSolvingGameService(puzzleSolvingGameService);
		action.setUserId(userId);

	}

	public void testExecute() {
		staredGameMock.reset();
		staredGameMock.expectAndReturn(staredGameService.findByUserId(userId),
				new ArrayList<StaredGame>());
		staredGameMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		staredGameMock.verify();
	}

}
