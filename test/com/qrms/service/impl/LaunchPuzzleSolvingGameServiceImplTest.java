package com.qrms.service.impl;

import java.util.Date;

import org.easymock.MockControl;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
import com.qrms.service.ILaunchPuzzleSolvingGameService;

import junit.framework.TestCase;

/**
 * @author Wangxin & Yinshunming
 * @version 1.0
 */
public class LaunchPuzzleSolvingGameServiceImplTest extends TestCase {
	private MockControl control;
	ILaunchPuzzleSolvingGameService launchPuzzleSolvingGameService;
	IPuzzleSolvingGameInfoDAO puzzleSolvingGameInfoDAO;
	PuzzleSolvingGameInfo gameInfo;

	public void setUp() {
		gameInfo = new PuzzleSolvingGameInfo();
		gameInfo.setCity("Test_Beijing");
		// gameInfo.setClue("This is a test clue");
		gameInfo.setDifficultyLevel(3);
		gameInfo.setTerrainLevel(2);
		// gameInfo.setGameLauncherName("Test Game Launcher");
		gameInfo.setGameName("Test Game Name");
		gameInfo.setHint("Test Hint");
		// gameInfo.setLastFoundDate(new Date(32524556));
		gameInfo.setLatitude(44.444);
		gameInfo.setLongitude(33.333);
		gameInfo.setLongDescription("Test Long Description");
		gameInfo.setNation("Test_China");
		// gameInfo.setNoteToReviewer("Note to reviewer");
		gameInfo.setPictureUrl("Test_picURL");
		gameInfo.setPlaceDate(new Date(25443525));
		gameInfo.setProvince("Test_Beijing Province");
		gameInfo.setQrNum(9);
		// gameInfo.setShortDescription("Test Short Description.");
		// gameInfo.setUrl("Test_url");

		launchPuzzleSolvingGameService = new LaunchPuzzleSolvingGameServiceImpl();

		// create mock
		control = MockControl.createControl(IPuzzleSolvingGameInfoDAO.class);

		// record
		puzzleSolvingGameInfoDAO = (IPuzzleSolvingGameInfoDAO) control
				.getMock();
		puzzleSolvingGameInfoDAO.findById(1);
		control.setReturnValue(new PuzzleSolvingGameInfo(), 1);
		control.replay();
	}

	public void tearDown() {
		control.verify();
		control.reset();
	}

	public void testFindById() {
		((LaunchPuzzleSolvingGameServiceImpl) launchPuzzleSolvingGameService)
				.setPuzzleSolvingGameInfoDAO(puzzleSolvingGameInfoDAO);
		assertNotNull(launchPuzzleSolvingGameService.findById(1));

	}

}
