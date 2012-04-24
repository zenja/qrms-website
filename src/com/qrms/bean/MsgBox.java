package com.qrms.bean;

// default package

import java.sql.Timestamp;

/**
 * MsgBox entity. @author MyEclipse Persistence Tools
 */

public class MsgBox implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer receiverid;
	private String content;
	private Timestamp time;
	private Boolean checked;

	// Constructors

	/** default constructor */
	public MsgBox() {
	}

	/** full constructor */
	public MsgBox(Integer receiverid, String content, Timestamp time,
			Boolean checked) {
		this.receiverid = receiverid;
		this.content = content;
		this.time = time;
		this.checked = checked;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReceiverid() {
		return this.receiverid;
	}

	public void setReceiverid(Integer receiverid) {
		this.receiverid = receiverid;
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

	public Boolean getChecked() {
		return this.checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}