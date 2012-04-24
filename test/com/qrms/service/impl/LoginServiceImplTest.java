package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.MockControl;

import com.qrms.bean.User;
import com.qrms.dao.IUserDAO;

import junit.framework.TestCase;

/**
 * @author Zhangzu & Yinshunming
 * @version 1.0
 */

public class LoginServiceImplTest extends TestCase {
	MockControl control;
	IUserDAO userDAO;
	LoginServiceImpl ls;
	List<User> userList;
	List<User> userList1;
	User user;

	public void setUp() {
		ls = new LoginServiceImpl();
		user = new User();
		userList1 = new ArrayList<User>();
		userList = new ArrayList<User>();
		user.setLoginEmail("cc@126.com");
		user.setPassword("123");
		userList.add(user);
		ls = new LoginServiceImpl();
		control = MockControl.createControl(IUserDAO.class);
		userDAO = (IUserDAO) control.getMock();
		userDAO.findUserByLoginEmail("cc@126.com");
		control.setReturnValue(userList, 2);
		userDAO.findUserByLoginEmail("cc123@126.com");
		control.setReturnValue(userList1);
		control.replay();
		ls.setUserDao(userDAO);
	}

	public void tearDown() {
		control.reset();
	}

	public void testFindUserByLoginEmail() {
		assertEquals(ls.findUserByLoginEmail("cc@126.com"), user);
	}

	public void testIsUser() {
		assertTrue(ls.isUser("cc@126.com", "123"));
		assertFalse(ls.isUser("cc123@126.com", "123"));
		assertFalse(ls.isUser("cc@126.com", "1234"));
	}
}
