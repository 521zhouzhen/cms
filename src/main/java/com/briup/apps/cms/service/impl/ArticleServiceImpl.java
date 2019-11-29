package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.ArticleExample.Criteria;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;

	public List<Article> findAll() {
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public void saveOrUpdate(Article article) throws CustomerException {

		if (article.getId() != null) {
			ArticleExtend articleExtend = this.articleExtendMapper.selectById(article.getId());
			articleExtend.setTitle(article.getTitle());
			articleExtend.setCategoryId(article.getCategoryId());
			articleExtend.setContent(article.getContent());
			articleExtend.setPublishTime(new Date().getTime());
			articleExtend.setReadTimes(0l);
			articleExtend.setStatus(articleExtend.ARTICLE_UNCHECK);
			articleExtend.setThumpDown(0l);
			articleExtend.setThumpUp(0l);
			articleMapper.updateByPrimaryKey(articleExtend);

			System.out.println(article.getId());
		} else {

//	  同名异常判断
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if (list.size() > 0) {
				throw new CustomerException("文章名不能重复");
			}

			article.setAuthorId(1l);
			article.setReadTimes(new Date().getTime());
			article.setStatus(ArticleExtend.ARTICLE_UNCHECK);
			article.setThumpDown(0l);
			article.setThumpUp(0l);
			article.setReadTimes(0l);

			articleMapper.insert(article);

		}

	}

	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleExtendMapper.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id);

	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		if (article == null) {
			throw new CustomerException("该文章不存在");
		}
		articleMapper.deleteByPrimaryKey(id);

	}
}
