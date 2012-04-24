package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetCityBroadcastService;

/**
 * Description: this action retrieves the messages sent to a player
 * 
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMyMsgListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String id;

	private IGetCityBroadcastService getcbs;

	private ArrayList<Map<String, Object>> mapArrayResult;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IGetCityBroadcastService getGetcbs() {
		return getcbs;
	}

	public void setGetcbs(IGetCityBroadcastService getcbs) {
		this.getcbs = getcbs;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	/**
	 * call the GetCityBroadcastService to get the messages
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		int iid = Integer.parseInt(id);
		mapArrayResult = getcbs.getMyMsg(iid);// IGetCityBroadcastService
		return "mapArrayResult";
	}
}
