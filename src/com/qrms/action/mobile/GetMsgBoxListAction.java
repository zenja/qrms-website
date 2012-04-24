package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.qrms.service.mobile.IMsgBoxService;

/**
 * Description: this action retrieves the messages
 * 
 * @author ZhaoLu & WangXing
 * @version 1.0
 */
public class GetMsgBoxListAction {
	private IMsgBoxService msgBoxService;
	private ArrayList<Map<String, Object>> mapArrayResult;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IMsgBoxService getMsgBoxService() {
		return msgBoxService;
	}

	public void setMsgBoxService(IMsgBoxService msgBoxService) {
		this.msgBoxService = msgBoxService;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	/**
	 * call the MsgBoxService to get the messages
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		mapArrayResult = msgBoxService.getMyMsg(id);
		return "mapArrayResult";
	}
}
