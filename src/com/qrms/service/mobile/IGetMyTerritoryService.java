package com.qrms.service.mobile;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description: the interface of GetMyTerritoryImpl It provides some functions
 * related to territory
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public interface IGetMyTerritoryService {

	public ArrayList<Map<String, Object>> getMyTerritories(int ownerId);

	public ArrayList<Map<String, Object>> getCityTerritories(String city);

	public ArrayList<Map<String, Object>> getSearchTerritories(String condition);
}
