package com.qrms.service.impl;

import java.util.List;

import com.qrms.bean.StaredGame;
import com.qrms.bean.User;
import com.qrms.dao.IStaredGameDAO;
import com.qrms.service.IStaredGameService;

/**
 * Description: This method mainly provides services to implement the functions
 * of starring games
 * 
 * @author Wangxing & Zhangzu
 * @version 1.0
 */
public class StaredGameServiceImpl implements IStaredGameService {

	private IStaredGameDAO staredGameDAO;

	public IStaredGameDAO getStaredGameDAO() {
		return staredGameDAO;
	}

	public void setStaredGameDAO(IStaredGameDAO staredGameDAO) {
		this.staredGameDAO = staredGameDAO;
	}

	/**
	 * This method mostly judges if one given game is stared
	 * 
	 * @param userId : the id of the user
	 * @param gameType : the type of the game
	 * @param gameId : the id of the game
	 * @return false if this game is not starred 
	 *         true if all go right
	 */
	public boolean isStared(Integer userId, int gameType, Integer gameId) {
		List<StaredGame> staredGameList = staredGameDAO
				.findByUserIdAndGameTypeAndGameId(userId, gameType, gameId);
		if (staredGameList == null || staredGameList.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method changes the stat of a game
	 * 
	 * @param isStared : if the game is starred
	 * @param userId : the id of the user
	 * @param gameType : the type of the game
	 * @param gameId : the id of the game
	 */
	public void setStared(Boolean isStared, Integer userId, Integer gameType,
			Integer gameId) {
		if (isStared == true) { // if the game is not starred, do the following
			StaredGame staredGame = new StaredGame();

			User user = new User();
			user.setId(userId);
			staredGame.setUser(user);
			staredGame.setGameId(gameId);
			staredGame.setGameType(gameType);

			staredGameDAO.save(staredGame); // save to DB

		} else if (isStared == false) { // if the game is starred, do the
										// following
			List<StaredGame> staredGameList = staredGameDAO
					.findByUserIdAndGameTypeAndGameId(userId, gameType, gameId);
			if (staredGameList != null && staredGameList.size() > 0) {
				StaredGame staredGameToDelete = staredGameList.get(0);
				staredGameDAO.delete(staredGameToDelete);
			}
		}

	}

	public List<StaredGame> findByUserId(Integer userId) {
		return (List<StaredGame>) staredGameDAO.findByUserId(userId);
	}

}
