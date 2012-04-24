package com.qrms.action.mobile;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.CityBroadcast;
import com.qrms.service.mobile.IGetCityBroadcastService;
/**
 * @author ZhaoLu & Yinshunming
 * @version 1.0
 */
public class SendBroadcastActionTest extends TestCase {

	MockControl control;
	SendBroadcastAction action;
	IGetCityBroadcastService mock;
	CityBroadcast cb = new CityBroadcast();

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBroadcastService.class);
		mock = (IGetCityBroadcastService) control.getMock();

		mock.saveMsg(cb);
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new SendBroadcastAction();
		action.setGetcbs(mock);
		action.setBroadcast(cb);
		action.execute();
		assertNotNull(action.getStrResult());
	}

}
