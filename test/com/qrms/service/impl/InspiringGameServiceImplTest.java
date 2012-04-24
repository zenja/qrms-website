package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.InspiringGameInfo;
import com.qrms.dao.IInspiringGameInfoDAO;
/**
 * @author Yinshunming & Wangxing
 * @version 2.0
 * modify 1: Wangxing & Zhangzu 
 */
public class InspiringGameServiceImplTest extends TestCase {

	MockControl control;
	InspiringGameServiceImpl service;
	IInspiringGameInfoDAO mock;

	protected void setUp() throws Exception {
		super.setUp();
		InspiringGameInfo info = new InspiringGameInfo();
		info.setLatitude(0.0);
		info.setLongitude(0.0);
		List<InspiringGameInfo> list = new ArrayList<InspiringGameInfo>();
		list.add(info);

		service = new InspiringGameServiceImpl();

		control = MockControl.createControl(IInspiringGameInfoDAO.class);
		mock = (IInspiringGameInfoDAO) control.getMock();
		service.setInspiringGameInfoDAO(mock);

		mock.findByLatitude(0.0);
		control.setReturnValue(list);
		control.replay();
	}

	protected void tearDown() throws Exception {
		control.reset();
		super.tearDown();
	}

	public void testSeekByCoordinate() {
		assertNotNull(service.seekByCoordinate(0.0, 0.0));
	}
}
