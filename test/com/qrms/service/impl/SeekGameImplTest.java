package com.qrms.service.impl;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
/**
 * @author Zhaolu & Zhangzu
 * @version 1.0
 */
public class SeekGameImplTest extends TestCase {

	ArrayList<PuzzleSolvingGameInfo> ret;
	SeekGameImpl ser;
	MockControl control;
	IPuzzleSolvingGameInfoDAO mock;

	public void setUp() {
		ser = new SeekGameImpl();
		ret = new ArrayList<PuzzleSolvingGameInfo>();
		PuzzleSolvingGameInfo info = new PuzzleSolvingGameInfo();
		info.setCity("NJ");
		info.setLongitude(0.0);
		ret.add(info);
		control = MockControl.createControl(IPuzzleSolvingGameInfoDAO.class);
		mock = (IPuzzleSolvingGameInfoDAO) control.getMock();
		ser.setGameInfoDAO(mock); // Use mock to forge the interaction
	}

	// test the method SeekByCity();
	public void testSeekByCity() {
		control.reset();
		control.expectAndReturn(mock.findByCity("NanJing"), ret);
		control.replay();
		assertEquals(ser.seekByCity("NanJing").get(0).getCity(), "NJ");
	}

	// test the method SeekByProv();
	public void testSeekByProv() {
		control.reset();
		control.expectAndReturn(mock.findByProvince("JiangSu"), ret);
		control.replay();
		assertEquals(ser.seekByProv("JiangSu").get(0).getCity(), "NJ");
	}

	// test the method testSeekByCou;
	public void testSeekByCou() {
		control.reset();
		control.expectAndReturn(mock.findByNation("China"), ret);
		control.replay();
		assertEquals(ser.seekByCou("China").get(0).getCity(), "NJ");
	}

	// test the method FindByLatLong
	public void testFindByLatLong() {
		control.reset();
		control.expectAndReturn(mock.findByLatitude(0.0), ret);
		control.replay();
		assertEquals(ser.seekByOriginLatLong(0.0, 0.0).get(0).getCity(), "NJ");
	}

	// test the method SeekByCity();
	public void tearDown() {
		control.verify();
	}

}
