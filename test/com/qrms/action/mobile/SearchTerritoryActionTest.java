package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */
public class SearchTerritoryActionTest extends TestCase {
	MockControl control;
	SearchTerritoryAction action;
	IGetMyTerritoryService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetMyTerritoryService.class);
		mock = (IGetMyTerritoryService) control.getMock();

		mock.getSearchTerritories("test");
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new SearchTerritoryAction();
		action.setGetmts(mock);
		action.setCondition("test");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
