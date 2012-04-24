package com.qrms.service.impl.mobile;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.BattleEvent;
import com.qrms.bean.Strongholds;
import com.qrms.bean.User;
import com.qrms.dao.IBattleEventDAO;
import com.qrms.dao.IStrongholdsDAO;
import com.qrms.dao.IUserDAO;
/**
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public class GetCityBattleEventServiceTest extends TestCase {

	private MockControl control;
	private IBattleEventDAO mock;
	private MockControl control2;
	private IStrongholdsDAO mock2;
	private MockControl control3;
	private IUserDAO mock3;
	private GetCityBattleEventService service;

	protected void setUp() throws Exception {
		super.setUp();
		control = MockControl.createControl(IBattleEventDAO.class);
		mock = (IBattleEventDAO) control.getMock();

		control2 = MockControl.createControl(IStrongholdsDAO.class);
		mock2 = (IStrongholdsDAO) control2.getMock();

		control3 = MockControl.createControl(IUserDAO.class);
		mock3 = (IUserDAO) control3.getMock();

		service = new GetCityBattleEventService();
		service.setBattleEventDao(mock);
		service.setStrongholdDao(mock2);
		service.setUserDao(mock3);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetCityBattleEvent() {
		control.reset();
		control2.reset();
		control3.reset();

		User u = new User();
		u.setName("test");
		mock3.findUserById(1);
		control3.setReturnValue(u);
		control3.replay();

		List<Strongholds> sl = new ArrayList<Strongholds>();
		Strongholds s = new Strongholds();
		s.setName("test");
		sl.add(s);
		s.setCity("test");
		s.setId(1);
		mock2.findByCity("test");
		control2.setReturnValue(sl);
		control2.replay();

		List<BattleEvent> bl = new ArrayList<BattleEvent>();
		BattleEvent b = new BattleEvent();
		b.setBattletime(new Timestamp(1));
		b.setAttackerid(1);
		bl.add(b);
		mock.findByStrongholdid(1);
		control.setReturnValue(bl);
		control.replay();

		assertNotNull(service.getCityBattleEvent("test"));
	}

	public void testGetMyNews() {
		control.reset();
		control2.reset();
		control3.reset();

		User u = new User();
		u.setName("test");
		mock3.findUserById(1);
		control3.setReturnValue(u);
		control3.replay();

		// List<Strongholds> sl = new ArrayList<Strongholds>();
		Strongholds s = new Strongholds();
		s.setName("test");
		// sl.add(s);
		s.setCity("test");
		s.setId(1);
		mock2.findBySetby(1);
		control2.setReturnValue(null);
		mock2.findById(1);
		control2.setReturnValue(s);
		control2.replay();

		List<BattleEvent> bl = new ArrayList<BattleEvent>();
		BattleEvent b = new BattleEvent();
		b.setBattletime(new Timestamp(1));
		b.setStrongholdid(1);
		bl.add(b);
		mock.findByAttackerid(1);
		control.setReturnValue(bl);
		control.replay();

		assertNotNull(service.getMyNews(1));
	}

	public void testOccupy() {
		/*
		 * control.reset(); control2.reset();
		 * 
		 * List<Strongholds> sl = new ArrayList<Strongholds>(); Strongholds s =
		 * new Strongholds(); s.setName("test"); s.setQrinfo("test");
		 * s.setHealth(100); sl.add(s); s.setCity("test"); s.setId(1);
		 * mock2.findById(1); control2.setReturnValue(s); mock2.update(s);
		 * control2.replay();
		 * 
		 * List<BattleEvent> bl = new ArrayList<BattleEvent>(); BattleEvent b =
		 * new BattleEvent(); b.setBattletime(new Timestamp(1));
		 * b.setAttackerid(1); bl.add(b);
		 * mock.save((BattleEvent)EasyMock.notNull()); control.replay();
		 * 
		 * assertEquals(service.occupy(1, 1, "test"),1);
		 */
	}

	public void testReinforce() {

	}

	public void testGetTerritoryInfo() {
		control2.reset();
		control3.reset();

		Strongholds s = new Strongholds();
		s.setName("test");
		s.setLatitude(0.0);
		s.setLongitude(0.0);
		s.setNation("test");
		s.setQrinfo("test");
		s.setHealth(100);
		s.setCity("test");
		s.setId(1);
		s.setOwnerid(1);
		s.setSetby(1);
		s.setProvince("test");
		s.setSetdate(new Date(1));
		mock2.findById(1);
		control2.setReturnValue(s);
		control2.replay();

		User u = new User();
		u.setName("test");
		mock3.findUserById(1);
		control3.setReturnValue(u, 2);
		control3.replay();

		assertNotNull(service.getTerritoryInfo(1));
	}

	public void testAddSetupEvent() {
		/*
		 * control.reset();
		 * 
		 * mock.save(1); control.replay();
		 */

	}

}
