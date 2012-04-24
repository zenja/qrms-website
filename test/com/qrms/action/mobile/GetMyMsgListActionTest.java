package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetCityBroadcastService;
/**
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyMsgListActionTest extends TestCase {

	MockControl control;
	GetMyMsgListAction action;
	IGetCityBroadcastService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBroadcastService.class);
		mock = (IGetCityBroadcastService) control.getMock();

		mock.getMyMsg(1);
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetMyMsgListAction();
		action.setGetcbs(mock);
		action.setId("1");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
