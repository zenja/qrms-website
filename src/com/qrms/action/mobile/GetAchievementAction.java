package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IAchievementService;

/**
 * Description: this action retrieves the achievement of a player
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class GetAchievementAction extends ActionSupport {

	private static final long serialVersionUID = -8638332060236961145L;

	private IAchievementService achievementService;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private int id;

	public IAchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievementService(IAchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * call the AchievementService to get the achievement
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		mapArrayResult = achievementService.getAchievement(id);
		return "mapArrayResult";
	}

}
