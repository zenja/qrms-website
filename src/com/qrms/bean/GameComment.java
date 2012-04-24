package com.qrms.bean;

// default package

import java.sql.Timestamp;

/**
 * GameComment entity. @author MyEclipse Persistence Tools
 */

public class GameComment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int COMMENT_TYPE_FOUND = 1;
	public static final int COMMENT_TYPE_NOT_FOUND = 2;
	public static final int COMMENT_TYPE_NOTE = 3;
	public static final int COMMENT_TYPE_NEED_MAINTENANCE = 4;

	private Integer commentId;
	private User user;
	private Integer gameId;
	private Timestamp time;
	private String textcomment;
	private String photo;
	private Integer gameType;
	private Integer commentType;

	// Constructors

	/** default constructor */
	public GameComment() {
	}

	/** minimal constructor */
	public GameComment(User user, Integer gameId, Timestamp time,
			String textcomment, Integer gameType, Integer commentType) {
		this.user = user;
		this.gameId = gameId;
		this.time = time;
		this.textcomment = textcomment;
		this.gameType = gameType;
		this.commentType = commentType;
	}

	/** full constructor */
	public GameComment(User user, Integer gameId, Timestamp time,
			String textcomment, String photo, Integer gameType,
			Integer commentType) {
		this.user = user;
		this.gameId = gameId;
		this.time = time;
		this.textcomment = textcomment;
		this.photo = photo;
		this.gameType = gameType;
		this.commentType = commentType;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getTextcomment() {
		return this.textcomment;
	}

	public void setTextcomment(String textcomment) {
		this.textcomment = textcomment;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getGameType() {
		return this.gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public Integer getCommentType() {
		return this.commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

}