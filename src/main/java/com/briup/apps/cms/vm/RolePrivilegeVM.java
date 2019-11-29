package com.briup.apps.cms.vm;

import java.util.List;

public class RolePrivilegeVM {

	
	
private long id;
	
	
	private String name;
	private List<Long> privileges;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrivileges(List<Long> privileges) {
		this.privileges = privileges;
	}
	public List<Long> getPrivileges() {
		return privileges;
	}
	

}
