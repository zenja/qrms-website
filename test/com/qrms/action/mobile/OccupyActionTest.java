package com.qrms.action.mobile;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IAchievementService;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */
public class OccupyActionTest extends TestCase {

	MockControl control1;
	MockControl control2;
	OccupyAction action;
	IAchievementService mock1;
	IGetCityBattleEventService mock2;

	protected void setUp() throws Exception {
		super.setUp();
		control1 = MockControl.createControl(IAchievementService.class);
		mock1 = (IAchievementService) control1.getMock();
		mock1.occupyAchievement(1);
		control1.replay();

		control2 = MockControl.createControl(IGetCityBattleEventService.class);
		mock2 = (IGetCityBattleEventService) control2.getMock();
		mock2.occupy(1, 1, "test");
		control2.setReturnValue(2);
		control2.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control1.verify();
		control1.reset();
		control2.verify();
		control2.reset();
	}

	public void testExecute() {
		action = new OccupyAction();
		action.setAs(mock1);
		action.setGetcbes(mock2);
		action.setAttackerId("1");
		action.setStrongholdId("1");
		action.setQrInfo("test");
		assertEquals(action.execute(), "strResult");
		assertEquals(action.getStrResult(), "occupy");

		control2.reset();
		mock2.occupy(1, 1, "test");
		control2.setReturnValue(1);
		control2.replay();
		control1.reset();
		mock1.occupyAchievement(1);
		control1.replay();
		assertEquals(action.execute(), "strResult");
		assertEquals(action.getStrResult(), "attack");

		control2.reset();
		mock2.occupy(1, 1, "test");
		control2.setReturnValue(0);
		control2.replay();
		control1.reset();
		mock1.occupyAchievement(1);
		control1.replay();
		assertEquals(action.execute(), "strResult");
		assertEquals(action.getStrResult(), "qrcode not match");
	}

}
