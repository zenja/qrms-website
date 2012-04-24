package com.qrms.service.impl;

import java.util.List;

import com.qrms.bean.User;
import com.qrms.dao.IUserDAO;
import com.qrms.service.ILoginService;

/**
 * Descroption: It uses DAO Object to find and save info in the
 * puzzleSolvingGameInfo
 * 
 * @author Zhangzu & Yinshunming
 * @version 1.0
 */

public class LoginServiceImpl implements ILoginService {
	/** the dao to interact with the user's table */
	private IUserDAO userDao;

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * checks if the user is valid to login
	 * 
	 * @param loginEmail :
	 *            the email used as login user name.
	 * @param password :
	 *            the password of the user.
	 * @return if the user is exists and the password matches the email.
	 */
	public boolean isUser(String loginEmail, String password) {
		List<User> userList = userDao.findUserByLoginEmail(loginEmail);
		if (userList != null && userList.size() > 0
				&& userList.get(0).getPassword().equals(password)) { // check
																		// the
																		// conditions
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retrieve a user instance by its login email.
	 * 
	 * @param loginEmail
	 *            the email the user used as user name.
	 * @return the user instance.
	 * @see com.qrms.service.ILoginService#findUserByLoginEmail(String).
	 */
	public User findUserByLoginEmail(String loginEmail) {
		return (User) userDao.findUserByLoginEmail(loginEmail).get(0);
	}
}
