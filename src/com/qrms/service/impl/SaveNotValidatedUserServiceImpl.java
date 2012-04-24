package com.qrms.service.impl;

import java.util.List;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;
import com.qrms.service.ISaveNotValidatedUserService;

/**
 * description:This class implements the interface of the
 * ISaveNotValidatedUserService It provices the implements of the methods in the
 * interface. It mostly uses the IUserNotValidatedInfoDAO to interact with the
 * table. It can save the info into the database,judge if the loginEmail is in
 * the table tblNotValidatedInfo
 * 
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class SaveNotValidatedUserServiceImpl implements
		ISaveNotValidatedUserService {

	/** The dao to interface with the corresponding table */
	private IUSerNotValidatedInfoDAO nvUserDAO;

	public IUSerNotValidatedInfoDAO getNvUserDAO() {
		return nvUserDAO;
	}

	public void setNvUserDAO(IUSerNotValidatedInfoDAO nvUserDAO) {
		this.nvUserDAO = nvUserDAO;
	}

	/**
	 * description:use the dao to save info into the table
	 * 
	 * @param unv : the usernotvlidateinfo bean
	 */
	public void save(UserNotValidatedInfo unv) {
		nvUserDAO.save(unv);
	}

	/**
	 * description:to judge if the loginEmail is in the database.If it is,return
	 * true,else return false;
	 * 
	 * @param loginEmail
	 * @return true means there exists a same loginEmail in the database,false
	 *         means the oppsite
	 */
	public boolean isExists(String loginEmail) {
		List<UserNotValidatedInfo> lt = nvUserDAO.findByLoginEmail(loginEmail);// find
																				// in
																				// the
																				// database
		if (lt == null || lt.size() == 0) // there is no same loginEmail
			return false;
		else
			return true;
	}

}
