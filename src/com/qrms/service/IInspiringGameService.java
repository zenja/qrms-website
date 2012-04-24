package com.qrms.service;

import java.util.List;

import com.qrms.bean.InspiringGameInfo;

/**
 * Description:This is the interface of GameServiceImpl It provides some
 * services.
 * 
 * @author Wangxing & Zhangzu
 * @version 2.0
 * 
 *          modify 1: Wangxing Description:add some methods,get the inspiring
 *          game info by id
 */

public interface IInspiringGameService {
	public void launchGame(InspiringGameInfo info);

	public void deleteGame(InspiringGameInfo info);

	public InspiringGameInfo findGame(Integer id);

	public List<InspiringGameInfo> seekByCity(String city);

	public List<InspiringGameInfo> seekByProvince(String province);

	public List<InspiringGameInfo> seekByNation(String Nation);

	public List<InspiringGameInfo> seekByCoordinate(double latitude,
			double longitude);

	public List<InspiringGameInfo> seekByArea(double latitude,
			double longitude, double radius);

	/**
	 * added by Wangxing at 2010-12-9
	 */
	public List<InspiringGameInfo> getInspiringGameInfoByUserId(Integer userId);

	public void modifyGameInfoByExample(InspiringGameInfo gameInfo);

}