package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.Admin;
import com.qrms.dao.IAdminDAO;
/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class AdminServiceImplTest extends TestCase {

	private MockControl control;
	private IAdminDAO mock;
	private AdminServiceImpl service;

	protected void setUp() throws Exception {
		super.setUp();
		Admin admin = new Admin();
		admin.setUsername("test");
		admin.setPassword("test");
		List<Admin> list = new ArrayList<Admin>();
		list.add(admin);

		service = new AdminServiceImpl();

		control = MockControl.createControl(IAdminDAO.class);
		mock = (IAdminDAO) control.getMock();
		service.setAdminDAO(mock);

		mock.findByUsername("test");
		control.setReturnValue(list, 2);
		control.replay();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		control.verify();
		control.reset();
	}

	public void testIsAdmin() {
		assertTrue(service.isAdmin("test", "test"));
		assertFalse(service.isAdmin("test", "123"));
	}

	public void testFindByUsername() {
		assertNotNull(service.findByUsername("test"));
		assertEquals(service.findByUsername("test").getPassword(), "test");
	}

}
