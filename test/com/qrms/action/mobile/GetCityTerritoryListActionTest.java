package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetMyTerritoryService;

/** 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetCityTerritoryListActionTest extends TestCase {

	MockControl control;
	GetCityTerritoryListAction action;
	IGetMyTerritoryService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetMyTerritoryService.class);
		mock = (IGetMyTerritoryService) control.getMock();

		mock.getCityTerritories("test");
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetCityTerritoryListAction();
		action.setGetmts(mock);
		action.setCity("test");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
