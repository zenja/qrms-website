package com.qrms.dao;

import java.util.List;

import com.qrms.bean.User;

/**
 * Description: The interface of the UserDAOImpl
 * 
 * @author Wangxing & Yinshunming
 * @version 2.0
 * 
 *          Modify 1: Yinshunming & Wangxing --Some more methods added
 */

public interface IUserDAO {

	/**
	 * Description: Save the bean to the DB
	 * 
	 * @author WangXing
	 * @param user
	 *            The bean to be saved in DB
	 * */
	public void saveUser(User user);

	/**
	 * Description: Delete the bean from the DB
	 * 
	 * @author WangXing
	 * @param user
	 *            The bean to be deleted in DB
	 * */
	public void removeUser(User user);

	/**
	 * Description: Find the bean from the DB according to id
	 * 
	 * @author WangXing
	 * @param User
	 *            The bean which satisfies the condition
	 * */
	public User findUserById(Integer id);

	/**
	 * Description: Select beans according to given property
	 * 
	 * @author WangXing
	 * @param propertyName
	 *            The property's name
	 * @param value
	 *            The value of the property
	 * @return a list which satisfies the condition
	 * */
	public List<User> findByProperty(String propertyName, Object value);

	/**
	 * Description: Select beans according to loginEmail
	 * 
	 * @author WangXing
	 * @param loginEmail
	 *            The value of the loginEmail
	 * @return a list which satisfies the condition
	 * */
	public List<User> findUserByLoginEmail(String loginEmail);

	/**
	 * Description: Select beans according to given bean
	 * 
	 * @author WangXing
	 * @param user
	 *            The bean to be saved in DB
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public List findUserByExample(User user);

	/**
	 * Description: Find all beans
	 * 
	 * @author WangXing
	 * @return a list which contains all beans in the table
	 * */
	public List<User> findAllUser();

	/**
	 * Description: Update a row in table according to a specific bean
	 * 
	 * @author WangXing
	 * @param user
	 *            Update Info
	 * */
	public void updateUser(User user);

	/* Modify_1: some methods added */

	/**
	 * Description: Select beans according to password
	 * 
	 * @author WangXing
	 * @param password
	 *            The value of the password
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByPassword(Object password);

	/**
	 * Description: Select beans according to name
	 * 
	 * @author WangXing
	 * @param name
	 *            The value of the name
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByName(Object name);

	/**
	 * Description: Select beans according to nation
	 * 
	 * @author WangXing
	 * @param nation
	 *            The value of the nation
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByNation(Object nation);

	/**
	 * Description: Select beans according to province
	 * 
	 * @author WangXing
	 * @param province
	 *            The value of the province
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByProvince(Object province);

	/**
	 * Description: Select beans according to city
	 * 
	 * @author WangXing
	 * @param city
	 *            The value of the city
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByCity(Object city);

	/**
	 * Description: Select beans according to photo
	 * 
	 * @author WangXing
	 * @param photo
	 *            The value of the photo
	 * @return a list which satisfies the condition
	 * */
	@SuppressWarnings("unchecked")
	public abstract List findByPhoto(Object photo);
}
