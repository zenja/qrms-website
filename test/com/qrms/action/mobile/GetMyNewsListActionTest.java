package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetCityBattleEventService;

/** 
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyNewsListActionTest extends TestCase {

	MockControl control;
	GetMyNewsListAction action;
	IGetCityBattleEventService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBattleEventService.class);
		mock = (IGetCityBattleEventService) control.getMock();

		mock.getMyNews(1);
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetMyNewsListAction();
		action.setGetcbes(mock);
		action.setId("1");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
