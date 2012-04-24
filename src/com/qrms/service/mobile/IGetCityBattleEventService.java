package com.qrms.service.mobile;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import com.qrms.dao.IStrongholdsDAO;

/**
 * Description: the interface of GetCityBattleEventServiceImpl
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public interface IGetCityBattleEventService {

	public ArrayList<Map<String, Object>> getCityBattleEvent(String city);

	public ArrayList<Map<String, Object>> getMyNews(int id);

	public int occupy(int attackId, int strongholdId, String qrInfo);

	public String reinforce(int ownerId, int strongholdId);

	public ArrayList<Map<String, Object>> getTerritoryInfo(int strongholdId);

	public void addSetupEvent(int id, int strongholdId, Timestamp ts);

	public IStrongholdsDAO getStrongholdDao();

	public void setStrongholdDao(IStrongholdsDAO strongholdDao);
}