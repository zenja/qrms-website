package com.qrms.bean;

import java.util.Date;

/**
 * Strongholds entity. @author MyEclipse Persistence Tools
 */

public class Strongholds implements java.io.Serializable {

	// Fields

	private Integer id;
	private String qrinfo;
	private Double latitude;
	private Double longitude;
	private String name;
	private String city;
	private String province;
	private String nation;
	private Integer setby;
	private Date setdate;
	private Integer ownerid;
	private Integer health;

	// Constructors

	/** default constructor */
	public Strongholds() {
	}

	/** minimal constructor */
	public Strongholds(Integer setby) {
		this.setby = setby;
	}

	/** full constructor */
	public Strongholds(String qrinfo, Double latitude, Double longitude,
			String name, String city, String province, String nation,
			Integer setby, Date setdate, Integer ownerid, Integer health) {
		this.qrinfo = qrinfo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.city = city;
		this.province = province;
		this.nation = nation;
		this.setby = setby;
		this.setdate = setdate;
		this.ownerid = ownerid;
		this.health = health;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQrinfo() {
		return this.qrinfo;
	}

	public void setQrinfo(String qrinfo) {
		this.qrinfo = qrinfo;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getSetby() {
		return this.setby;
	}

	public void setSetby(Integer setby) {
		this.setby = setby;
	}

	public Date getSetdate() {
		return this.setdate;
	}

	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}

	public Integer getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public Integer getHealth() {
		return this.health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

}