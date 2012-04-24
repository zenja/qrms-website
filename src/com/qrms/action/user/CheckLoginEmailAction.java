package com.qrms.action.user;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.ISaveNotValidatedUserService;
import com.qrms.service.IUserService;

/**
 * Description:new added action, which is to support the instance check when
 * user registers
 * 
 * @author YinShunMing & ZhaoLu
 * @version 1.0
 */
public class CheckLoginEmailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String exist;
	/**
	 * the service of the user,it provides some methods to interfact with the
	 * corresponding in the database
	 */
	private IUserService userService;

	/**
	 * the service of the not validateduser,it provides some methods to
	 * interfact with the corresponding table in the database
	 */
	private ISaveNotValidatedUserService nvuserService;

	// use JSON annotations to indicate this variable doesn't need to
	// serialization
	@JSON(serialize = false)
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@JSON(serialize = false)
	public ISaveNotValidatedUserService getNvuserService() {
		return nvuserService;
	}

	public void setNvuserService(ISaveNotValidatedUserService nvuserService) {
		this.nvuserService = nvuserService;
	}

	@JSON(serialize = false)
	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	private String loginEmail;

	/**
	 * @return
	 * @throws Exception
	 */
	public String Exists() throws Exception {
		if (userService.isUserExists(getLoginEmail())
				|| (nvuserService.isExists(getLoginEmail()))) {
			exist = "yes";
			return SUCCESS;
		} else {
			exist = "no";
			return SUCCESS;
		}
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public String getExist() {
		return exist;
	}
}
