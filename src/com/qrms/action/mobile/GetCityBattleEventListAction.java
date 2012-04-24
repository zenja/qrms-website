package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action retrieves the battle event in a city
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetCityBattleEventListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private String city;

	private IGetCityBattleEventService getcbes;

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public IGetCityBattleEventService getGetcbes() {
		return getcbes;
	}

	public void setGetcbes(IGetCityBattleEventService getcbes) {
		this.getcbes = getcbes;
	}

	/**
	 * call the GetCityBattleEventService to retrieve the battle events
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		mapArrayResult = getcbes.getCityBattleEvent(city);
		return "mapArrayResult";
	}

}