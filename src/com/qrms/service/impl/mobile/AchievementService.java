package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qrms.bean.Achievement;
import com.qrms.dao.IAchievementDAO;
import com.qrms.service.mobile.IAchievementService;

/**
 * Description: this service deals with the achievement-related functions
 * 
 * @author ZhaoLu & Yinshunming
 * @version 1.0
 */
public class AchievementService implements IAchievementService {

	IAchievementDAO achievementDao;

	public IAchievementDAO getAchievementDao() {
		return achievementDao;
	}

	public void setAchievementDao(IAchievementDAO achievementDao) {
		this.achievementDao = achievementDao;
	}

	/**
	 * adds the credits achieved by setting up a stronghold to the player
	 * 
	 * @param id :the player's id
	 */
	public void defendAchievement(int id) {
		// TODO Auto-generated method stub
		List<Achievement> list = achievementDao.findByUserid(id);
		if (list.get(0) != null) {
			Achievement achievement = achievementDao.findById(list.get(0)
					.getId());
			achievement.setMoney(achievement.getMoney() + 1000);
			achievement.setLevel(achievement.getLevel() + 100);
			achievementDao.update(achievement);
		} else {
			Achievement a = new Achievement();
			a.setUserid(id);
			a.setLevel(100);
			a.setMoney(1000);
			achievementDao.save(a);
		}
	}

	/**
	 * adds the credits achieved by occupying up a stronghold to the player
	 * 
	 * @param id :the player's id
	 */
	public void occupyAchievement(int id) {
		// TODO Auto-generated method stub
		List<Achievement> list = achievementDao.findByUserid(id);
		if (list.get(0) != null) {
			Achievement achievement = achievementDao.findById(list.get(0)
					.getId());
			achievement.setMoney(achievement.getMoney() + 2000);
			achievement.setLevel(achievement.getLevel() + 1000);
			achievementDao.update(achievement);
		} else {
			Achievement a = new Achievement();
			a.setUserid(id);
			a.setLevel(1000);
			a.setMoney(2000);
			achievementDao.save(a);
		}
	}

	/**
	 * get the achievement information of the player
	 * 
	 * @param id :the player's id
	 */
	public ArrayList<Map<String, Object>> getAchievement(int id) {

		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		List aList = achievementDao.findByUserid(id);
		Achievement a = null;
		if (aList == null || aList.size() == 0) {
			a = new Achievement();
			a.setUserid(id);
			a.setLevel(0);
			a.setMoney(0);
			achievementDao.save(a);
		} else {
			a = (Achievement) aList.get(0);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("exp", a.getLevel());
		map.put("money", a.getMoney());
		result.add(map);
		return result;
	}
}
