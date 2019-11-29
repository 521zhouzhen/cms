package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

import java.util.List;

public class ArticleExtend extends Article {
	private Category category;
	private List<Comment> comments;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static final String ARTICLE_UNCHECK = "审核中";
	public static final String ARTICLE_UNPASS = "审核不通过";
	public static final String ARTICLE_PASS = "审核通过";

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
