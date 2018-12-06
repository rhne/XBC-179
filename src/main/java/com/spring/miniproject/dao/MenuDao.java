package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.MenuModel;

public interface MenuDao {
	public void create(MenuModel menuModel);
	public List<MenuModel> select();
	public MenuModel searchById(Long id);
	List<MenuModel> searchByLikeTitle(String title);
	public void update(MenuModel menuModel);
	public void deactivate(MenuModel menuModel);
	
}
