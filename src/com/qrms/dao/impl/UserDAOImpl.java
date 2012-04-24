package com.qrms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qrms.bean.User;
import com.qrms.dao.IUserDAO;

/**
 * Description: The UserDAO to interact with the database
 * 
 * @author WangXing
 * @version 2.0
 * @date July 11 2010
 * 
 *       Modify_1: --Date: Aug 6 2010 --Some more methods added
 *       --Author:WangXing
 */

public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	// property constants
	public static final String LOGIN_EMAIL = "loginEmail";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String NATION = "nation";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String PS_LAUNCHED_NUM = "psLaunchedNum";
	public static final String PS_FOUND_NUM = "psFoundNum";
	public static final String PHOTO = "photo";

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		String hql = "from User user order by user.id desc";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}

	public User findUserById(Integer id) {
		User user = (User) this.getHibernateTemplate().get(User.class, id);

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return (List<User>) getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<User> findUserByLoginEmail(String loginEmail) {
		return findByProperty("loginEmail", loginEmail);
	}

	@SuppressWarnings("unchecked")
	public List findUserByExample(User user) {
		try {
			List results = getHibernateTemplate().findByExample(user);
			return results;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void removeUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	/* Modify_1: some methods added */

	@SuppressWarnings("unchecked")
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@SuppressWarnings("unchecked")
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	@SuppressWarnings("unchecked")
	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	@SuppressWarnings("unchecked")
	public List findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	@SuppressWarnings("unchecked")
	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	@SuppressWarnings("unchecked")
	public List findByPsLaunchedNum(Object psLaunchedNum) {
		return findByProperty(PS_LAUNCHED_NUM, psLaunchedNum);
	}

	@SuppressWarnings("unchecked")
	public List findByPsFoundNum(Object psFoundNum) {
		return findByProperty(PS_FOUND_NUM, psFoundNum);
	}

	@SuppressWarnings("unchecked")
	public List findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

}
