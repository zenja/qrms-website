package com.qrms.service.impl.mobile;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.RankByExp;
import com.qrms.dao.IRankByExpDAO;
import com.qrms.dao.IRankByOccupyingNumDAO;
import com.qrms.dao.IRankBySetupNumDAO;
/**
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public class RankServiceTest extends TestCase {

	private MockControl control1;
	private IRankByExpDAO mock1;
	private MockControl control2;
	private IRankByOccupyingNumDAO mock2;
	private MockControl control3;
	private IRankBySetupNumDAO mock3;
	private RankService service;

	protected void setUp() throws Exception {
		super.setUp();
		control1 = MockControl.createControl(IRankByExpDAO.class);
		mock1 = (IRankByExpDAO) control1.getMock();

		control2 = MockControl.createControl(IRankByOccupyingNumDAO.class);
		mock2 = (IRankByOccupyingNumDAO) control2.getMock();

		control3 = MockControl.createControl(IRankBySetupNumDAO.class);
		mock3 = (IRankBySetupNumDAO) control3.getMock();

		service = new RankService();
		service.setRankByExpDao(mock1);
		service.setRankByOccupyingNumDao(mock2);
		service.setRankBySetupNumDao(mock3);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRankByExp() {
		control1.reset();
		mock1.findAll();
		control1.setReturnValue(new ArrayList<RankByExp>());
		control1.replay();
		assertNotNull(service.rankByExp());
	}

	public void testRankByOccupyingNum() {
		control2.reset();
		mock2.findAll();
		control2.setReturnValue(new ArrayList<RankByExp>());
		control2.replay();
		assertNotNull(service.rankByOccupyingNum());
	}

	public void testRankBySetupNum() {
		control3.reset();
		mock3.findAll();
		control3.setReturnValue(new ArrayList<RankByExp>());
		control3.replay();
		assertNotNull(service.rankBySetupNum());
	}
}
