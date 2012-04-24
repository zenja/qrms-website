package com.qrms.bean;

// default package

/**
 * RankBySetupNum entity. @author MyEclipse Persistence Tools
 */

public class RankBySetupNum implements java.io.Serializable {

	// Fields

	private Integer userid;
	private Integer exp;
	private Integer setupnum;
	private Integer occupyingnum;
	private String name;

	// Constructors

	/** default constructor */
	public RankBySetupNum() {
	}

	/** full constructor */
	public RankBySetupNum(Integer userid, Integer exp, Integer setupnum,
			Integer occupyingnum, String name) {
		this.userid = userid;
		this.exp = exp;
		this.setupnum = setupnum;
		this.occupyingnum = occupyingnum;
		this.name = name;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getExp() {
		return this.exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getSetupnum() {
		return this.setupnum;
	}

	public void setSetupnum(Integer setupnum) {
		this.setupnum = setupnum;
	}

	public Integer getOccupyingnum() {
		return this.occupyingnum;
	}

	public void setOccupyingnum(Integer occupyingnum) {
		this.occupyingnum = occupyingnum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}