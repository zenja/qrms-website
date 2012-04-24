package com.qrms.service.impl;

import java.util.Iterator;
import java.util.List;

import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.dao.IPuzzleSolvingGameInfoDAO;
import com.qrms.service.ISeekGameService;

/**
 * Descroption: The implemement of the interface It uses DAO Object to find and
 * save info in the PuzzleSolvingGameInfo
 * 
 * @author Zhaolu & Zhangzu
 * @version 1.0
 */

public class SeekGameImpl implements ISeekGameService {

	IPuzzleSolvingGameInfoDAO gameInfoDAO;

	public IPuzzleSolvingGameInfoDAO getGameInfoDAO() {
		return gameInfoDAO;
	}

	public void setGameInfoDAO(IPuzzleSolvingGameInfoDAO gameInfoDAO) {
		this.gameInfoDAO = gameInfoDAO;
	}

	/**
	 * Description: The method seeks the puzzleSolvingGameInfo by city
	 * 
	 * @param Object
	 * @return List<PuzzleSolvingGameInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> seekByCity(Object o) {
		List<PuzzleSolvingGameInfo> result = null;
		result = gameInfoDAO.findByCity(o);
		return result;
	}

	/**
	 * Description: The method seeks the puzzleSovingGameInfo by prov
	 * 
	 * @param Object
	 * @return List<PuzzleSolvingGameInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> seekByProv(Object o) {
		List<PuzzleSolvingGameInfo> result = null;
		result = gameInfoDAO.findByProvince(o);
		return result;
	}

	/**
	 * Description: The method seeks the puzzleSolvingGameInfo by cou
	 * 
	 * @param Object
	 * @return List<PuzzleSolvingGameInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> seekByCou(Object o) {
		List<PuzzleSolvingGameInfo> result = null;
		result = gameInfoDAO.findByNation(o);
		return result;
	}

	/**
	 * Description: The method seeks the puzzleSolvingGameInfo by latitude and
	 * longtitude
	 * 
	 * @param Object
	 * @return List<PuzzleSolvingGameInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> seekByOriginLatLong(Object lat,
			Object longt) {
		List<PuzzleSolvingGameInfo> result = null;
		result = gameInfoDAO.findByLatitude(lat);
		Iterator<PuzzleSolvingGameInfo> it = result.iterator();
		while (it.hasNext()) {
			PuzzleSolvingGameInfo psgi = (PuzzleSolvingGameInfo) it.next();
			if (!psgi.getLongitude().equals(longt)) {
				it.remove();
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<PuzzleSolvingGameInfo> seekByArea(double latitude,
			double longitude, double radius) {
		List<PuzzleSolvingGameInfo> result = null;
		result = gameInfoDAO.findByArea(latitude, longitude, radius);
		return result;
	}

}
