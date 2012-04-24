package com.qrms.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qrms.bean.Admin;

/**
 * An interceptor which is to detect if visitor has logged in
 * 
 * @author Wangxing & Yinshunming
 * @version 1.0
 */
public class AdminAuthInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * It intercepts request from user and detect if visitor has logged in
	 * 
	 * @return "notLoggedIn" if he is not not logged in the website
	 *         actionInvocation.invoke() if all go right
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// get current logged in admin
		ActionContext context = actionInvocation.getInvocationContext();
		Admin currentAdmin = (Admin) (context.getSession().get("admin"));

		// check if admin is logged in
		if (currentAdmin == null) {
			System.out.println("AdminAuthInterceptor: Admin not logged in");
			return "notLoggedIn";
		} else {
			return actionInvocation.invoke();
		}
	}

}
