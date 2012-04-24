package com.qrms.service.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.qrms.bean.CityBroadcast;

/**
 * Description: this service of GetCityBroadcastServiceImpl It provides
 * functions about getting city broadcasts
 * 
 * @author Zhangzu & ZhaoLu
 * @version 1.0
 */
public interface IGetCityBroadcastService {

	public ArrayList<Map<String, Object>> getCityBroadcast(String city);

	public ArrayList<Map<String, Object>> getMyMsg(int id);

	public void saveMsg(CityBroadcast broadcast);
}
