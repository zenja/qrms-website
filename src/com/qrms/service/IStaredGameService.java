package com.qrms.service;

import java.util.List;

import com.qrms.bean.StaredGame;

/**
 * Description: This is the interface of StartedGameImpl. It provides some
 * methods which are related to the function star a game
 * 
 * @author Zhangzu & Wangxing
 * @version 1.0
 */
public interface IStaredGameService {

	/** to check if the game is stared by this user */
	boolean isStared(Integer userId, int gameType, Integer gameId);

	void setStared(Boolean isStared, Integer userId, Integer gameType,
			Integer gameId);

	List<StaredGame> findByUserId(Integer userId);

}
