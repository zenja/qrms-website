package com.qrms.action.mobile;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class ReinforceActionTest extends TestCase {

	MockControl control;
	ReinforceAction action;
	IGetCityBattleEventService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBattleEventService.class);
		mock = (IGetCityBattleEventService) control.getMock();

		mock.reinforce(1, 1);
		control.setReturnValue("success");
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new ReinforceAction();
		action.setGetcbes(mock);
		action.setUserId("1");
		action.setStrongholdId("1");
		action.execute();
		assertNotNull(action.getStrResult());
	}
}
