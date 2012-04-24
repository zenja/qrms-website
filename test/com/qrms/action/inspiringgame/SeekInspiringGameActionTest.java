package com.qrms.action.inspiringgame;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.IInspiringGameService;
/**
 * @author Yinshunming & Wangxing
 * @version 1.0
 * Note : ingore ActionContent when testing.
 */
public class SeekInspiringGameActionTest extends TestCase {
	private IInspiringGameService igService;
	private MockControl igMock;

	private SeekInspiringGameAction action;

	protected void setUp() throws Exception {
		igMock = MockControl.createNiceControl(IInspiringGameService.class);
		igService = (IInspiringGameService) igMock.getMock();

		action = new SeekInspiringGameAction();
		action.setInspiringGameService(igService);
		action.setCou("test country");
		action.setCity("test city");
		action.setLng(22.111);
	}

	protected void tearDown() throws Exception {
		igMock.verify();
	}

	public void testFindByCity() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.findByCity(), "success");
	}

	public void testFindByProv() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.findByProv(), "success");
	}

	public void testFindByCou() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.findByCou(), "success");
	}

	public void testFindByLatLong() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.findByLatLong(), "success");
	}

	public void testFindByOriginLatLong() {
		igMock.reset();
		igMock.replay();
		assertEquals(action.findByOriginLatLong(), "success");
	}

}
