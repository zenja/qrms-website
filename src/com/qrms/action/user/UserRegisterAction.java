package com.qrms.action.user;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.service.ISaveNotValidatedUserService;
import com.qrms.service.IUserService;
import com.qrms.util.MD5;

/**
 * Descroption:The class controls the logic of a new user registration.
 * 
 * @author Zhaolu & Yinshunming
 * @version 1.0
 * 
 */

public class UserRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** the info of the not validated user which fetch its info form the jsp */
	private UserNotValidatedInfo nvuser;

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

	public ISaveNotValidatedUserService getNvuserService() {
		return nvuserService;
	}

	public void setNvuserService(ISaveNotValidatedUserService nvuserService) {
		this.nvuserService = nvuserService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UserNotValidatedInfo getNvuser() {
		return nvuser;
	}

	public void setNvuser(UserNotValidatedInfo nvuser) {
		this.nvuser = nvuser;
	}

	/**
	 * Description: This method first checks if the new user exists, if not send
	 * a validate link edcoded in MD5 to user's mail-box.
	 * 
	 * @return String SUCCESS if all go right ERROR if loginEmail exists
	 */
	public String execute() {
		if (userService.isUserExists(nvuser.getLoginEmail())
				|| (nvuserService.isExists(nvuser.getLoginEmail()))) {
			return ERROR; // Judge if the loginEmail is in the game.
		} else {
			MD5 md5 = MD5.getMD5Instance();
			md5.setUsername(nvuser.getLoginEmail());
			md5.setMD5();
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) ctx
					.get(ServletActionContext.HTTP_REQUEST);
			String path = request.getContextPath();
			md5.setPath(request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + path + "/");
			nvuser.setEncryptkey(md5.getMd5());
			Timestamp d = new Timestamp(System.currentTimeMillis());
			nvuser.setDate(d);
			nvuserService.save(nvuser); // devlope a md5 code and save into
										// database
			return SUCCESS;
		}
	}

}
