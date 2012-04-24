package com.qrms.action.mobile;

import java.sql.Timestamp;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.dao.IStrongholdsDAO;
import com.qrms.service.mobile.IAchievementService;
import com.qrms.service.mobile.IGetCityBattleEventService;
/**
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class DefendActionTest extends TestCase {

	IGetCityBattleEventService mock;
	IAchievementService mock3;
	IStrongholdsDAO mock2;
	DefendAction action;
	MockControl control;
	MockControl control2;
	MockControl control3;

	protected void setUp() throws Exception {
		super.setUp();

		control3 = MockControl.createControl(IAchievementService.class);
		mock3 = (IAchievementService) control3.getMock();
		mock3.defendAchievement(1);
		control3.replay();

		control2 = MockControl.createControl(IStrongholdsDAO.class);
		mock2 = (IStrongholdsDAO) control2.getMock();
		control2.replay();

		control = MockControl.createControl(IGetCityBattleEventService.class);
		mock = (IGetCityBattleEventService) control.getMock();

		mock.getStrongholdDao();
		control.setReturnValue(mock2);
		mock.addSetupEvent(1, 1, new Timestamp(System.currentTimeMillis()));
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
		control2.verify();
		control2.reset();
		control3.verify();
		control3.reset();
	}

	public void testExecute() {
		action = new DefendAction();
		action.setLatitude("0.0");
		action.setLongitude("0.0");
		action.setId("1");
		action.setGetcbes(mock);
		action.execute();
		assertEquals(action.getStrResult(), "SUCCESS");
	}

}
