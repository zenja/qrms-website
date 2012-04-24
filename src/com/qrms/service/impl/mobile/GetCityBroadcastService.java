package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.qrms.bean.CityBroadcast;
import com.qrms.dao.ICityBroadcastDAO;
import com.qrms.dao.IUserDAO;
import com.qrms.service.mobile.IGetCityBroadcastService;
import com.qrms.service.mobile.IMsgBoxService;

/**
 * Description: this service deals with the broadcast information happened in a
 * city
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public class GetCityBroadcastService implements IGetCityBroadcastService,
		IMsgBoxService {

	ICityBroadcastDAO cityBroadcastDao;
	IUserDAO userDao;

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public ICityBroadcastDAO getCityBroadcastDao() {
		return cityBroadcastDao;
	}

	public void setCityBroadcastDao(ICityBroadcastDAO cityBroadcastDao) {
		this.cityBroadcastDao = cityBroadcastDao;
	}

	/**
	 * get the broadcast information happened in city
	 * 
	 * @param city : the city name
	 * @return the broadcast information list
	 */
	public ArrayList<Map<String, Object>> getCityBroadcast(String city) {
		// TODO Auto-generated method stub
		ArrayList<Map<String, Object>> broadcast;
		List<CityBroadcast> broadcastList = cityBroadcastDao.findByCity(city);
		if (broadcastList != null) {
			broadcast = new ArrayList<Map<String, Object>>();
			Iterator<CityBroadcast> itr = broadcastList.iterator();
			while (itr.hasNext()) {
				TreeMap<String, Object> map = new TreeMap<String, Object>();
				CityBroadcast temp = itr.next();
				map.put("name", userDao.findUserById(temp.getSpeakerid())
						.getName());
				map.put("content", temp.getContent());
				broadcast.add(map);
			}
			return broadcast;
		}
		return null;
	}

	/**
	 * get the broadcast information sent to a player
	 * 
	 * @param id : the player's id
	 * @return the broadcast information list
	 */
	public ArrayList<Map<String, Object>> getMyMsg(int id) {
		ArrayList<Map<String, Object>> msg;
		List<CityBroadcast> msgList = cityBroadcastDao.findBySpeakerid(id);
		if (msgList != null) {
			msg = new ArrayList<Map<String, Object>>();
			Iterator<CityBroadcast> itr = msgList.iterator();
			while (itr.hasNext()) {
				TreeMap<String, Object> map = new TreeMap<String, Object>();
				CityBroadcast temp = itr.next();
				map.put("time", temp.getTime());
				map.put("info", temp.getContent());
				msg.add(map);
			}
			return msg;
		}
		return null;
	}

	/**
	 * save the broadcast information
	 * 
	 * @param broadcast : the broadcast informaiton
	 * @return the return value
	 */
	public void saveMsg(CityBroadcast broadcast) {
		cityBroadcastDao.save(broadcast);
	}

}
