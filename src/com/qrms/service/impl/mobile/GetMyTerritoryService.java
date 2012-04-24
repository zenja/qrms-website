package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.qrms.bean.Strongholds;
import com.qrms.dao.IStrongholdsDAO;
import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * Description: this service deals with the territory related functions
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public class GetMyTerritoryService implements IGetMyTerritoryService {

	private IStrongholdsDAO strongholdsDao;

	public IStrongholdsDAO getStrongholdsDao() {
		return strongholdsDao;
	}

	public void setStrongholdsDao(IStrongholdsDAO strongholdsDao) {
		this.strongholdsDao = strongholdsDao;
	}

	/**
	 * get the territories belongs to a player
	 * 
	 * @param  owenId : the player's id
	 * @return the territory list
	 */
	public ArrayList<Map<String, Object>> getMyTerritories(int ownerId) {

		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		List<Strongholds> strongholdsList = strongholdsDao
				.findByOwnerid(ownerId);
		Iterator<Strongholds> itr = strongholdsList.iterator();
		Strongholds stronghold;
		while (itr.hasNext()) {
			stronghold = itr.next();
			TreeMap<String, Object> map = new TreeMap<String, Object>();
			map.put("id", stronghold.getId());
			map.put("name", stronghold.getName());
			map.put("place", stronghold.getCity()/*
												 * +" "+stronghold.getProvince()+
												 * " "+stronghold.getNation()
												 */);
			result.add(map);
		}
		return result;
	}

	/**
	 * get the territories in a city
	 * 
	 * @param city :¡¡the city's name
	 * @return the territory list
	 */
	public ArrayList<Map<String, Object>> getCityTerritories(String city) {
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		List<Strongholds> strongholdsList = strongholdsDao.findByCity(city);
		Iterator<Strongholds> itr = strongholdsList.iterator();
		Strongholds stronghold;
		while (itr.hasNext()) {
			stronghold = itr.next();
			TreeMap<String, Object> map = new TreeMap<String, Object>();
			map.put("id", stronghold.getId());
			map.put("lat", stronghold.getLatitude());
			map.put("longt", stronghold.getLongitude());
			result.add(map);
		}
		return result;
	}

	/**
	 * get the territories by search condition
	 * 
	 * @param condition £ºthe search condition
	 * @return the territory list
	 */
	public ArrayList<Map<String, Object>> getSearchTerritories(String condition) {
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		List<Strongholds> strongholdsList = strongholdsDao
				.findByNameLike(condition);
		Iterator<Strongholds> itr = strongholdsList.iterator();
		Strongholds stronghold;
		while (itr.hasNext()) {
			stronghold = itr.next();
			TreeMap<String, Object> map = new TreeMap<String, Object>();
			map.put("id", stronghold.getId());
			map.put("name", stronghold.getName());
			map.put("place", stronghold.getCity());
			map.put("health", stronghold.getHealth());
			result.add(map);
		}
		return result;
	}

}
