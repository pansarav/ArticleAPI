package com.spring.article.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.article.application.model.Article;
import com.spring.article.application.service.ArticleService;

@RestController
public class ArticleControllerImpl {

	@Autowired
	private ArticleService articleService;	
	
	@GetMapping("/createArticle")
	public void createArticle(@RequestParam(name="articleTitle", required=true) String articleTitle, @RequestParam(name="articleBody", required=true) String articleBody) {
		articleService.createArticle(articleTitle, articleBody);
	}

	@GetMapping("/modifyArticle/{articleId}")
	public void modifyArticle(@PathVariable int articleId, @RequestParam(name="articleTitle", required=false) String articleTitle, @RequestParam(name="articleBody", required=false) String articleBody) {
		articleService.modifyArticle(articleId, articleTitle, articleBody);
	}

	@GetMapping("/deleteArticle/{articleId}")
	public void deleteArticle(@PathVariable int articleId) {
		articleService.deleteArticle(articleId);
	}

	@GetMapping("/loadArticle/{articleId}")
	public Article loadArticle(@PathVariable int articleId) {
		return articleService.loadArticle(articleId);
	}

	@GetMapping("/loadArticles")
	public List<Article> loadArticles(@RequestParam(name="date", required=true) String articleDate) {
		return articleService.loadArticles(articleDate);
	}
	
	@GetMapping("/loadAllArticles")
	public List<Article> loadArticles() {
		return articleService.findAll();
	}	

}
