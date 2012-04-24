package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action retrieves the news sent to a player
 * 
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyNewsListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String id;

	private IGetCityBattleEventService getcbes;

	private ArrayList<Map<String, Object>> mapArrayResult;

	public IGetCityBattleEventService getGetcbes() {
		return getcbes;
	}

	public void setGetcbes(IGetCityBattleEventService getcbes) {
		this.getcbes = getcbes;
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
	 * call the GetCityBattleEventService to get the messages
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		int iid = Integer.parseInt(id);
		mapArrayResult = getcbes.getMyNews(iid);// IGetCityBattleEventService
		return "mapArrayResult";
	}

}
