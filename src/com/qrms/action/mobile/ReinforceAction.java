package com.qrms.action.mobile;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action maps the reinforcing function
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class ReinforceAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	String userId;

	String strongholdId;

	String strResult;

	IGetCityBattleEventService getcbes;

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStrongholdId() {
		return strongholdId;
	}

	public void setStrongholdId(String strongholdId) {
		this.strongholdId = strongholdId;
	}

	public IGetCityBattleEventService getGetcbes() {
		return getcbes;
	}

	public void setGetcbes(IGetCityBattleEventService getcbes) {
		this.getcbes = getcbes;
	}

	/**
	 * call the GetCityBattleEventService to do the reinforcing function
	 * 
	 * @return String
	 */
	public String execute() {
		strResult = getcbes.reinforce(Integer.parseInt(userId), Integer
				.parseInt(strongholdId));
		return strResult;
	}
}
