package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.QRContent;
import com.qrms.service.IQRContentService;

/**
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */
public class RecountPuzzleSolvingGameQRCodeActionTest extends TestCase {
	private IQRContentService qrContentService;
	private MockControl qrMock;
	private RecountPuzzleSolvingGameQRCodeAction action;
	private Integer gameId = 1;

	protected void setUp() throws Exception {
		qrMock = MockControl.createControl(IQRContentService.class);
		qrContentService = (IQRContentService) qrMock.getMock();

		action = new RecountPuzzleSolvingGameQRCodeAction();
		action.setQrContentService(qrContentService);
		action.setGameId(gameId);
	}

	public void testExcute() {
		qrMock.reset();
		qrMock.expectAndReturn(qrContentService
				.findQRContentListForPuzzleSolvingGame(gameId),
				new ArrayList<QRContent>());
		qrMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		qrMock.verify();
	}

}
