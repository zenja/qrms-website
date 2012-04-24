package com.qrms.bean;

/**
 * Description: tbl_userinfo entity.
 * 
 * @author WangXing
 * @version 1.0
 * @date July 10 2010
 * 
 *       Modify_1: --Date: Aug 6 2010 --Some more fields added --Author:WangXing
 */

public class User {

	private static final long serialVersionUID = 1L;

	// Fields
	private Integer id;
	private String loginEmail;
	private String password;
	private String name;
	private String nation;
	private String province;
	private String city;
	private String photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
