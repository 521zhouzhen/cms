package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.extend.BaseRoleExtend;
import com.briup.apps.cms.service.IBaseRoleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.RolePrivilegeVM;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IBaseRoleService baseRoleService;

	@ApiOperation(value = "查询所有")
	@GetMapping(value = "findAll")
	public Message findAll() {
		List<BaseRole> list = baseRoleService.findAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "查询所有", notes = "级联权限")
	@GetMapping(value = "cascadePrivilegeFindAll")
	public Message cascadePrivilegeFindAll() {
		List<BaseRoleExtend> list = baseRoleService.cascadePrivilegeFindAll();
		return MessageUtil.success(list);
	}

	@ApiOperation(value = "通过id删除")
	@GetMapping(value = "deleteById")
	public Message deleteById(long id) {
		baseRoleService.deleteById(id);
		return MessageUtil.success("删除成功");
	}

	@ApiOperation(value = "保存或更新")
	@PostMapping(value = "saveOrUpdate")
	public Message saveOrUpdate(BaseRole role) {
		baseRoleService.saveOrUpdate(role);
		return MessageUtil.success("更新成功");
	}

	@ApiOperation(value = "为角色授权")

	@PostMapping(value = "authorization")

	public Message authorization(RolePrivilegeVM rolePrivilegeVM) {
		
	
		String rolename=rolePrivilegeVM.getName();
		long roleid = baseRoleService.findIdByname(rolename);
		
		List<Long> ids = rolePrivilegeVM.getPrivileges();
	
		System.out.println(rolename);
		baseRoleService.authorization(roleid, ids);

		return MessageUtil.success("授权成功");

	}
}
