package com.qrms.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.easymock.MockControl;
import com.qrms.bean.UserNotValidatedInfo;
import com.qrms.dao.IUSerNotValidatedInfoDAO;
import junit.framework.TestCase;

/**
 * @author Yinshunming & Zhaolu
 * @version 1.0
 */
public class SaveNotValidatedUserServiceImplTest extends TestCase {
	private MockControl control;
	private IUSerNotValidatedInfoDAO nvUserDAO;
	List<UserNotValidatedInfo> lt;
	List<UserNotValidatedInfo> lt1;
	UserNotValidatedInfo unv;
	SaveNotValidatedUserServiceImpl suus;

	/** set up the environment for the test */
	public void setUp() {
		unv = new UserNotValidatedInfo();
		suus = new SaveNotValidatedUserServiceImpl();
		lt1 = new ArrayList<UserNotValidatedInfo>();
		lt = new ArrayList<UserNotValidatedInfo>();
		unv.setLoginEmail("cc@189.com");
		lt.add(unv);
		control = MockControl.createControl(IUSerNotValidatedInfoDAO.class);
		nvUserDAO = (IUSerNotValidatedInfoDAO) control.getMock();
		nvUserDAO.findByLoginEmail("cc@189.com");
		control.setReturnValue(lt);
		nvUserDAO.findByLoginEmail("ccc@123.com");
		control.setReturnValue(lt1);
		control.replay();
	}

	/** destroy the environment */
	public void tearDown() {
		control.reset();
	}

	/** test the IsExists() method in the class */
	public void testIsExists() {
		suus.setNvUserDAO(nvUserDAO);
		assertTrue(suus.isExists("cc@189.com"));
		assertFalse(suus.isExists("ccc@123.com"));
	}
}
