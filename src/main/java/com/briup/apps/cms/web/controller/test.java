package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.service.IBaseRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@ResponseBody
@RestController
public class test {

	/*@Resource
	private ArticleMapper articleMapper;
	@Resource
	private ArticleExtendMapper articleExtendMapper;
	@Autowired
	private IArticleService articleService;

	@RequestMapping("/test")
	public void test() {
		System.out.println("test=======");
		
		 * List<Article> list = articleMapper.selectByExample(new ArticleExample());
		 * System.out.println(list);
		 

		List<Article> articles = articleService.findAll();
		Message message = MessageUtil.success(articles);
		System.out.println(message);*/
	private static IBaseRoleService baseRoleService;

	public static void main(String[] args) {
		
	

	List<BaseRoleExtend> list = baseRoleService.cascadePrivilegeFindAll();
System.out.println(list);
	}

}
