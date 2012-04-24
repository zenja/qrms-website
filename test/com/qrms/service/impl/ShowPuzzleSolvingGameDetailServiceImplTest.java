package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;

/**
 * @author Wangxing & Zhangzu
 * @version 2.0
 *  modified 1: by wangxing & Zhangzu 
 */

public class ShowPuzzleSolvingGameDetailServiceImplTest extends TestCase {

	private MockControl control;
	private IPuzzleSolvingGameInfoDAO mock;
	private ShowPuzzleSolvingGameDetailServiceImpl service;
	PuzzleSolvingGameInfo info = new PuzzleSolvingGameInfo();
	List<PuzzleSolvingGameInfo> list = new ArrayList<PuzzleSolvingGameInfo>();

	public void setUp() {
		// create service
		service = new ShowPuzzleSolvingGameDetailServiceImpl();

		// make return values

		list.add(info);

		// create control
		control = MockControl.createControl(IPuzzleSolvingGameInfoDAO.class);

		// get mock
		mock = (IPuzzleSolvingGameInfoDAO) control.getMock();
		service.setPuzzleSolvingGameInfoDAO(mock);

	}

	public void tearDown() {
		control.reset();
	}

	public void testGetPuzzleSolvingGameInfoByUserId() {
		mock.findByUserId(1);
		control.setReturnValue(list);
		control.replay();
		assertNotNull(service.getPuzzleSolvingGameInfoByUserId(1));
		control.verify();
	}

	public void testGetPuzzleSolvingGameInfoByGameId() {
		mock.findById(1);
		control.setReturnValue(info);
		control.replay();
		assertNotNull(service.getPuzzleSolvingGameInfoByGameId(1));
		control.verify();
	}

}
