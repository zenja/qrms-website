package com.qrms.service;

import com.qrms.bean.User;

/**
 * Description:The interface that manage the user's login operations.
 * 
 * @author Zhangzu & Yinshunming
 * @version 1.0
 */

public interface ILoginService {

	/**
	 * checks if the user is valid to login
	 * 
	 * @param loginEmail
	 *            the email used as login user name.
	 * @param password
	 *            the password of the user.
	 * @return if the user is exists and the password matches the email.
	 */
	public boolean isUser(String loginEmail, String password);

	/**
	 * Retrieve a user instance by its login email.
	 * 
	 * @param loginEmail
	 *            the email the user used as user name.
	 * @return the user instance.
	 */
	public User findUserByLoginEmail(String loginEmail);
}
