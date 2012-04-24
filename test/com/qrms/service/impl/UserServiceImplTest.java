package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.MockControl;

import com.qrms.bean.User;
import com.qrms.dao.IUserDAO;

import junit.framework.TestCase;

/**
 * @author Wangxin & Yinshunming
 * @version 1.0
 */
public class UserServiceImplTest extends TestCase {
	MockControl control;
	IUserDAO userDao;
	UserServiceImpl us;
	List<User> list1;
	User u;

	/** set up the environment for the test */
	public void setUp() {
		u = new User();
		u.setLoginEmail("cc@123.com");
		u.setId(12);
		list1 = new ArrayList<User>();
		us = new UserServiceImpl();
		control = MockControl.createControl(IUserDAO.class);
		userDao = (IUserDAO) control.getMock();
		us.setUserDao(userDao);
		list1.add(u);
	}

	/** test IsUserExists() method in the class */
	public void testIsUserExists() {
		userDao.findUserByLoginEmail("cc@123.com");
		control.setReturnValue(list1);
		control.replay();
		assertTrue(us.isUserExists("cc@123.com"));
		control.reset();
	}

	/** test findById() metohd in the class */
	public void testFindById() {
		userDao.findUserById(12);
		control.setReturnValue(list1.get(0));
		control.replay();
		assertEquals(u, us.findById(12));
		control.reset();
	}

	/** test findAll() nethod in the class */
	public void testFindAll() {
		userDao.findAllUser();
		control.setReturnValue(list1);
		control.replay();
		assertEquals(list1, us.findAll());
		control.reset();
	}
}
