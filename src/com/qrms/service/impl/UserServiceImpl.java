package com.qrms.service.impl;

import java.util.List;
import com.qrms.bean.User;
import com.qrms.dao.IUserDAO;
import com.qrms.service.IUserService;

/**
 * Descroption: The implemement of the interface It uses DAO Object to find and
 * save info in the PuzzleSolvingGameInfo
 * 
 * @author Wangxin & Yinshunming
 * @version 1.0
 */
public class UserServiceImpl implements IUserService {

	private IUserDAO userDao;

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public void delete(User user) {
		this.userDao.removeUser(user);
	}

	public List<User> findAll() {
		return this.userDao.findAllUser();
	}

	public User findById(Integer id) {
		return this.userDao.findUserById(id);
	}

	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

	public void update(User user) {
		this.userDao.updateUser(user);
	}

	/**
	 * judge if the user has exists
	 * 
	 * @param  loginEmail: the loginEmail to check
	 * @return ture if the loginEmail exists false if not exists
	 */
	public boolean isUserExists(String loginEmail) {
		List<User> lt = this.userDao.findUserByLoginEmail(loginEmail);
		if (lt == null || lt.size() == 0) // not found, the loginEmail doesn't
											// exist
			return false;
		else
			return true;
	}

}
