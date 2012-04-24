package com.qrms.bean;

// default package

/**
 * ErrorReport entity. @author MyEclipse Persistence Tools
 */

public class ErrorReport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer strongholdid;
	private Integer reporterid;
	private String errormsg;

	// Constructors

	/** default constructor */
	public ErrorReport() {
	}

	/** minimal constructor */
	public ErrorReport(Integer strongholdid, Integer reporterid) {
		this.strongholdid = strongholdid;
		this.reporterid = reporterid;
	}

	/** full constructor */
	public ErrorReport(Integer strongholdid, Integer reporterid, String errormsg) {
		this.strongholdid = strongholdid;
		this.reporterid = reporterid;
		this.errormsg = errormsg;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStrongholdid() {
		return this.strongholdid;
	}

	public void setStrongholdid(Integer strongholdid) {
		this.strongholdid = strongholdid;
	}

	public Integer getReporterid() {
		return this.reporterid;
	}

	public void setReporterid(Integer reporterid) {
		this.reporterid = reporterid;
	}

	public String getErrormsg() {
		return this.errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}