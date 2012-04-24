package com.qrms.service;

import java.util.List;

import com.qrms.bean.News;

/**
 * Description:This is interface for newsService It provides some methods to add
 * or delete the news
 * 
 * @author Wangxing & Zhaolu
 * @version 1.0
 */
public interface INewsService {
	public void addNews(String title, String content);

	public void deleteNews(Integer id);

	public List<News> getAllNews();

	public News findById(Integer theSingleNewsId);
}
