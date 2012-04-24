package com.qrms.bean;

// default package

/**
 * StaredGame entity. @author MyEclipse Persistence Tools
 */

public class StaredGame implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Integer gameType;
	private Integer gameId;

	// Constructors

	/** default constructor */
	public StaredGame() {
	}

	/** full constructor */
	public StaredGame(User user, Integer gameType, Integer gameId) {
		this.user = user;
		this.gameType = gameType;
		this.gameId = gameId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getGameType() {
		return this.gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

}