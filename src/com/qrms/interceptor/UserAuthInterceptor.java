package com.qrms.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qrms.bean.User;

/**
 * An interceptor which is to detect if visitor is user
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public class UserAuthInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	public final static String GOTO_URL_KEY = "GOING_TO";

	/**
	 * This method intercepts request from the user and detects if user has
	 * logged in
	 * 
	 * @return "notLoggedIn" if visitor is not logging in
	 *         actionInvocation.invoke() if all go right
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// get current logged in user
		ActionContext context = actionInvocation.getInvocationContext();
		User currentUser = (User) (context.getSession().get("user"));

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		// check if user is logged in
		if (currentUser == null) {
			System.out.println("UserAuthInterceptor: User not logged in");

			setToGoingURL(request, session, actionInvocation);
			return "notLoggedIn";

		} else {
			return actionInvocation.invoke();
		}

	}

	/**
	 * This method puts the request to the GOTO_URL_KEY, which is session.
	 * 
	 * @param request
	 * @param session
	 * @param invocation
	 */
	@SuppressWarnings("unchecked")
	private void setToGoingURL(HttpServletRequest request, HttpSession session,
			ActionInvocation invocation) {
		String url = null;

		url = request.getRequestURI() + "?";
		Map<String, String[]> zzMap = request.getParameterMap();
		if (zzMap != null) {
			for (String s : zzMap.keySet()) {
				String[] value = zzMap.get(s);
				for (String val : value) {
					url = url + s + "=" + val + "&";
				}

			}
		}

		session.setAttribute(GOTO_URL_KEY, url);

		// DEBUG
		System.out.println("url: " + url);
	}

}
