package com.qrms.service;

import com.qrms.bean.User;
import com.qrms.bean.UserNotValidatedInfo;

/**
 * Description:This class is interface for UserValidateService It provices some
 * methods for the action class who calls this service
 * 
 * @author Zhao Lu & Yin Shun Ming
 * @version 2.0
 * 
 *          modify 1 :Yin Shun Ming description:add a new method calling
 *          deleteByValidateCode,it is used to mend a bug. It can delete from
 *          the table by validatecode.
 */
public interface IUserValidateService {

	/**
	 * description:Find the info according to the md5 code
	 * 
	 * @param md5
	 * @return UserNotValidatedInfo according to the md5 code
	 */
	public UserNotValidatedInfo find(String md5);

	/**
	 * description:save the the info to the TblUserInfo table
	 * 
	 * @param user
	 */
	public void saveToTblUserInfo(User user);

	/**
	 * description:delete the info from the TblNotValidate table
	 * 
	 * @param nvinfo
	 */
	public void deleteFromTblNotValidate(UserNotValidatedInfo nvinfo);

	/**
	 * description:delete the info from the TblNotValidate table by validate
	 * code
	 * 
	 * @param nvinfo
	 */
	public void deleteByValidateCode(String validate);
}
