package com.qrms.action.user;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IUserValidateService;
/**
 * @author Zhaolu & Yinshunming
 * @version 2.0 
 * modify 1:Yinshunming & Zhaolu
 */
public class SendMailActionTest extends TestCase {
	private IUserValidateService validateService;
	private MockControl vsMock;

	private SendMailAction action;

	protected void setUp() throws Exception {
		vsMock = MockControl.createNiceControl(IUserValidateService.class);

		validateService = (IUserValidateService) vsMock.getMock();

		action = new SendMailAction();
		action.setUvs(validateService);

	}

	public void testExecute() {
		vsMock.reset();
		vsMock.replay();

		// assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
