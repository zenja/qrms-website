package com.qrms.bean;

import java.util.Date;

/**
 * Description: tbl_puzzlesolvinggameinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 * @version 2.0
 * 
 *          modify 1: yinshunming 6 August 2010 description:add a column which
 *          name is defaultLL.It indicates that if the langtitude and latitude
 *          is exact
 */

public class PuzzleSolvingGameInfo implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User tblUserinfo; // foreign key
	private String gameName;
	private Date placeDate;
	private String pictureUrl;
	private String nation;
	private String province;
	private Integer difficultyLevel;
	private Integer terrainLevel;
	private String longDescription;
	private String hint;
	private Double longitude;
	private Double latitude;
	private Integer qrNum;
	private String city;
	private Integer defaultLL;

	public Integer getDefaultLL() {
		return defaultLL;
	}

	public void setDefaultLL(Integer defaultLL) {
		this.defaultLL = defaultLL;
	}

	/** default constructor */
	public PuzzleSolvingGameInfo() {
	}

	/** minimal constructor */
	public PuzzleSolvingGameInfo(User tblUserinfo, String gameName,
			Date placeDate, String nation, String province,
			Integer difficultyLevel, Integer terrainLevel, Integer qrNum,
			String city) {
		this.tblUserinfo = tblUserinfo;
		this.gameName = gameName;
		this.placeDate = placeDate;
		this.nation = nation;
		this.province = province;
		this.difficultyLevel = difficultyLevel;
		this.terrainLevel = terrainLevel;
		this.qrNum = qrNum;
		this.city = city;
	}

	/** full constructor */
	public PuzzleSolvingGameInfo(User tblUserinfo, String gameName,
			Date placeDate, String pictureUrl, String nation, String province,
			Integer difficultyLevel, Integer terrainLevel,
			String longDescription, String hint, Double longitude,
			Double latitude, Integer qrNum, String city, Integer defaultLL) {
		this.tblUserinfo = tblUserinfo;
		this.gameName = gameName;
		this.placeDate = placeDate;
		this.pictureUrl = pictureUrl;
		this.nation = nation;
		this.province = province;
		this.difficultyLevel = difficultyLevel;
		this.terrainLevel = terrainLevel;
		this.longDescription = longDescription;
		this.hint = hint;
		this.longitude = longitude;
		this.latitude = latitude;
		this.qrNum = qrNum;
		this.city = city;
		this.defaultLL = defaultLL;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getTblUserinfo() {
		return this.tblUserinfo;
	}

	public void setTblUserinfo(User tblUserinfo) {
		this.tblUserinfo = tblUserinfo;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Date getPlaceDate() {
		return this.placeDate;
	}

	public void setPlaceDate(Date placeDate) {
		this.placeDate = placeDate;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getDifficultyLevel() {
		return this.difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getTerrainLevel() {
		return this.terrainLevel;
	}

	public void setTerrainLevel(Integer terrainLevel) {
		this.terrainLevel = terrainLevel;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getQrNum() {
		return this.qrNum;
	}

	public void setQrNum(Integer qrNum) {
		this.qrNum = qrNum;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}