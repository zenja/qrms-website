package com.qrms.service;

import com.qrms.bean.UserNotValidatedInfo;

/**
 * Descroption:The interface of the SaveNotValidatedUserService. It provides
 * essential outside interface to the action class.
 * 
 * @author Zhao Lu & Yin Shun Ming
 * @version 1.0
 */

public interface ISaveNotValidatedUserService {

	/**
	 * description:save the info of the not valideted user to the database
	 * 
	 * @param unv
	 */
	public void save(UserNotValidatedInfo unv);

	/**
	 * description:to judge if the loginEmail is in the database.If it is,return
	 * true,else return false;
	 * 
	 * @param loginEmail
	 * @return true means there exists a same loginEmail in the database,false
	 *         means the oppsite
	 */
	public boolean isExists(String loginEmail);

}
