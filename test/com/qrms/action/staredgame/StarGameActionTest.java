package com.qrms.action.staredgame;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IStaredGameService;
/**
 * @author ZhangZu & WangXing
 * @version 1.0
 */
public class StarGameActionTest extends TestCase {
	private IStaredGameService staredGameService;
	private MockControl sgMock;

	private StarGameAction action;

	protected void setUp() throws Exception {
		sgMock = MockControl.createNiceControl(IStaredGameService.class);
		staredGameService = (IStaredGameService) sgMock.getMock();

		action = new StarGameAction();
		action.setStaredGameService(staredGameService);
	}

	protected void tearDown() throws Exception {
		sgMock.verify();
	}

	public void testExecute() {
		sgMock.reset();
		sgMock.replay();

		assertEquals(action.execute(), "success");
	}

}
