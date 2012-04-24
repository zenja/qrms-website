package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.mobile.IMsgBoxService;

/**
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMsgBoxListActionTest extends TestCase {

	MockControl control;
	GetMsgBoxListAction action;
	IMsgBoxService mock;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IMsgBoxService.class);
		mock = (IMsgBoxService) control.getMock();

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
		action = new GetMsgBoxListAction();
		action.setMsgBoxService(mock);
		action.setId(1);
		action.execute();
		assertNotNull(action.getMapArrayResult());
	}

}
