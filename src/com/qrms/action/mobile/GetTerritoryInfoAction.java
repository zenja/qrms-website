package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action retrieves the territories information
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetTerritoryInfoAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private IGetCityBattleEventService getcbes;

	private String strongholdId;

	private ArrayList<Map<String, Object>> mapArrayResult;

	public IGetCityBattleEventService getGetcbes() {
		return getcbes;
	}

	public void setGetcbes(IGetCityBattleEventService getcbes) {
		this.getcbes = getcbes;
	}

	public String getStrongholdId() {
		return strongholdId;
	}

	public void setStrongholdId(String strongholdId) {
		this.strongholdId = strongholdId;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	/**
	 * call the GetCityBattleEventService to get the information
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		mapArrayResult = getcbes.getTerritoryInfo(Integer
				.parseInt(strongholdId));
		return "mapArrayResult";
	}
}
