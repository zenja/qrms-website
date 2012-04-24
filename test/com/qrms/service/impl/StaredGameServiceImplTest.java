package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.StaredGame;
import com.qrms.dao.IStaredGameDAO;
/**
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class StaredGameServiceImplTest extends TestCase {

	MockControl control;
	IStaredGameDAO mock;
	StaredGameServiceImpl service;

	protected void setUp() throws Exception {
		super.setUp();
		StaredGame staredGame = new StaredGame();
		List<StaredGame> list = new ArrayList<StaredGame>();
		list.add(staredGame);
		service = new StaredGameServiceImpl();
		control = MockControl.createControl(IStaredGameDAO.class);
		mock = (IStaredGameDAO) control.getMock();
		service.setStaredGameDAO(mock);

		mock.findByUserIdAndGameTypeAndGameId(1, 1, 1);
		control.setReturnValue(list);
		control.replay();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsStared() {
		assertTrue(service.isStared(1, 1, 1));
	}

}
