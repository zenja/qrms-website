package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetMyTerritoryService;

/**
 * Description: this action retrieves the territories of a player
 * 
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyTerritoryListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private String id;

	private IGetMyTerritoryService getmts;

	public IGetMyTerritoryService getGetmts() {
		return getmts;
	}

	public void setGetmts(IGetMyTerritoryService getmts) {
		this.getmts = getmts;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * call the GetMyTerritoryService to get the messages
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		int iid = Integer.parseInt(id);
		mapArrayResult = getmts.getMyTerritories(iid);
		return "mapArrayResult";
	}

}
