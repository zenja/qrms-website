package com.qrms.action.puzzlesolvinggame;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.PuzzleSolvingGameInfo;
import com.qrms.service.ISeekGameService;

/**
 * Description: The class is designed as action for user when he/she wants to
 * find a game to participate in.
 * 
 * @author Zhao Lu & ZhangZu
 * @version 3.0
 * 
 * @modify 1 Zhao Lu & ZhangZu Description:add new function which is searched by
 *         longitude and latitude
 * 
 * @modify 2 YinShunMing & ZhaoLu Description:add supports to fuzzy search
 */

public class SeekGameAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ISeekGameService seekGameService;

	private double lng;

	private double lat;

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	/** key word as city name */
	private String city;

	/** the radius in miles for searching by city */
	private double radius1;

	/** key word as province/state name */
	private String prov;

	/** key word as country name */
	private String cou;

	/** key word as latitude N/E */
	private int latns;

	/** key word as latitude in hour */
	private int lath;

	/** key word as latitude in minute and second */
	private double latmmss;

	/** key word as longitude E/W */
	private int longew;

	/** key word as longitude in hour */
	private int longh;

	/** key word as longitude in minute and second */
	private double longmmss;

	/** the radius in miles for searching by latitude longitude in hh-mm-ss */
	private double radius2;

	/** key word as decimal type latitude */
	private double originlat;

	/** key word as decimal type longitude */
	private double originlong;

	/** the radius in miles for searching by latitude longitude in decimal */
	private double radius3;

	/** the search result list of game information */
	private List<PuzzleSolvingGameInfo> seekPuzzleSolvingGameResult;

	public ISeekGameService getSeekGameService() {
		return seekGameService;
	}

	public void setSeekGameService(ISeekGameService seekGameService) {
		this.seekGameService = seekGameService;
	}

	public String getCity() {
		return city;
	}

	public double getRadius1() {
		return radius1;
	}

	public void setRadius1(double radius1) {
		this.radius1 = radius1;
	}

	public double getRadius2() {
		return radius2;
	}

	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}

	public double getRadius3() {
		return radius3;
	}

	public void setRadius3(double radius3) {
		this.radius3 = radius3;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCou() {
		return cou;
	}

	public void setCou(String cou) {
		this.cou = cou;
	}

	public int getLat_ns() {
		return latns;
	}

	public void setLat_ns(int latNs) {
		latns = latNs;
	}

	public int getLat_h() {
		return lath;
	}

	public void setLat_h(int latH) {
		lath = latH;
	}

	public double getLat_mmss() {
		return latmmss;
	}

	public void setLat_mmss(double latMmss) {
		latmmss = latMmss;
	}

	public int getLong_ew() {
		return longew;
	}

	public void setLong_ew(int longEw) {
		longew = longEw;
	}

	public int getLong_h() {
		return longh;
	}

	public void setLong_h(int longH) {
		longh = longH;
	}

	public double getLong_mmss() {
		return longmmss;
	}

	public void setLong_mmss(double longMmss) {
		longmmss = longMmss;
	}

	public double getOrigin_lat() {
		return originlat;
	}

	public void setOrigin_lat(double originLat) {
		originlat = originLat;
	}

	public double getOrigin_long() {
		return originlong;
	}

	public void setOrigin_long(double originLong) {
		originlong = originLong;
	}

	public List<PuzzleSolvingGameInfo> getSeekPuzzleSolvingGameResult() {
		return seekPuzzleSolvingGameResult;
	}

	public void setSeekPuzzleSolvingGameResult(
			List<PuzzleSolvingGameInfo> seekPuzzleSolvingGameResult) {
		this.seekPuzzleSolvingGameResult = seekPuzzleSolvingGameResult;
	}

	/**
	 * Description: Find in the area of a city
	 * 
	 * @return ERROR if there are exceptions SUCCESS if all go right
	 */
	public String findByCity() {
		try {
			seekPuzzleSolvingGameResult = seekGameService.seekByArea(lat, lng,
					radius1); // call the methods in service
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("seekPuzzleSolvingGameResult",
					seekPuzzleSolvingGameResult);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}

	/**
	 * Description: Find by keyword of province/state name
	 * 
	 * @return ERROR if inputs are not complete or there are errors SUCCESS if
	 *         all go right
	 */
	public String findByProv() {
		if (prov == null) {
			return ERROR;
		}
		seekPuzzleSolvingGameResult = seekGameService.seekByProv(prov);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("seekPuzzleSolvingGameResult",
				seekPuzzleSolvingGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of country name
	 * 
	 * @return ERROR if inputs are not complete or there are errors SUCCESS if
	 *         all go right
	 */
	public String findByCou() {
		if (cou == null) {
			return ERROR;
		}
		seekPuzzleSolvingGameResult = seekGameService.seekByCou(cou);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("seekPuzzleSolvingGameResult",
				seekPuzzleSolvingGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of latitude and longitude in hh-mm-ss form
	 * 
	 * @return SUCCESS if all go right
	 */
	public String findByLatLong() {
		double lat = 0;
		double longt = 0;
		lat = (lath + ((int) latmmss) / 60 + (latmmss - ((int) latmmss)) / 3600)
				* latns;
		longt = (longh + ((int) longmmss) / 60 + (longmmss - ((int) longmmss)) / 3600)
				* longew;
		seekPuzzleSolvingGameResult = seekGameService.seekByArea(lat, longt,
				radius2);
		 ActionContext ctx = ActionContext.getContext();
		 ctx.getSession().put("seekPuzzleSolvingGameResult",
		 seekPuzzleSolvingGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of latitude and longitude in decimal form
	 * 
	 * @return SUCCESS if all go right
	 */
	public String findByOriginLatLong() {
		seekPuzzleSolvingGameResult = seekGameService.seekByArea(originlat,
				originlong, radius3);
		   ActionContext ctx = ActionContext.getContext();
		   ctx.getSession().put("seekPuzzleSolvingGameResult",
		   seekPuzzleSolvingGameResult);
		return SUCCESS;
	}

}
