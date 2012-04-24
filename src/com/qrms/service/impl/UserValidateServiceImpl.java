package com.qrms.service.impl;

import java.util.List;
import com.qrms.bean.User;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;
import com.qrms.dao.IUserDAO;
import com.qrms.service.IUserValidateService;

/**
 * Descroption: The implemement of the interface IUserValidateService It uses
 * DAO Objects to find and save info in the userInfo & UserNotValidatedInfo
 * 
 * @author Zhaolu & Yinshunming
 * @version 1.0
 */

public class UserValidateServiceImpl implements IUserValidateService {

	/**
	 * nvUserDAO is used to interact with the corresponding table in the
	 * database
	 */
	private IUSerNotValidatedInfoDAO nvUserDAO;

	/** userDAO is used to interact with the corresponding table in the database */
	private IUserDAO userDAO;

	public IUSerNotValidatedInfoDAO getNvUserDAO() {
		return nvUserDAO;
	}

	public void setNvUserDAO(IUSerNotValidatedInfoDAO nvUserDAO) {
		this.nvUserDAO = nvUserDAO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * description:Find the info according to the md5 code
	 * 
	 * @param md5
	 * @return UserNotValidatedInfo according to the md5 code
	 */
	public UserNotValidatedInfo find(String md5) {
		List<UserNotValidatedInfo> lt = nvUserDAO.findByEncryptkey(md5);
		if (lt == null || lt.size() == 0)
			return null;
		else
			return lt.get(0);
	}

	/**
	 * description:delete the info from the TblNotValidate table
	 * 
	 * @param nvinfo
	 */
	public void deleteFromTblNotValidate(UserNotValidatedInfo nvinfo) {
		nvUserDAO.delete(nvinfo);
	}

	/**
	 * description:save the the info to the TblUserInfo table
	 * @param user : the User bean
	 */
	public void saveToTblUserInfo(User user) {
		userDAO.saveUser(user);
	}

	public void deleteByValidateCode(String validatecode) {
		UserNotValidatedInfo unv = this.find(validatecode);
		if (unv != null) {
			this.deleteFromTblNotValidate(unv);
		}
	}
}
