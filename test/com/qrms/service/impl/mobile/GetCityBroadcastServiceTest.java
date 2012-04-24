package com.qrms.service.impl.mobile;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.CityBroadcast;
import com.qrms.dao.ICityBroadcastDAO;
import com.qrms.dao.IUserDAO;

/**
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public class GetCityBroadcastServiceTest extends TestCase {

	private MockControl control;
	private ICityBroadcastDAO mock;
	private MockControl control2;
	private IUserDAO mock2;
	private GetCityBroadcastService service;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(ICityBroadcastDAO.class);
		mock = (ICityBroadcastDAO) control.getMock();

		control2 = MockControl.createControl(IUserDAO.class);
		mock2 = (IUserDAO) control2.getMock();
		// mock2.findBySetby(1);
		// control2.setReturnValue(new ArrayList<Strongholds>());

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
	}

	public void testGetCityBroadcast() {
		service = new GetCityBroadcastService();
		service.setCityBroadcastDao(mock);
		service.setUserDao(mock2);

		control.reset();
		mock.findByCity("test");
		control.setReturnValue(new ArrayList<CityBroadcast>());
		control.replay();
		assertNotNull(service.getCityBroadcast("test"));
	}

	public void testGetMyMsg() {
		service = new GetCityBroadcastService();
		service.setCityBroadcastDao(mock);
		service.setUserDao(mock2);

		control.reset();
		mock.findBySpeakerid(1);
		control.setReturnValue(new ArrayList<CityBroadcast>());
		control.replay();
		assertNotNull(service.getMyMsg(1));
	}
}
