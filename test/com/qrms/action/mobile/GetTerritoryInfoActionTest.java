package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetCityBattleEventService;

/** 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetTerritoryInfoActionTest extends TestCase {

	MockControl control;
	GetTerritoryInfoAction action;
	IGetCityBattleEventService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBattleEventService.class);
		mock = (IGetCityBattleEventService) control.getMock();

		mock.getTerritoryInfo(1);
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetTerritoryInfoAction();
		action.setGetcbes(mock);
		action.setStrongholdId("1");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
