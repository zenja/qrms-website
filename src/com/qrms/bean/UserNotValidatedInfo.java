package com.qrms.bean;

import java.sql.Timestamp;

/**
 * TblUsernotvalidateidnfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UserNotValidatedInfo implements java.io.Serializable {

	// Fields
	private Integer id;
	private String encryptkey;
	private String loginEmail;
	private String password;
	private String name;
	private Timestamp date;

	private static final long serialVersionUID = 1L;

	public String getEncryptkey() {
		return encryptkey;
	}

	public void setEncryptkey(String encryptkey) {
		this.encryptkey = encryptkey;
	}

	// Constructors

	/** default constructor */
	public UserNotValidatedInfo() {
	}

	/** full constructor */
	public UserNotValidatedInfo(String encryptkey, String loginEmail,
			String password, String name, Timestamp date) {
		this.encryptkey = encryptkey;
		this.loginEmail = loginEmail;
		this.password = password;
		this.name = name;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}