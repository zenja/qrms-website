package com.qrms.action.mobile;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.Strongholds;
import com.qrms.service.mobile.IAchievementService;
import com.qrms.service.mobile.IGetCityBattleEventService;

/**
 * Description: this action maps the defend function
 * 
 * @author ZhaoLu & ZhangZu
 * @version 1.0
 */
public class DefendAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	String qrInfo;

	String id;

	String name;

	String latitude;

	String longitude;

	String city;

	String province;

	String nation;

	String creatorId;

	String date;

	String strResult;

	IGetCityBattleEventService getcbes;

	IAchievementService as;

	public String getStrResult() {
		return strResult;
	}

	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}

	public String getQrInfo() {
		return qrInfo;
	}

	public void setQrInfo(String qrInfo) {
		this.qrInfo = qrInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IGetCityBattleEventService getGetcbes() {
		return getcbes;
	}

	public void setGetcbes(IGetCityBattleEventService getcbes) {
		this.getcbes = getcbes;
	}

	public IAchievementService getAs() {
		return as;
	}

	public void setAs(IAchievementService as) {
		this.as = as;
	}

	/**
	 * 1,add a new stronghold to the strognholds table 2,add achievement to the
	 * user 3,add an set up event to the battleevent table
	 * 
	 * @return "SUCCESS" all the above finished successfully;"ERROR": Exception
	 *         occurred
	 */
	public String execute() {
		Strongholds stronghold = new Strongholds();
		stronghold.setCity(city);
		stronghold.setLatitude(Double.parseDouble(latitude));
		stronghold.setLongitude(Double.parseDouble(longitude));
		stronghold.setName(name);
		stronghold.setNation(nation);
		stronghold.setProvince(province);
		stronghold.setQrinfo(qrInfo);
		stronghold.setSetby(Integer.parseInt(id));
		stronghold.setOwnerid(Integer.parseInt(id));
		stronghold.setHealth(10);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Timestamp ts = Timestamp.valueOf(date);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		stronghold.setSetdate(ts);
		try {
			getcbes.getStrongholdDao().save(stronghold);
			// List<Strongholds> list =
			// getcbes.getStrongholdDao().findByExample(stronghold);
			int strongholdId = stronghold.getId();
			getcbes.addSetupEvent(Integer.parseInt(id), strongholdId, ts);
			as.defendAchievement(Integer.parseInt(id));
			strResult = "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			strResult = "ERROR";
		}
		return "strResult";
	}
}
