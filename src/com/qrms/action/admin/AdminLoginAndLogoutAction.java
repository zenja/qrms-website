package com.qrms.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.Admin;
import com.qrms.service.IAdminService;

/**
 * Description: this action maps the Admin Logining and Admin Logouting
 * functions
 * 
 * @author WangXing & YinShunming
 * @version 1.0
 */

public class AdminLoginAndLogoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IAdminService adminService;

	private Admin admin;

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * validate if the password and name are ture
	 * 
	 * @return "SUCCESS" all the above go successfully;"ERROR": Exception
	 *         occurred or there are erros in the users' inputs
	 */
	public String login() {
		if (admin == null || admin.getUsername() == null
				|| admin.getPassword() == null) {
			return ERROR;
		}

		String username = admin.getUsername();
		String password = admin.getPassword();
		if (adminService.isAdmin(username, password) == true) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession()
					.put("admin", adminService.findByUsername(username));
		} else {
			return ERROR;
		}

		return SUCCESS;
	}

	/**
	 * remove the session if admin logs out
	 * 
	 * @return SUCCESS all go successfully
	 */
	public String logout() {
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("admin");
		return SUCCESS;
	}
}
