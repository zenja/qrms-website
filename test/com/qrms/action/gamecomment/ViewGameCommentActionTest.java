package com.qrms.action.gamecomment;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.GameComment;
import com.qrms.service.IGameCommentService;
/**
 * @author yinshunming & zhaolu
 * @version 1.0
 */
public class ViewGameCommentActionTest extends TestCase {
	private IGameCommentService gameCommentService;
	private Integer commentId = 4;
	private MockControl gcMock;

	private ViewGameCommentAction action;

	protected void setUp() throws Exception {
		gcMock = MockControl.createControl(IGameCommentService.class);
		gameCommentService = (IGameCommentService) gcMock.getMock();

		action = new ViewGameCommentAction();
		action.setCommentId(commentId);
		action.setGameCommentService(gameCommentService);
	}

	public void testExecute() {
		gcMock.reset();
		gcMock.expectAndReturn(gameCommentService
				.getGameCommentByCommentId(commentId), new GameComment());
		gcMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		gcMock.verify();
	}

}
