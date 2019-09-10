package com.spring.article.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Article {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	
	@Column
	private String articleTitle;
	
	@Column
	private String articleBody;
	
	@Column
	private Date creationTime;
	
	public Article() {}
	
	public Article(String articleTitle, String articleBody, Date creationTime) {
		super();
		this.articleTitle = articleTitle;
		this.articleBody = articleBody;
		this.creationTime = creationTime;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	public Date getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(Date date) {
		this.creationTime = date;
	}
	
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", article=" + articleBody + ", creationTime=" + creationTime + "]";
	}
	
	

}
