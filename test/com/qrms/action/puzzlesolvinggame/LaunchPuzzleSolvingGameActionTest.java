package com.qrms.action.puzzlesolvinggame;

import java.util.Date;

import com.qrms.action.puzzlesolvinggame.LaunchPuzzleSolvingGameAction;
import com.qrms.bean.PuzzleSolvingGameInfo;
import junit.framework.TestCase;


/**
 * @author Wangxing & Zhaolu
 * @version 1.0
 */
public class LaunchPuzzleSolvingGameActionTest extends TestCase {

	// test execute method in the class
	public void testExecute() {
		LaunchPuzzleSolvingGameAction action = new LaunchPuzzleSolvingGameAction();
		PuzzleSolvingGameInfo info = new PuzzleSolvingGameInfo();
		// info.setClue("This is a clue");
		info.setDifficultyLevel(5);
		info.setCity("Nanjing");
		info.setNation("China");
		info.setProvince("Jiangsu");
		info.setDifficultyLevel(5);
		info.setTerrainLevel(4);
		info.setHint("This is a hint");
		info.setGameName("Test Game 1");
		// info.setGameLauncherName("wangxing");
		info.setPlaceDate(new Date(234325324));
		action.setGameInfo(info);
		try {
			assertEquals(action.execute(), "success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
