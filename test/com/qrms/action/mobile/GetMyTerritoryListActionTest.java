package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyTerritoryListActionTest extends TestCase {

	MockControl control;
	GetMyTerritoryListAction action;
	IGetMyTerritoryService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IGetMyTerritoryService.class);
		mock = (IGetMyTerritoryService) control.getMock();

		mock.getMyTerritories(1);
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new GetMyTerritoryListAction();
		action.setGetmts(mock);
		action.setId("1");
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
