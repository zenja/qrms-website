package com.qrms.action.gamecomment;

import org.easymock.MockControl;

import com.qrms.service.IGameCommentService;

import junit.framework.TestCase;
/**
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class MakeGameCommentActionTest extends TestCase {
	private IGameCommentService gameCommentService;
	private MockControl gcMock;

	private MakeGameCommentAction action;

	protected void setUp() throws Exception {
		gcMock = MockControl.createNiceControl(IGameCommentService.class);
		gameCommentService = (IGameCommentService) gcMock.getMock();

		action = new MakeGameCommentAction();
		action.setGameCommentService(gameCommentService);
		action.setGameComment(null);
	}

	public void testExecute() {
		gcMock.reset();
		gcMock.replay();
		assertEquals(action.execute(), "input");
	}

	protected void tearDown() throws Exception {
		gcMock.verify();
	}

}
