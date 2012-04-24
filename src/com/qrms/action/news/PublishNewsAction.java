package com.qrms.action.news;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.service.INewsService;

/**
 * Description: This is action when admins publish news
 * 
 * @author YinShunMing & WangXing
 * @version 1.0
 */
public class PublishNewsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/** Service to store the news infos */
	private INewsService newsService;

	private String title;

	private String content;

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 1,check if infos are complete 2,save the news
	 * 
	 * @return INPUT if inputs are not correct or not complete
	 */
	@Override
	public String execute() {
		if (title == null || title.trim().equals("")) {
			return INPUT;
		}

		if (content == null || content.trim().equals("")) {
			return INPUT;
		}

		newsService.addNews(title, content);

		return SUCCESS;
	}

}
