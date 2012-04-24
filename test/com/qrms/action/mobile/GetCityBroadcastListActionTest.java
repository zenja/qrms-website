package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.CityBroadcast;
import com.qrms.service.mobile.IGetCityBroadcastService;

/**
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetCityBroadcastListActionTest extends TestCase {

	MockControl control;
	GetCityBroadcastListAction action;
	IGetCityBroadcastService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetCityBroadcastService.class);
		mock = (IGetCityBroadcastService) control.getMock();

		mock.getCityBroadcast("test");
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetCityBroadcastListAction();
		CityBroadcast cb = new CityBroadcast();
		cb.setCity("test");
		action.setGetcbs(mock);
		action.setCityBroadcast(cb);
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
