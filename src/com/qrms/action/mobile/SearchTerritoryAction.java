package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * Description: this action maps the searching territories function
 * 
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */
public class SearchTerritoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;
	private String condition;
	private IGetMyTerritoryService getmts;

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public IGetMyTerritoryService getGetmts() {
		return getmts;
	}

	public void setGetmts(IGetMyTerritoryService getmts) {
		this.getmts = getmts;
	}

	/**
	 * call the GetMyTerritoryService to do the searching function
	 * 
	 * @return String
	 */
	public String execute() {
		mapArrayResult = getmts.getSearchTerritories(condition);
		return "mapArrayResult";
	}
}
