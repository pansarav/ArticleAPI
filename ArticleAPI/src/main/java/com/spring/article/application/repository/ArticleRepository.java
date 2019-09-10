package com.spring.article.application.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.article.application.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query("SELECT a FROM Article a WHERE a.creationTime=(:articleDate)")
	List<Article> loadArticles(@Param("articleDate") Date date);

}
