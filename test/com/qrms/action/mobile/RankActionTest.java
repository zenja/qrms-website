package com.qrms.action.mobile;

import java.util.ArrayList;

import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IRankService;

/**
 * @author ZhaoLu & YinShunming
 * @version 1.0
 */
public class RankActionTest extends TestCase {

	MockControl control;
	RankAction action;
	IRankService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IRankService.class);
		mock = (IRankService) control.getMock();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testExecute() {
		action = new RankAction();
		action.setRs(mock);

		control.reset();
		action.setStandard("exp");
		mock.rankByExp();
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
		action.execute();
		assertNotNull(action.getMapArrayResult());

		control.reset();
		action.setStandard("setup");
		mock.rankBySetupNum();
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
		action.execute();
		assertNotNull(action.getMapArrayResult());

		control.reset();
		action.setStandard("occupy");
		mock.rankByOccupyingNum();
		control.setReturnValue(new ArrayList<Map<String, Object>>());
		control.replay();
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
