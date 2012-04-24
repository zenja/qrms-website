package com.qrms.action.mobile;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.service.ILoginService;

/**
 * Description: this class is used to manage the operations after the user input
 * the login information and try to login. These operations include checking if
 * the user can login successfully and save cookie on the browser if the user
 * choose to.
 * 
 * @author zhaoLu & YinShunming
 * @version 1.0 20 July 2010
 * 
 */
public class MobileLoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** the map array type return value */
	private ArrayList<Map<String, Object>> mapArrayResult;

	/** The service used to manage operations about user's login */
	private ILoginService uls;

	/** The user entity */
	private User user;

	public void setMapArrayResult(ArrayList<Map<String, Object>> mapArrayResult) {
		this.mapArrayResult = mapArrayResult;
	}

	public ArrayList<Map<String, Object>> getMapArrayResult() {
		return mapArrayResult;
	}

	public ILoginService getUls() {
		return uls;
	}

	public void setUls(ILoginService uls) {
		this.uls = uls;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Checks if the user can login the system successfully. The user can login
	 * only when the user has been registered and the user name and the password
	 * match. The cookie may be saved if the user choose to "remember" himself.
	 * 
	 * @return "success" if the user is valid and can login. "error" if the user
	 *         name hasn't been registered yet or the user name and the password
	 *         do not match.
	 */

	public String execute() {
		String email = null;
		String pass = null;
		if (user != null) {
			email = user.getLoginEmail();
			pass = user.getPassword();

		}
		if (email != null && pass != null) {
			if (uls.isUser(email, pass)) {
				User loggedUser = uls.findUserByLoginEmail(email);
				mapArrayResult = new ArrayList<Map<String, Object>>();
				TreeMap<String, Object> map = new TreeMap<String, Object>();
				map.put("id", loggedUser.getId());
				map.put("name", loggedUser.getName());
				mapArrayResult.add(map);
				return "mapArrayResult";
			}
		}
		return null;
	}
}
