package com.spring.miniproject.service;

import java.util.List; 

import com.spring.miniproject.model.RoleModel;

public interface RoleService {
	
	public void create(RoleModel roleModel);
	public List<RoleModel> select();
	public RoleModel searchById(Long id);
	public void update(RoleModel roleModel);
	public List<RoleModel> searchByLikeName(String name);
	public void deactivate(RoleModel roleModel);
}
