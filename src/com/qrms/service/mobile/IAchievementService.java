package com.qrms.service.mobile;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description: the interface of the AchievementServiceImpl , it provides
 * methods which is related to achievement
 * 
 * @author ZhaoLu & Yinshunming
 * @version 1.0
 */
public interface IAchievementService {

	public abstract void occupyAchievement(int id);

	public abstract void defendAchievement(int id);

	public ArrayList<Map<String, Object>> getAchievement(int id);
}
