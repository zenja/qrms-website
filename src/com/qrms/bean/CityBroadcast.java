package com.qrms.bean;

// default package

import java.sql.Timestamp;

/**
 * CityBroadcast entity. @author MyEclipse Persistence Tools
 */

public class CityBroadcast implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer speakerid;
	private String city;
	private String content;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public CityBroadcast() {
	}

	/** minimal constructor */
	public CityBroadcast(Integer speakerid, String city, Timestamp time) {
		this.speakerid = speakerid;
		this.city = city;
		this.time = time;
	}

	/** full constructor */
	public CityBroadcast(Integer speakerid, String city, String content,
			Timestamp time) {
		this.speakerid = speakerid;
		this.city = city;
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

	public Integer getSpeakerid() {
		return this.speakerid;
	}

	public void setSpeakerid(Integer speakerid) {
		this.speakerid = speakerid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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