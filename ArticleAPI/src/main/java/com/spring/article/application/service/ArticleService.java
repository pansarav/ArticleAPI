package com.spring.article.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.article.application.model.Article;

@Service
public interface ArticleService {
	
	public void createArticle(String articleTitle, String articleBody);
	
	public void modifyArticle(int articleId, String articleTitle, String articleBody);
	
	public void deleteArticle(int articleId);
	
	public Article loadArticle(int articleId);
	
	public List<Article> loadArticles(String articleDate);

	public List<Article> findAll();

}
