package com.qrms.bean;

// default package

import java.sql.Timestamp;

/**
 * InternalMessage entity. @author MyEclipse Persistence Tools
 */

public class InternalMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User userByUserFrom;
	private User userByUserTo;
	private String title;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public InternalMessage() {
	}

	/** full constructor */
	public InternalMessage(User userByUserFrom, User userByUserTo,
			String title, String content, Timestamp time) {
		this.userByUserFrom = userByUserFrom;
		this.userByUserTo = userByUserTo;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserByUserFrom() {
		return this.userByUserFrom;
	}

	public void setUserByUserFrom(User userByUserFrom) {
		this.userByUserFrom = userByUserFrom;
	}

	public User getUserByUserTo() {
		return this.userByUserTo;
	}

	public void setUserByUserTo(User userByUserTo) {
		this.userByUserTo = userByUserTo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}