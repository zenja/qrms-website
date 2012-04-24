package com.qrms.action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.User;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.service.IUserValidateService;

/**
 * Descroption: When user dots the link in his mailbox,this class is to validate
 * if the user is legal.
 * 
 * @author Zhaolu & Yinshunming
 * @version 1.0
 */

public class UserValidateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	/** the validcode which fetches info form the link */
	private String valicode;

	/** the service to interact with the not validated user table */
	private IUserValidateService uvs;

	public String getValicode() {
		return valicode;
	}

	public void setValicode(String valicode) {
		this.valicode = valicode;
	}

	public IUserValidateService getUvs() {
		return uvs;
	}

	public void setUvs(IUserValidateService uvs) {
		this.uvs = uvs;
	}

	/**
	 * this method is to find the info according to the valicode and send its
	 * info to the user table
	 * 
	 * @return ERROR if his/her info can't find in the database SUCCESS if all
	 *         go right
	 */
	@Override
	public String execute() {
		UserNotValidatedInfo uvinfo = uvs.find(valicode);
		if (uvinfo == null) {
			System.out.print("Validate---ERROR");
			return ERROR;
		} else {
			User user = new User(); // new a user,which info is from uvinfo.
			user.setLoginEmail(uvinfo.getLoginEmail());
			user.setName(uvinfo.getName());
			user.setPassword(uvinfo.getPassword());
			uvs.deleteFromTblNotValidate(uvinfo);
			uvs.saveToTblUserInfo(user);
			System.out.print("Validate---SUCCESS");
			return SUCCESS;
		}
	}
}
