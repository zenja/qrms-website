package com.qrms.service.impl;

import java.util.Iterator;
import java.util.List;

import com.qrms.bean.InspiringGameInfo;
import com.qrms.dao.IInspiringGameInfoDAO;
import com.qrms.service.IInspiringGameService;

/**
 * Description: This is the implemention of the interface IInspiringGameService
 * 
 * @author Yinshunming & Wangxing
 * @version 2.0
 * 
 *          modify 1: Wangxing & Zhangzu Description: add the method that finds
 *          inspiringgame by user's id
 */
public class InspiringGameServiceImpl implements IInspiringGameService {

	private IInspiringGameInfoDAO inspiringGameInfoDAO;

	public IInspiringGameInfoDAO getInspiringGameInfoDAO() {
		return inspiringGameInfoDAO;
	}

	public void setInspiringGameInfoDAO(
			IInspiringGameInfoDAO inspiringGameInfoDAO) {
		this.inspiringGameInfoDAO = inspiringGameInfoDAO;
	}

	public void deleteGame(InspiringGameInfo info) {
		inspiringGameInfoDAO.delete(info);

	}

	public InspiringGameInfo findGame(Integer id) {
		return inspiringGameInfoDAO.findById(id);
	}

	public void launchGame(InspiringGameInfo info) {
		inspiringGameInfoDAO.save(info);

	}

	/**
	 * This method finds the InspringGameInfos by latitude,longitude and radius
	 * 
	 * @param  latitude : latitude of the area
	 * @param  longitude : longitude of the area
	 * @param  radius : radius of the area
	 * @return list of the InspiringGameInfo
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> seekByArea(double latitude,
			double longitude, double radius) {
		List<InspiringGameInfo> result = inspiringGameInfoDAO.findByArea(
				latitude, longitude, radius);
		return result;
	}

	/**
	 * This method gets the list of the InspringGame by city
	 * 
	 * @param city : the city to query
	 * @return the list of the InspiringGameInfo found
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> seekByCity(String city) {
		List<InspiringGameInfo> result = inspiringGameInfoDAO.findByCity(city);
		return result;
	}

	/**
	 * This method gets the list of the InspringGames by coordinate
	 * 
	 * @param  latitude : the latitude of the place
	 * @param  longitude :the longitude of the place
	 * @return the list of the Inspiring game found
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> seekByCoordinate(double latitude,
			double longitude) {
		List<InspiringGameInfo> result = null;
		result = inspiringGameInfoDAO.findByLatitude(latitude);
		Iterator<InspiringGameInfo> it = result.iterator();
		while (it.hasNext()) {
			InspiringGameInfo theInfo = (InspiringGameInfo) it.next();
			if (!theInfo.getLongitude().equals(longitude)) {
				it.remove();
			}
		}
		return result;
	}

	/**
	 * This method gets the list of InspiringGames by nation
	 * 
	 * @param  nation : the nation to query
	 * @return list of the inspiringgames found
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> seekByNation(String nation) {
		List<InspiringGameInfo> result = inspiringGameInfoDAO
				.findByNation(nation);
		return result;
	}

	/**
	 * This method gets the list of InspiringGames by province
	 * 
	 * @param  province : the province to query
	 * @return list of Inspiringgames found
	 */
	@SuppressWarnings("unchecked")
	public List<InspiringGameInfo> seekByProvince(String province) {
		List<InspiringGameInfo> result = inspiringGameInfoDAO
				.findByProvince(province);
		return result;
	}

	/**
	 * added by wangxing & Zhangzu This method gets the list of InspiringGames
	 * by userid
	 * 
	 * @param  userID : the id of the user
	 * @return list of Inspiringgame found
	 */
	public List<InspiringGameInfo> getInspiringGameInfoByUserId(Integer userId) {
		List<InspiringGameInfo> result = inspiringGameInfoDAO
				.findByUserId(userId);
		return result;
	}

	/**
	 * This method updates the info of an inspiringGame
	 */
	public void modifyGameInfoByExample(InspiringGameInfo gameInfo) {
		inspiringGameInfoDAO.update(gameInfo);
	}

}
