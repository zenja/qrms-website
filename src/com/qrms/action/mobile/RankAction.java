package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.mobile.IRankService;

/**
 * Description: this action maps the rank function
 * 
 * @author ZhaoLu & YinShunming
 * @version 1.0
 */
public class RankAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList<Map<String, Object>> mapArrayResult;

	private String standard;

	private IRankService rs;

	public IRankService getRs() {
		return rs;
	}

	public void setRs(IRankService rs) {
		this.rs = rs;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	/**
	 * rank by experience or setup number or occupying number
	 * 
	 * @return ArrayList<Map<String,Object>> type
	 */
	public String execute() {
		if (standard.equals("exp")) {
			mapArrayResult = rs.rankByExp();
		}
		if (standard.equals("setup")) {
			mapArrayResult = rs.rankBySetupNum();
		}
		if (standard.equals("occupy")) {
			mapArrayResult = rs.rankByOccupyingNum();
		}
		return "mapArrayResult";
	}

}
