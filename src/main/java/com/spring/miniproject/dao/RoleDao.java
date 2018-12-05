package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.RoleModel;

public interface RoleDao {
	
	public void create(RoleModel roleModel);
	public List<RoleModel> select();
	public RoleModel searchById(Long id);
	public void update(RoleModel roleModel);
	public List<RoleModel> searchByLikeName(String name);
	public void deactivate(RoleModel roleModel);
}
