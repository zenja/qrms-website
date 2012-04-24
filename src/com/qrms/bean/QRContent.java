package com.qrms.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * QRContent entity. @author MyEclipse Persistence Tools
 */

public class QRContent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;
	private String code;
	private String content;
	private Integer gameId;
	private Integer sequence;
	private Set tblInspiringgameinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public QRContent() {
	}

	/** minimal constructor */
	public QRContent(Integer type, String code, String content, Integer gameId,
			Integer sequence) {
		this.type = type;
		this.code = code;
		this.content = content;
		this.gameId = gameId;
		this.sequence = sequence;
	}

	/** full constructor */
	public QRContent(Integer type, String code, String content, Integer gameId,
			Integer sequence, Set tblInspiringgameinfos) {
		this.type = type;
		this.code = code;
		this.content = content;
		this.gameId = gameId;
		this.sequence = sequence;
		this.tblInspiringgameinfos = tblInspiringgameinfos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getGameId() {
		return this.gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Set getTblInspiringgameinfos() {
		return this.tblInspiringgameinfos;
	}

	public void setTblInspiringgameinfos(Set tblInspiringgameinfos) {
		this.tblInspiringgameinfos = tblInspiringgameinfos;
	}

}