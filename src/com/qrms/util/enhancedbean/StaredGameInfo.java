package com.qrms.util.enhancedbean;

import com.qrms.bean.User;

/**  
 *  Description: This bean is enhanced based on
 *         com.qrms.bean.StaredGame. An game title is added. Used by
 *         viewStaredGames.action and user/view-stared-games.jsp
 * @author Wangxing & Yinshunming 
 * @version 1.0
 */
public class StaredGameInfo {
	private String gameName;

	private User gameLauncher;

	private Integer gameId;

	private Integer gameType;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public User getGameLauncher() {
		return gameLauncher;
	}

	public void setGameLauncher(User gameLauncher) {
		this.gameLauncher = gameLauncher;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameType() {
		return gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

}
