package com.qrms.action.mobile;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IAchievementService;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action maps the occupying function
 * 
 * @author ZhaoLu & YinShunMing
 * @version 1.0
 */
public class OccupyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	IAchievementService as;

	IGetCityBattleEventService getcbes;

	String attackerId;

	String strongholdId;

	String strResult;

	String qrInfo;

	public String getQrInfo() {
		return qrInfo;
	}

	public void setQrInfo(String qrInfo) {
		this.qrInfo = qrInfo;
	}

	public String getAttackerId() {
		return attackerId;
	}

	public void setAttackerId(String attackerId) {
		this.attackerId = attackerId;
	}

	public IAchievementService getAs() {
		return as;
	}

	public void setAs(IAchievementService as) {
		this.as = as;
	}

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

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	/**
	 * need three steps: 1,change the health point of the stronghold 2,if
	 * necessary change the owner of the stronghold 3,add a record to the
	 * citybattle table 4,add achievement to the user
	 * 
	 * @return as the string content indicates
	 */
	public String execute() {

		try {
			int type = getcbes.occupy(Integer.parseInt(attackerId), Integer
					.parseInt(strongholdId), qrInfo);
			// 1,2,3 done
			as.occupyAchievement(Integer.parseInt(attackerId));
			// 4 done

			if (type == 2) {
				strResult = "occupy";
			}

			if (type == 1) {
				strResult = "attack";
			}
			if (type == 0) {
				strResult = "qrcode not match";
			}
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "ERROR";
		}
		return "strResult";
	}

}
