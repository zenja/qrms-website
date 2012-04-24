package com.qrms.service.impl.mobile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.qrms.bean.RankByExp;
import com.qrms.bean.RankByOccupyingNum;
import com.qrms.bean.RankBySetupNum;
import com.qrms.dao.IRankByExpDAO;
import com.qrms.dao.IRankByOccupyingNumDAO;
import com.qrms.dao.IRankBySetupNumDAO;
import com.qrms.service.mobile.IRankService;

/**
 * Description: this service deals with the ranking functions
 * 
 * @author ZhaoLu & Zhangzu
 * @version 1.0
 */
public class RankService implements IRankService {

	IRankByExpDAO rankByExpDao;

	IRankByOccupyingNumDAO rankByOccupyingNumDao;

	IRankBySetupNumDAO rankBySetupNumDao;

	public IRankByExpDAO getRankByExpDao() {
		return rankByExpDao;
	}

	public void setRankByExpDao(IRankByExpDAO rankByExpDao) {
		this.rankByExpDao = rankByExpDao;
	}

	public IRankByOccupyingNumDAO getRankByOccupyingNumDao() {
		return rankByOccupyingNumDao;
	}

	public void setRankByOccupyingNumDao(
			IRankByOccupyingNumDAO rankByOccupyingNumDao) {
		this.rankByOccupyingNumDao = rankByOccupyingNumDao;
	}

	public IRankBySetupNumDAO getRankBySetupNumDao() {
		return rankBySetupNumDao;
	}

	public void setRankBySetupNumDao(IRankBySetupNumDAO rankBySetupNumDao) {
		this.rankBySetupNumDao = rankBySetupNumDao;
	}

	/**
	 * get the rank information sorted by experiences of a player
	 * 
	 * @param
	 * @return the rank information list
	 */
	public ArrayList<Map<String, Object>> rankByExp() {
		List<RankByExp> list = (List<RankByExp>) rankByExpDao.findAll();
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Iterator<RankByExp> itr = list.iterator();
		while (itr.hasNext()) {
			RankByExp rank = itr.next();
			Map<String, Object> map = new TreeMap<String, Object>();
			map.put("name", rank.getName());
			map.put("exp", rank.getExp());
			map.put("occupying", rank.getOccupyingnum());
			map.put("setup", rank.getSetupnum());
			result.add(map);
		}
		return result;
	}

	/**
	 * get the rank information sorted by occupying number of a player
	 * 
	 * @param
	 * @return the rank information list
	 */
	public ArrayList<Map<String, Object>> rankByOccupyingNum() {
		List<RankByOccupyingNum> list = (List<RankByOccupyingNum>) rankByOccupyingNumDao
				.findAll();
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Iterator<RankByOccupyingNum> itr = list.iterator();
		while (itr.hasNext()) {
			RankByOccupyingNum rank = itr.next();
			Map<String, Object> map = new TreeMap<String, Object>();
			map.put("name", rank.getName());
			map.put("exp", rank.getExp());
			map.put("occupying", rank.getOccupyingnum());
			map.put("setup", rank.getSetupnum());
			result.add(map);
		}
		return result;
	}

	/**
	 * get the rank information sorted by setup number of a player
	 * 
	 * @param
	 * @return the rank information list
	 */
	public ArrayList<Map<String, Object>> rankBySetupNum() {
		List<RankBySetupNum> list = (List<RankBySetupNum>) rankBySetupNumDao
				.findAll();
		ArrayList<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Iterator<RankBySetupNum> itr = list.iterator();
		while (itr.hasNext()) {
			RankBySetupNum rank = itr.next();
			Map<String, Object> map = new TreeMap<String, Object>();
			map.put("name", rank.getName());
			map.put("exp", rank.getExp());
			map.put("occupying", rank.getOccupyingnum());
			map.put("setup", rank.getSetupnum());
			result.add(map);
		}
		return result;
	}

}
