package com.qrms.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.qrms.bean.News;
import com.qrms.dao.INewsDAO;
import com.qrms.service.INewsService;

/**
 * Description: This class provides services related to operations on news
 * 
 * @author Yinshunming & Wangxing
 * @version 1.0
 */
public class NewsServiceImpl implements INewsService {

	/** the dao to operate these operations */
	private INewsDAO newsDAO;

	public INewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(INewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	/**
	 * This method saves the news
	 * 
	 * @param  title : title of the news
	 * @param  content : content of the news
	 */
	public void addNews(String title, String content) {
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		news.setDate(new Timestamp(System.currentTimeMillis()));

		newsDAO.save(news);
	}

	/**
	 * This method deletes the news
	 * 
	 * @param id : id of the news
	 */
	public void deleteNews(Integer id) {
		News news = new News();
		news.setId(id);
		newsDAO.delete(news);
	}

	@SuppressWarnings("unchecked")
	public List<News> getAllNews() {
		return newsDAO.findAll();
	}

	public News findById(Integer theSingleNewsId) {
		return newsDAO.findById(theSingleNewsId);
	}

}
