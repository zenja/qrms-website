package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * Description: this action retrieves all the territories in a city
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetCityTerritoryListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private String city;

	private IGetMyTerritoryService getmts;

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

	public IGetMyTerritoryService getGetmts() {
		return getmts;
	}

	public void setGetmts(IGetMyTerritoryService getmts) {
		this.getmts = getmts;
	}

	/**
	 * call the GetMyTerritoryService to get the territories
	 * 
	 * @return ArrayList<Map<String,Object>>
	 */
	public String execute() {
		mapArrayResult = getmts.getCityTerritories(city);
		return "mapArrayResult";
	}

}
