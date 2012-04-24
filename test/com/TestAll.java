package com;

import com.qrms.action.puzzlesolvinggame.LaunchPuzzleSolvingGameActionTest;
import com.qrms.action.puzzlesolvinggame.ShowPuzzleSolvingGameDetailActionTest;
import com.qrms.action.user.UserLoginActionTest;
import com.qrms.action.user.UserRegisterActionTest;
import com.qrms.action.user.UserValidatedActionTest;
import com.qrms.dao.impl.PuzzleSolvingGameInfoDAOImplTest;
import com.qrms.dao.impl.UserDAOImplTest;
import com.qrms.dao.impl.UserNotValidatedInfoDAOImplTest;
import com.qrms.service.impl.LaunchPuzzleSolvingGameServiceImplTest;
import com.qrms.service.impl.LoginServiceImplTest;
import com.qrms.service.impl.SaveNotValidatedUserServiceImplTest;
import com.qrms.service.impl.SeekGameImplTest;
import com.qrms.service.impl.ShowPuzzleSolvingGameDetailServiceImplTest;
import com.qrms.service.impl.UserServiceImplTest;
import com.qrms.service.impl.UserValidateServiceTest;
import com.qrms.util.MD5Test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(LaunchPuzzleSolvingGameActionTest.class);
		testSuite.addTestSuite(ShowPuzzleSolvingGameDetailActionTest.class);
		testSuite.addTestSuite(UserLoginActionTest.class);
		testSuite.addTestSuite(UserRegisterActionTest.class);
		testSuite.addTestSuite(UserValidatedActionTest.class);
		testSuite.addTestSuite(UserDAOImplTest.class);
		testSuite.addTestSuite(PuzzleSolvingGameInfoDAOImplTest.class);
		testSuite.addTestSuite(UserNotValidatedInfoDAOImplTest.class);
		testSuite.addTestSuite(LaunchPuzzleSolvingGameServiceImplTest.class);
		testSuite.addTestSuite(LoginServiceImplTest.class);
		testSuite.addTestSuite(SaveNotValidatedUserServiceImplTest.class);
		testSuite.addTestSuite(SeekGameImplTest.class);
		testSuite
				.addTestSuite(ShowPuzzleSolvingGameDetailServiceImplTest.class);
		testSuite.addTestSuite(UserServiceImplTest.class);
		testSuite.addTestSuite(UserValidateServiceTest.class);
		testSuite.addTestSuite(MD5Test.class);

		return testSuite;
	}
}
