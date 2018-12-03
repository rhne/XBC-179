package com.spring.miniproject.dao;

import java.util.List; 

import com.spring.miniproject.model.RoleModel;

public interface RoleDao {
	
	public void create(RoleModel roleModel);
	public List<RoleModel> select();
	public RoleModel searchById(Integer id);
	public void delete(RoleModel roleModel);
	public void update(RoleModel roleModel);
}
