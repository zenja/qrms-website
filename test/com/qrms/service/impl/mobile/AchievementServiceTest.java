package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.Achievement;
import com.qrms.dao.IAchievementDAO;
/**
 * @author ZhaoLu & Yinshunming
 * @version 1.0
 */
public class AchievementServiceTest extends TestCase {

	private MockControl control;
	private IAchievementDAO mock;
	private AchievementService service;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IAchievementDAO.class);
		mock = (IAchievementDAO) control.getMock();

		service = new AchievementService();
		service.setAchievementDao(mock);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDefendAchievement() {
		List<Achievement> list = new ArrayList<Achievement>();
		Achievement a = new Achievement();
		a.setId(0);
		a.setLevel(0);
		a.setMoney(0);
		list.add(a);
		control.reset();
		mock.findByUserid(0);
		control.setReturnValue(list);
		mock.findById(0);
		control.setReturnValue(a);
		mock.update(a);
		control.replay();
		service.defendAchievement(0);

	}

	public void testOccupyAchievement() {
		List<Achievement> list = new ArrayList<Achievement>();
		Achievement a = new Achievement();
		a.setId(0);
		a.setLevel(0);
		a.setMoney(0);
		list.add(a);
		control.reset();
		mock.findByUserid(0);
		control.setReturnValue(list);
		mock.findById(0);
		control.setReturnValue(a);
		mock.update(a);
		control.replay();
		service.occupyAchievement(0);

	}

	public void testGetAchievement() {
		List<Achievement> list = new ArrayList<Achievement>();
		Achievement a = new Achievement();
		a.setId(0);
		a.setLevel(0);
		a.setMoney(0);
		list.add(a);
		control.reset();
		mock.findByUserid(0);
		control.setReturnValue(list);
		control.replay();
		assertNotNull(service.getAchievement(0));
	}

}
