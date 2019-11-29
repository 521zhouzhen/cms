package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.service.impl.CategoryImpl;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("栏目相关接口")
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryservice;

	@GetMapping("findAll")
	@ApiOperation("查询所有栏目")
	public Message findAll() {
		List<Category> list = categoryservice.findAll();
		Message message = MessageUtil.success(list);
		return message;
	}

	@GetMapping("deleteById")
	@ApiOperation("删除栏目")
	public Message deleteById(Long id) {
		categoryservice.deleteById(id);
		Message message = MessageUtil.success("删除成功");
		return message;
	}

	@PostMapping("batchDelete")
	@ApiOperation("批量删除")
	public Message batchDelete(@RequestBody long[] ids) {
		categoryservice.bathDelete(ids);
		Message message = MessageUtil.success("批量删除成功");
		return message;

	}

	@PostMapping("saveOrUpdate")
	@ApiOperation("栏目添加或更新")
	public Message saveOrUpdate(Category category) {
		categoryservice.saveOrUpdate(category);
		Message message = MessageUtil.success("栏目添加或更新成功");
		return message;
	}

}
