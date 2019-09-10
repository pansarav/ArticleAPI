package com.spring.article.application.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.article.application.model.Article;
import com.spring.article.application.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	//http://localhost:8080/createArticle?articleTitle=Article4&articleBody=Article4
	@Override
	public void createArticle(String articleTitle, String articleBody) {
		articleRepository.save(prepareArticle(articleTitle, articleBody));
	}

	//http://localhost:8080/modifyArticle/1?articleTitle=ArticleModified&articleBody=ArticleBodyModified
	@Override
	public void modifyArticle(int articleId, String articleTitle, String articleBody) {
		if(articleRepository.findById(articleId).isPresent()) {
			Article article = prepareArticle(articleTitle, articleBody);
			article.setArticleId(articleId);
			articleRepository.save(article);
		}
		
	}

	//http://localhost:8080/deleteArticle/3
	@Override
	public void deleteArticle(int articleId) {
		Optional<Article> optionalArticle = articleRepository.findById(articleId);
		
		if(optionalArticle.isPresent()) {
			Article article = optionalArticle.get();
			
			Date currentDate = Calendar.getInstance().getTime();
			Date articleDate = article.getCreationTime();
			
			long diffInMillies = Math.abs(currentDate.getTime() - articleDate.getTime());
		    long dayDifference = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			if(dayDifference>=365) {
				articleRepository.deleteById(articleId);
			}
		}
	}

	//http://localhost:8080/loadArticle/1
	@Override
	public Article loadArticle(int articleId) {
		try {
			return articleRepository.findById(articleId).orElseThrow(() -> new Exception());
		} catch (Exception e) {
			System.out.print("Article Not Found");
		}
		return null;
	}

	//http://localhost:8080/loadArticles?date=10/09/2019
	@Override
	public List<Article> loadArticles(String articleDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return articleRepository.loadArticles(formatter.parse(articleDate));
		} catch (ParseException e) {
			System.out.print("Invalid date entered");
		}
		return null;
	}
	
	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}
	
	private Article prepareArticle(String articleTitle, String articleBody) {
		Article article = new Article();
		article.setArticleTitle(articleTitle);
		article.setArticleBody(articleBody);
		article.setCreationTime(Calendar.getInstance().getTime());
		return article;
	}

}
