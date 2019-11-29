package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BasePrivilegeExample;
import com.briup.apps.cms.dao.BasePrivilegeMapper;
import com.briup.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.briup.apps.cms.service.IBasePrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService {
	@Resource
	private BasePrivilegeMapper basePrivilegeMapper;
	@Resource
	private BasePrivilegeExtendMapper basePrivilegeExtendMapper;

	@Override
	public List<BasePrivilege> findAll() {
		return basePrivilegeMapper.selectByExample(new BasePrivilegeExample());
	}

	@Override
	public void saveOrUpdate(BasePrivilege privilege) throws CustomerException {
		if (privilege.getId() != null) {
			basePrivilegeMapper.updateByPrimaryKey(privilege);
		} else {
			basePrivilegeMapper.insert(privilege);
		}
	}

	@Override
	public List<BasePrivilege> findByParentId(Long parentId) {
		BasePrivilegeExample example = new BasePrivilegeExample();
		if (parentId == null) {
			example.createCriteria().andParentIdIsNull();
		} else {
			example.createCriteria().andParentIdEqualTo(parentId);
		}
		return basePrivilegeMapper.selectByExample(example);
	}

	@Override
	public List<PrivilegeTree> findPrivilegeTree() {
		return basePrivilegeExtendMapper.selectAll();
	}

	@Override
	public void deletePrivilege(long id) {
		BasePrivilegeExample example = new BasePrivilegeExample();
		example.createCriteria().andIdEqualTo(id);
		BasePrivilege basePrivilege = basePrivilegeMapper.selectByPrimaryKey(id);
		Long parentId = basePrivilege.getParentId();
		if(parentId!=null) {
			basePrivilegeMapper.deleteByPrimaryKey(id);
		}
		
		
		else {
			BasePrivilegeExample example2 = new BasePrivilegeExample();
			example2.createCriteria().andParentIdEqualTo(id);
			List<BasePrivilege> list = basePrivilegeMapper.selectByExample(example2);
			for(BasePrivilege basePrivilege2:list) {
				Long id2 = basePrivilege2.getId();
				basePrivilegeMapper.deleteByPrimaryKey(id2);
			}
			basePrivilegeMapper.deleteByPrimaryKey(id);
			
		}
		
		
	}
}
