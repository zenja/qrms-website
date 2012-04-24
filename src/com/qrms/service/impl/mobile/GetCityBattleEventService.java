package com.qrms.service.impl.mobile;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.qrms.bean.BattleEvent;
import com.qrms.bean.Strongholds;
import com.qrms.bean.User;
import com.qrms.dao.IBattleEventDAO;
import com.qrms.dao.IStrongholdsDAO;
import com.qrms.dao.IUserDAO;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this service deals with the battle event related functions
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public class GetCityBattleEventService implements IGetCityBattleEventService {

	IBattleEventDAO battleEventDao;

	IUserDAO userDao;

	IStrongholdsDAO strongholdDao;

	public IBattleEventDAO getBattleEventDao() {
		return battleEventDao;
	}

	public void setBattleEventDao(IBattleEventDAO battleEventDao) {
		this.battleEventDao = battleEventDao;
	}

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public IStrongholdsDAO getStrongholdDao() {
		return strongholdDao;
	}

	public void setStrongholdDao(IStrongholdsDAO strongholdDao) {
		this.strongholdDao = strongholdDao;
	}

	/**
	 * get the battle events happened in city
	 * 
	 * @param city: the city name
	 * @return the battle event list
	 */
	public ArrayList<Map<String, Object>> getCityBattleEvent(String city) {
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<Strongholds> strongholdsList = strongholdDao.findByCity(city);
		if (strongholdsList == null)
			return null;

		Iterator<Strongholds> itr = strongholdsList.iterator();

		Strongholds strongholds = null;
		BattleEvent battleEvent = null;
		int strongholdId = -1;
		int attackerId = -1;
		while (itr.hasNext()) {
			strongholds = itr.next();
			strongholdId = strongholds.getId();
			List<BattleEvent> battleEventList = battleEventDao
					.findByStrongholdid(strongholdId);
			if (battleEventList == null)
				return null;

			Iterator<BattleEvent> itra = battleEventList.iterator();
			while (itra.hasNext()) {
				battleEvent = itra.next();
				attackerId = battleEvent.getAttackerid();
				User attacker = userDao.findUserById(attackerId);
				TreeMap map = new TreeMap();
				map.put("content", attacker.getName() + " occupied "
						+ strongholds.getName());
				map.put("date", battleEvent.getBattletime());
				result.add(map);
			}

		}
		return result;
	}

	/**
	 * get the battle news sent to a player
	 * 
	 * @param id :the player's id
	 * @return the news list
	 */
	public ArrayList<Map<String, Object>> getMyNews(int id) {
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		BattleEvent battleEvent = null;
		Strongholds strongholds = null;
		List<BattleEvent> battleEventList = battleEventDao.findByAttackerid(id);
		if (battleEventList == null) {
			return null;
		}
		Iterator<BattleEvent> itr = battleEventList.iterator();

		while (itr.hasNext()) {
			try {
				battleEvent = itr.next();
				strongholds = (Strongholds) strongholdDao.findById(battleEvent
						.getStrongholdid());

				TreeMap map = new TreeMap();
				map.put("info", "I" + " occupied " + strongholds.getName()
						+ " at " + battleEvent.getBattletime());
				map.put("type", "attack");
				result.add(map);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		List<Strongholds> strongholdsList = strongholdDao.findBySetby(id);
		if (strongholdsList != null) {
			Iterator<Strongholds> itrr = strongholdsList.iterator();
			while (itrr.hasNext()) {
				try {
					strongholds = itrr.next();
					TreeMap map = new TreeMap();
					map.put("info", "I" + " setup " + strongholds.getName()
							+ " at " + strongholds.getSetdate());
					map.put("type", "defend");
					result.add(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * occupy a stronghold
	 * 
	 * @param the
	 *            attacker's id
	 * @param the
	 *            stronghold's id
	 * @param the
	 *            qr information
	 * @return 1:an attack 2: occupation 0:nothing happened
	 */
	public int occupy(int attackerId, int strongholdId, String qrInfo) {
		Strongholds strongholds = getStrongholdDao().findById(strongholdId);
		String qr_Info = strongholds.getQrinfo();
		if (qr_Info.equals(qrInfo)) {
			int health = strongholds.getHealth();
			BattleEvent be = new BattleEvent();
			be.setAttackerid(attackerId);
			be.setStrongholdid(strongholdId);
			Timestamp battletime = new Timestamp(System.currentTimeMillis());
			be.setBattletime(battletime);
			be.setDefenderid(strongholds.getOwnerid());
			if (health > 1) {
				strongholds.setHealth(health - 1);
				getStrongholdDao().update(strongholds);
				be.setEventtype("attack");
				battleEventDao.save(be);
				return 1;
			} else {
				strongholds.setHealth(5);
				strongholds.setOwnerid(attackerId);
				getStrongholdDao().update(strongholds);
				be.setEventtype("occupy");
				battleEventDao.save(be);
				return 2;
			}
		} else {
			return 0;
		}
	}

	/**
	 * reinforce a stronghold
	 * 
	 * @param the
	 *            owner's id
	 * @param the
	 *            stronghold's id
	 * @return string
	 */
	public String reinforce(int ownerId, int strongholdId) {
		Strongholds strongholds = strongholdDao.findById(strongholdId);
		int health = strongholds.getHealth();
		if (health != 10) {
			health = (health + 3) % 10;
			strongholds.setHealth(health);
			strongholdDao.update(strongholds);
			BattleEvent be = new BattleEvent();
			be.setAttackerid(0);
			be.setEventtype("reinforce");
			be.setBattletime(new Timestamp(System.currentTimeMillis()));
			be.setDefenderid(ownerId);
			be.setStrongholdid(strongholdId);
			battleEventDao.save(be);
			return ("Reinforce success! Now the health point is " + health + ".");
		} else {
			return "Your stronghold is in full state!";
		}

	}

	/**
	 * get the territories information
	 * 
	 * @param the
	 *            stronghold's id
	 * @return information list
	 */
	public ArrayList<Map<String, Object>> getTerritoryInfo(int strongholdId) {
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		Strongholds stronghold = strongholdDao.findById(strongholdId);
		TreeMap<String, Object> map = new TreeMap<String, Object>();
		map.put("name", stronghold.getName());
		map.put("lat", stronghold.getLatitude());
		map.put("longt", stronghold.getLongitude());
		map.put("city", stronghold.getCity());
		map.put("nation", stronghold.getNation());
		map.put("owner", userDao.findUserById(stronghold.getOwnerid())
				.getName());
		map.put("setupBy", userDao.findUserById(stronghold.getSetby())
				.getName());
		map.put("setDate", stronghold.getSetdate());
		map.put("health", stronghold.getHealth());
		map.put("ownerId", stronghold.getOwnerid());
		result.add(map);
		return result;
	}

	/**
	 * add the event news of setting up a stronghold
	 * 
	 * @param the
	 *            defender's id
	 * @param the
	 *            stronghold's id
	 * @param the
	 *            set up time
	 * @return no return value
	 */
	public void addSetupEvent(int id, int strongholdId, Timestamp ts) {
		BattleEvent be = new BattleEvent();
		be.setAttackerid(0);
		be.setBattletime(ts);
		be.setEventtype("setup");
		be.setDefenderid(id);
		be.setStrongholdid(strongholdId);
		battleEventDao.save(be);
	}

}
