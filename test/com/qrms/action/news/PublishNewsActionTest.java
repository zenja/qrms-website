package com.qrms.action.news;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.service.INewsService;
/**
 * @author YinShunMing & WangXing
 * @version 1.0
 */
public class PublishNewsActionTest extends TestCase {
	private INewsService newsService;
	private MockControl nsMock;
	private PublishNewsAction action;

	protected void setUp() throws Exception {
		nsMock = MockControl.createNiceControl(INewsService.class);
		newsService = (INewsService) nsMock.getMock();
	}

	public void testExecute() {
		nsMock.reset();
		nsMock.replay();

		action = new PublishNewsAction();
		action.setNewsService(newsService);
		action.setContent("test content");
		action.setTitle("test title");
		assertEquals(action.execute(), "success");
	}

	protected void tearDown() throws Exception {
		nsMock.verify();
	}

}
