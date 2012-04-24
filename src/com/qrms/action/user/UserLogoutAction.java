package com.qrms.action.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Description: this class is used to manage the operations after the user click
 * "log out" and want to abort the current session. The operations mainly
 * include cleaning the cookies.
 * 
 * @author Zhangzu & Yinshunming
 * @version 2.0
 * 
 *  modify 1: Wangxing  & Yinshunming
 *  Description:
 *      1. remove cookie support; 
 *      2. clean session
 *          object: GOING_TO, to clean the out-dated url redirection after
 *          logging in
 */

public class UserLogoutAction extends ActionSupport implements
		ServletResponseAware {
	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;

	/**
	 * Execute to clear the cookies that the browser has saved, also abort the
	 * current session.
	 * 
	 * @return "success" if the session is abort successfully.
	 */
	@Override
	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("user");

		ctx.getSession().remove("GOING_TO");

		deleteTempCookie();
		return SUCCESS;
	}

	/**
	 * delte the cookie of this user
	 */
	private void deleteTempCookie() {
		Cookie cookie = new Cookie("user", "");
		cookie.setMaxAge(0); // delete the cookie.
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
