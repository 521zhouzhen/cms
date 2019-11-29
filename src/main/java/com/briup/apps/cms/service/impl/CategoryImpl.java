package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class CategoryImpl implements ICategoryService {

	@Resource
	private CategoryMapper CategoryMapper;

	@Override
	public List<Category> findAll() {
		List<Category> categories = CategoryMapper.selectByExample(new CategoryExample());
		return categories;
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if (category.getId() != null) {
			CategoryMapper.updateByPrimaryKey(category);
		} else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = CategoryMapper.selectByExample(example);
			if (list.size() > 0) {
				throw new CustomerException("栏目不可以重名");
			}
			CategoryMapper.insert(category);
		}

	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Category category = CategoryMapper.selectByPrimaryKey(id);
		if (category == null) {
			throw new CustomerException("该栏目不存在");
		}
		CategoryMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void bathDelete(long[] ids) throws CustomerException {
		for (long id : ids) {
			this.deleteById(id);
		}

	}

}
