package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.CityBroadcast;
import com.qrms.service.mobile.IGetCityBroadcastService;

/**
 * Description: this action retrieves the broadcasting information in a city
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetCityBroadcastListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private CityBroadcast cityBroadcast;

	private IGetCityBroadcastService getcbs;

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public CityBroadcast getCityBroadcast() {
		return cityBroadcast;
	}

	public void setCityBroadcast(CityBroadcast cityBroadcast) {
		this.cityBroadcast = cityBroadcast;
	}

	public IGetCityBroadcastService getGetcbs() {
		return getcbs;
	}

	public void setGetcbs(IGetCityBroadcastService getcbs) {
		this.getcbs = getcbs;
	}

	/**
	 * call the GetCityBroadcastService to get the broadcast information
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		mapArrayResult = getcbs.getCityBroadcast(cityBroadcast.getCity());
		return "mapArrayResult";
	}

}
