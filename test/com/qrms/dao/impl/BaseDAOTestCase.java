package com.qrms.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class BaseDAOTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "file:WebRoot/WEB-INF/applicationContext.xml" };
	}

	protected void flushSession() {
		SessionFactory sessionFactory = (SessionFactory) applicationContext
				.getBean("sessionFactory");
		sessionFactory.getCurrentSession().flush();
	}

}
