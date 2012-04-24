package com.qrms.action.news;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.easymock.MockControl;

import com.qrms.bean.News;
import com.qrms.service.INewsService;

/**
 * @author YinShunMing @ WangXin
 * @version  1.0
 */
public class RetrieveNewsActionTest extends TestCase {
	private INewsService newsService;
	private MockControl nsMock;

	private Integer id = 5;
	private RetrieveNewsAction action;

	protected void setUp() throws Exception {
		nsMock = MockControl.createControl(INewsService.class);
		newsService = (INewsService) nsMock.getMock();

		action = new RetrieveNewsAction();
		action.setNewsService(newsService);
		action.setId(id);
	}

	protected void tearDown() throws Exception {
		nsMock.verify();
	}

	public void testRetrieveLatestNews() throws Exception {
		nsMock.reset();
		nsMock.expectAndReturn(newsService.getAllNews(), new ArrayList<News>());
		nsMock.replay();

		assertEquals(action.retrieveLatestNews(), "success");
	}

	public void testRetrieveAllNews() throws Exception {
		nsMock.reset();
		nsMock.expectAndReturn(newsService.getAllNews(), new ArrayList<News>());
		nsMock.replay();

		assertEquals(action.retrieveAllNews(), "success");
	}

	public void testRetrieveSingleNews() throws Exception {
		nsMock.reset();
		nsMock.expectAndReturn(newsService.findById(id), new News());
		nsMock.replay();

		assertEquals(action.retrieveSingleNews(), "success");
	}

}
