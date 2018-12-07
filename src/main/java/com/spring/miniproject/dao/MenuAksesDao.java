package com.spring.miniproject.dao;

import java.util.List;  

import com.spring.miniproject.model.MenuAksesModel;

public interface MenuAksesDao {
	public void create(MenuAksesModel menuAksesModel);
	public List<MenuAksesModel> searchAll();
	public MenuAksesModel searchById(Long id);
	public List<MenuAksesModel> searchByLikeName(String name);
	
	public void delete(MenuAksesModel menuAksesModel);
}
