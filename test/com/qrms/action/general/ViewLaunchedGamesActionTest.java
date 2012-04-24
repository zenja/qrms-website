package com.qrms.action.general;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IInspiringGameService;
import com.qrms.service.IShowPuzzleSolvingGameDetailService;
/**
 * @author WangXing & ZhangZu
 * @version 1.0
 */
public class ViewLaunchedGamesActionTest extends TestCase {
	private IInspiringGameService inspiringGameService;
	private MockControl igMock;
	private IShowPuzzleSolvingGameDetailService puzzleSolvingGameService;
	private MockControl psgMock;

	private ViewLaunchedGamesAction action;
	private Integer userId = 1;

	protected void setUp() throws Exception {
		igMock = MockControl.createNiceControl(IInspiringGameService.class);
		psgMock = MockControl
				.createNiceControl(IShowPuzzleSolvingGameDetailService.class);

		inspiringGameService = (IInspiringGameService) igMock.getMock();
		puzzleSolvingGameService = (IShowPuzzleSolvingGameDetailService) psgMock
				.getMock();

		action = new ViewLaunchedGamesAction();
		action.setInspiringGameService(inspiringGameService);
		action.setPuzzleSolvingGameService(puzzleSolvingGameService);
		action.setUserId(userId);
	}

	public void testExecute() {
		igMock.reset();
		psgMock.reset();
		igMock.replay();
		psgMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
