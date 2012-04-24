package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.GameComment;
import com.qrms.service.IGameCommentService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;

public class ShowPuzzleSolvingGameDetailActionTest extends TestCase {
	private IShowPuzzleSolvingGameDetailService showPuzzleSolvingGameDetailService;
	private MockControl spsgdMock;

	private IGameCommentService gameCommentService;
	private MockControl gcMock;

	private ShowPuzzleSolvingGameDetailAction action;
	private Integer gameId = 1;

	protected void setUp() throws Exception {
		spsgdMock = MockControl
				.createControl(IShowPuzzleSolvingGameDetailService.class);
		gcMock = MockControl.createControl(IGameCommentService.class);

		showPuzzleSolvingGameDetailService = (IShowPuzzleSolvingGameDetailService) spsgdMock
				.getMock();
		gameCommentService = (IGameCommentService) gcMock.getMock();

		action = new ShowPuzzleSolvingGameDetailAction();
		action
				.setShowPuzzleSolvingGameDetailService(showPuzzleSolvingGameDetailService);
		action.setGameCommentService(gameCommentService);
		action.setGameId(gameId);

	}

	protected void tearDown() throws Exception {
		spsgdMock.verify();
		gcMock.verify();
	}

	public void testExecute() throws Exception {
		spsgdMock.reset();
		gcMock.reset();
		gcMock.expectAndReturn(gameCommentService
				.getGameCommentListForPuzzleSolvingByGameId(gameId),
				new ArrayList<GameComment>());
		spsgdMock.replay();
		gcMock.replay();

		assertEquals(action.execute(), "showDetail");
	}

}
