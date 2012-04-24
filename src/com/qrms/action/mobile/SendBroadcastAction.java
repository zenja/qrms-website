package com.qrms.action.mobile;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.CityBroadcast;
import com.qrms.service.mobile.IGetCityBroadcastService;

/**
 * Description: this action sends the broadcast information within a city
 * 
 * @author ZhaoLu & Yinshunming
 * @version 1.0
 */
public class SendBroadcastAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private CityBroadcast broadcast;
	private String strResult;
	private IGetCityBroadcastService getcbs;

	public CityBroadcast getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(CityBroadcast broadcast) {
		this.broadcast = broadcast;
	}

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public IGetCityBroadcastService getGetcbs() {
		return getcbs;
	}

	public void setGetcbs(IGetCityBroadcastService getcbs) {
		this.getcbs = getcbs;
	}

	/**
	 * call the GetCityBroadcastService send the information
	 * 
	 * @return String
	 */
	public String execute() {
		Timestamp d = new Timestamp(System.currentTimeMillis());
		broadcast.setTime(d);
		getcbs.saveMsg(broadcast);
		strResult = SUCCESS;
		return "strResult";
	}

}
