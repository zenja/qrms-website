package com.qrms.action.inspiringgame;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.InspiringGameInfo;
import com.qrms.service.IInspiringGameService;
/**
 * Description: The class controls the logic when user searches inspitinggame
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class SeekInspiringGameAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

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

	private IInspiringGameService inspiringGameService;

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
	private List<InspiringGameInfo> seekInspiringGameResult;

	public IInspiringGameService getInspiringGameService() {
		return inspiringGameService;
	}

	public void setInspiringGameService(
			IInspiringGameService inspiringGameService) {
		this.inspiringGameService = inspiringGameService;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRadius1() {
		return radius1;
	}

	public void setRadius1(double radius1) {
		this.radius1 = radius1;
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

	public int getLatns() {
		return latns;
	}

	public void setLatns(int latns) {
		this.latns = latns;
	}

	public int getLath() {
		return lath;
	}

	public void setLath(int lath) {
		this.lath = lath;
	}

	public double getLatmmss() {
		return latmmss;
	}

	public void setLatmmss(double latmmss) {
		this.latmmss = latmmss;
	}

	public int getLongew() {
		return longew;
	}

	public void setLongew(int longew) {
		this.longew = longew;
	}

	public int getLongh() {
		return longh;
	}

	public void setLongh(int longh) {
		this.longh = longh;
	}

	public double getLongmmss() {
		return longmmss;
	}

	public void setLongmmss(double longmmss) {
		this.longmmss = longmmss;
	}

	public double getRadius2() {
		return radius2;
	}

	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}

	public double getOriginlat() {
		return originlat;
	}

	public void setOriginlat(double originlat) {
		this.originlat = originlat;
	}

	public double getOriginlong() {
		return originlong;
	}

	public void setOriginlong(double originlong) {
		this.originlong = originlong;
	}

	public double getRadius3() {
		return radius3;
	}

	public void setRadius3(double radius3) {
		this.radius3 = radius3;
	}

	public List<InspiringGameInfo> getSeekInspiringGameResult() {
		return seekInspiringGameResult;
	}

	public void setSeekInspiringGameResult(
			List<InspiringGameInfo> seekInspiringGameResult) {
		this.seekInspiringGameResult = seekInspiringGameResult;
	}

	/**
	 * Description: Find in the area of a city
	 * 
	 * @return String
	 */
	public String findByCity() {
		try {
			// Double LL[]=QueryLL.QueryCity(city);
			seekInspiringGameResult = inspiringGameService.seekByArea(lat, lng,
					radius1);
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("seekInspiringGameResult",
					seekInspiringGameResult);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}

	/**
	 * Description: Find by keyword of province/state name
	 * 
	 * @return String
	 */
	public String findByProv() {
		if (prov == null) {
			return ERROR;
		}
		seekInspiringGameResult = inspiringGameService.seekByProvince(prov);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession()
				.put("seekInspiringGameResult", seekInspiringGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of country name
	 * 
	 * @return String
	 */
	public String findByCou() {
		if (cou == null) {
			return ERROR;
		}
		seekInspiringGameResult = inspiringGameService.seekByNation(cou);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession()
				.put("seekInspiringGameResult", seekInspiringGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of latitude and longitude in hh-mm-ss form
	 * 
	 * @return String
	 */
	public String findByLatLong() {
		double lat = 0;
		double longt = 0;
		lat = (lath + ((int) latmmss) / 60 + (latmmss - ((int) latmmss)) / 3600)
				* latns;
		longt = (longh + ((int) longmmss) / 60 + (longmmss - ((int) longmmss)) / 3600)
				* longew;
		System.out.println("lat"+lat+" , "+"longt"+longt);
		seekInspiringGameResult = inspiringGameService.seekByArea(lat, longt,
				radius2);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession()
				.put("seekInspiringGameResult", seekInspiringGameResult);
		return SUCCESS;
	}

	/**
	 * Description: Find by keyword of latitude and longitude in decimal form
	 * 
	 * @return String
	 */
	public String findByOriginLatLong() {
		System.out.println("originlat"+originlat+"originlong"+originlong);
		seekInspiringGameResult = inspiringGameService.seekByArea(originlat,
				originlong, radius3);
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession()
				.put("seekInspiringGameResult", seekInspiringGameResult);
		return SUCCESS;
	}
}
