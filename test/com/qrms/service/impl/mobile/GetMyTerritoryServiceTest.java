package com.qrms.service.impl.mobile;

import java.util.ArrayList;

import org.easymock.MockControl;

import com.qrms.bean.Strongholds;
import com.qrms.dao.IStrongholdsDAO;

import junit.framework.TestCase;

public class GetMyTerritoryServiceTest extends TestCase {
	private MockControl control;
	private IStrongholdsDAO mock;
	private GetMyTerritoryService service;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IStrongholdsDAO.class);
		mock = (IStrongholdsDAO) control.getMock();

		service = new GetMyTerritoryService();
		service.setStrongholdsDao(mock);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
	}

	public void testGetMyTerritories() {
		control.reset();
		mock.findByOwnerid(1);
		control.setReturnValue(new ArrayList<Strongholds>());
		control.replay();
		assertNotNull(service.getMyTerritories(1));
	}

	public void testGetCityTerritories() {
		control.reset();
		mock.findByCity("test");
		control.setReturnValue(new ArrayList<Strongholds>());
		control.replay();
		assertNotNull(service.getCityTerritories("test"));
	}

	public void testGetSearchTerritories() {
		control.reset();
		mock.findByNameLike("test");
		control.setReturnValue(new ArrayList<Strongholds>());
		control.replay();
		assertNotNull(service.getSearchTerritories("test"));
	}
}
