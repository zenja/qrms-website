package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IAchievementService;

/** 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetAchievementActionTest extends TestCase {

	MockControl control;
	GetAchievementAction action;
	IAchievementService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IAchievementService.class);
		mock = (IAchievementService) control.getMock();

		mock.getAchievement(1);
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetAchievementAction();
		action.setId(1);
		action.setAchievementService(mock);
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
