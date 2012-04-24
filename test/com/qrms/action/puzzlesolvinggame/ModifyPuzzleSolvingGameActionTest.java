package com.qrms.action.puzzlesolvinggame;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.bean.QRContent;
import com.qrms.bean.User;
import com.qrms.service.ILaunchPuzzleSolvingGameService;
import com.qrms.service.IQRContentService;
/**
 * @author ZhangZu & YinShunMing
 * @version 1.0
 */
public class ModifyPuzzleSolvingGameActionTest extends TestCase {
	private ILaunchPuzzleSolvingGameService launchPuzzleSolvingGameService;
	private MockControl lpsgMock;
	private IQRContentService qrContentService;
	private MockControl qrMock;

	private Integer gameId = 1;
	private PuzzleSolvingGameInfo newGame;
	private ModifyPuzzleSolvingGameAction action;

	protected void setUp() throws Exception {
		lpsgMock = MockControl
				.createNiceControl(ILaunchPuzzleSolvingGameService.class);
		qrMock = MockControl.createNiceControl(IQRContentService.class);

		launchPuzzleSolvingGameService = (ILaunchPuzzleSolvingGameService) lpsgMock
				.getMock();
		qrContentService = (IQRContentService) qrMock.getMock();

		action = new ModifyPuzzleSolvingGameAction();
		action
				.setLaunchPuzzleSolvingGameService(launchPuzzleSolvingGameService);
		action.setQrContentService(qrContentService);
		action.setGameId(gameId);
		newGame = new PuzzleSolvingGameInfo();
	}

	public void testExecute() {
		lpsgMock.reset();
		qrMock.reset();
		PuzzleSolvingGameInfo oldGame = new PuzzleSolvingGameInfo();
		oldGame.setTblUserinfo(new User());
		lpsgMock.expectAndReturn(launchPuzzleSolvingGameService
				.findById(newGame.getId()), oldGame);
		qrMock.expectAndReturn(qrContentService
				.findQRContentListForPuzzleSolvingGame(newGame.getId()),
				new ArrayList<QRContent>());
		lpsgMock.replay();
		qrMock.replay();
	}

	protected void tearDown() throws Exception {
		lpsgMock.verify();
		qrMock.verify();
	}

}
