package com.qrms.service;

import java.util.List;
import com.qrms.bean.User;

/**
 * Description: The interface for UserService
 * 
 * @author Wangxing & Zhangzu
 * @version 1.0
 * @date July 12 2010
 */
public interface IUserService {

	/**
	 * Description: Find all User beans in DB
	 * 
	 * @return List<User> All User beans
	 */
	public List<User> findAll();

	/**
	 * Description: Save the User bean to DB
	 * 
	 * @param user
	 *            The bean to be saved
	 */
	public void saveUser(User user);

	/**
	 * Description: Delete the specified User bean from the DB
	 * 
	 * @param user
	 *            The bean to be deleted
	 */
	public void delete(User user);

	/**
	 * Description: Find the User bean with the given id
	 * 
	 * @param id
	 *            User id
	 * @return User bean with the given id
	 */
	public User findById(Integer id);

	/**
	 * Description: Update User bean
	 * 
	 * @param user
	 *            The bean to be updated
	 */
	public void update(User user);

	/**
	 * Description: Judge whether the user exists according to given loginEmail
	 * 
	 * @param loginEmail
	 *            User's loginEmail
	 * @return true The user do exists
	 * @return false The user does not exist
	 */
	public boolean isUserExists(String loginEmail);
}