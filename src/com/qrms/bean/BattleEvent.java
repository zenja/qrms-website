package com.qrms.bean;

import java.sql.Timestamp;

/**
 * BattleEvent entity. @author MyEclipse Persistence Tools
 */

public class BattleEvent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer attackerid;
	private Integer defenderid;
	private Integer strongholdid;
	private Timestamp battletime;
	private String eventtype;

	// Constructors

	/** default constructor */
	public BattleEvent() {
	}

	/** minimal constructor */
	public BattleEvent(Integer defenderid, Integer strongholdid,
			Timestamp battletime, String eventtype) {
		this.defenderid = defenderid;
		this.strongholdid = strongholdid;
		this.battletime = battletime;
		this.eventtype = eventtype;
	}

	/** full constructor */
	public BattleEvent(Integer attackerid, Integer defenderid,
			Integer strongholdid, Timestamp battletime, String eventtype) {
		this.attackerid = attackerid;
		this.defenderid = defenderid;
		this.strongholdid = strongholdid;
		this.battletime = battletime;
		this.eventtype = eventtype;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAttackerid() {
		return this.attackerid;
	}

	public void setAttackerid(Integer attackerid) {
		this.attackerid = attackerid;
	}

	public Integer getDefenderid() {
		return this.defenderid;
	}

	public void setDefenderid(Integer defenderid) {
		this.defenderid = defenderid;
	}

	public Integer getStrongholdid() {
		return this.strongholdid;
	}

	public void setStrongholdid(Integer strongholdid) {
		this.strongholdid = strongholdid;
	}

	public Timestamp getBattletime() {
		return this.battletime;
	}

	public void setBattletime(Timestamp battletime) {
		this.battletime = battletime;
	}

	public String getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

}