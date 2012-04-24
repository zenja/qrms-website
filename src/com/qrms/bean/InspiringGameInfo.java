package com.qrms.bean;

// default package

import com.qrms.bean.User;
import java.util.Date;

/**
 * InspiringGameInfo entity. @author MyEclipse Persistence Tools
 */

public class InspiringGameInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private User user; // foreign key
	private QRContent qrContent; // foreign key
	private String gameName;
	private Double latitude;
	private Double longitude;
	private Date placeDate;
	private String hint;
	private String city;
	private String province;
	private String nation;
	private String pictureUrl;

	// Constructors

	/** default constructor */
	public InspiringGameInfo() {
	}

	/** minimal constructor */
	public InspiringGameInfo(User tblUserinfo, QRContent QRContent,
			String gameName, Double latitude, Double longitude, Date placeDate,
			String city, String province, String nation) {
		this.user = tblUserinfo;
		this.qrContent = QRContent;
		this.gameName = gameName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.placeDate = placeDate;
		this.city = city;
		this.province = province;
		this.nation = nation;
	}

	/** full constructor */
	public InspiringGameInfo(User tblUserinfo, QRContent QRContent,
			String gameName, Double latitude, Double longitude, Date placeDate,
			String hint, String city, String province, String nation,
			String pictureUrl) {
		this.user = tblUserinfo;
		this.qrContent = QRContent;
		this.gameName = gameName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.placeDate = placeDate;
		this.hint = hint;
		this.city = city;
		this.province = province;
		this.nation = nation;
		this.pictureUrl = pictureUrl;
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

	public void setUser(User tblUserinfo) {
		this.user = tblUserinfo;
	}

	public QRContent getQrContent() {
		return this.qrContent;
	}

	public void setQrContent(QRContent QRContent) {
		this.qrContent = QRContent;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
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

	public Date getPlaceDate() {
		return this.placeDate;
	}

	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
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

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

}