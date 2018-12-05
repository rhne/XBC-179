package com.spring.miniproject.dao;

import java.util.List; 

import com.spring.miniproject.model.AkunModel;

public interface AkunDao {
	public void create(AkunModel akunModel);
	public List<AkunModel> searchAll();
	public AkunModel searchById(Integer id);
	public void update(AkunModel akunModel);
	List<AkunModel> searchByLikeName(String name);
	public AkunModel searchByUsernamePassword(String username, String password);
	public void deactivate(AkunModel akunModel);

}
