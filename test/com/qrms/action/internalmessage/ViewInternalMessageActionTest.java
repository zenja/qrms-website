package com.qrms.action.internalmessage;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IInternalMessageService;

/** 
 * @author Yinshunming & Zhangzu
 * @version 1.0
 */
public class ViewInternalMessageActionTest extends TestCase {
	private IInternalMessageService internalMessageService;
	private MockControl imMock;
	private ViewInternalMessageAction action;
	private Integer internalMessageId = 1;

	protected void setUp() throws Exception {
		imMock = MockControl.createNiceControl(IInternalMessageService.class);
		internalMessageService = (IInternalMessageService) imMock.getMock();

		action = new ViewInternalMessageAction();
		action.setInternalMessageService(internalMessageService);
		action.setInternalMessageId(internalMessageId);
	}

	public void testExecute() throws Exception {
		imMock.reset();
		imMock.replay();

		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		imMock.verify();
	}

}
