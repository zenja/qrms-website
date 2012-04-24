package com.qrms.service.impl.mobile;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.MsgBox;
import com.qrms.dao.IMsgBoxDAO;
/**
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public class MsgBoxServiceTest extends TestCase {
	private MockControl control;
	private IMsgBoxDAO mock;
	private MsgBoxService service;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IMsgBoxDAO.class);
		mock = (IMsgBoxDAO) control.getMock();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
	}

	public void testGetMyMsg() {
		service = new MsgBoxService();
		service.setMsgBoxDao(mock);

		control.reset();
		mock.findByReceiverid(1);
		control.setReturnValue(new ArrayList<MsgBox>());
		control.replay();
		assertNotNull(service.getMyMsg(1));
	}
}
