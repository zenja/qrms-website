package com.qrms.action.news;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.qrms.bean.News;
import com.qrms.service.INewsService;

/**
 * Description:This class is used to send news to pages
 * @author YinShunMing @ WangXin
 * @version  1.0
 */
public class RetrieveNewsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static final int MAX_NEWS_NUM = 5;

	private INewsService newsService;

	private List<News> latestNewsList;

	private List<News> allNewsList;

	/** passed by user to retrieve theSingleNews */
	private Integer id;

	private News theSingleNews;

	@JSON(serialize = false)
	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getLatestNewsList() {
		return latestNewsList;
	}

	public void setLatestNewsList(List<News> latestNewsList) {
		this.latestNewsList = latestNewsList;
	}

	public List<News> getAllNewsList() {
		return allNewsList;
	}

	public void setAllNewsList(List<News> allNewsList) {
		this.allNewsList = allNewsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public News getTheSingleNews() {
		return theSingleNews;
	}

	public void setTheSingleNews(News theSingleNews) {
		this.theSingleNews = theSingleNews;
	}

	/**
	 * This function uses service to fetch lastest news from database. The
	 * number is decided by the variable MAX_NEWS_NUM
	 * 
	 * @return SUCCESS if all go right
	 */
	public String retrieveLatestNews() {
		List<News> allNewsList = newsService.getAllNews();

		latestNewsList = new ArrayList<News>();

		int itemNum = allNewsList.size() < MAX_NEWS_NUM ? allNewsList.size()
				: MAX_NEWS_NUM;

		for (int i = 0; i < itemNum; i++) {
			latestNewsList.add(allNewsList.get(i));
		}

		return SUCCESS;
	}

	public String retrieveAllNews() {
		allNewsList = newsService.getAllNews();
		return SUCCESS;
	}

	public String retrieveSingleNews() {
		if (id == null) {
			return INPUT;
		}

		theSingleNews = newsService.findById(id);

		return SUCCESS;
	}
}
