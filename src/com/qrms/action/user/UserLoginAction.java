package com.qrms.action.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.service.ILoginService;

/**
 * Description: this class is used to manage the operations after the user input
 * the login information and try to login. These operations include checking if
 * the user can login successfully and save cookie on the browser if the user
 * choose to.
 * 
 * @author Yinshunming & Zhangzu
 * @version 2.0
 * 
 * modify 1 Wangxing & Yinshunming
 * Description:remember me function deleted
 * 
 */
public class UserLoginAction extends ActionSupport implements
		ServletResponseAware {
	private static final long serialVersionUID = 1L;

	/** The service used to manage operations about user's login */
	private ILoginService uls;

	/** The user entity */
	private User user;

	/**
	 * The previous page that the user browsers before he/she login. It is not a
	 * full path. It's like "user/my-profile.jsp" It is passed by login.jsp.
	 */
	private String previousPageURL;

	/**
	 * The previous page that the user browsers before he/she login. It is a
	 * "full"(actually, half full) path. It's like
	 * "/my_qrms/inspiring_mode/XXX.jsp"; It is passed by loggedState.jsp
	 */
	private String previousPageFullURL;

	private HttpServletResponse response;

	public String getPreviousPageURL() {
		return previousPageURL;
	}

	public void setPreviousPageURL(String previousPageURL) {
		this.previousPageURL = previousPageURL;
	}

	public String getPreviousPageFullURL() {
		return previousPageFullURL;
	}

	public void setPreviousPageFullURL(String previousPageFullURL) {
		this.previousPageFullURL = previousPageFullURL;
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
		String email = user.getLoginEmail();
		String pass = user.getPassword();
		if (uls.isUser(email, pass)) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("user", uls.findUserByLoginEmail(email));
			saveTempCookie();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * save the cookie
	 */

	private void saveTempCookie() {
		Cookie c = new Cookie("user", user.getLoginEmail());
		System.out.println(user.getLoginEmail());
		c.setMaxAge(-1);
		c.setPath("/");
		response.addCookie(c);
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
