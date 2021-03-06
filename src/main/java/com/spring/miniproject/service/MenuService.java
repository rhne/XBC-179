package com.spring.miniproject.service;

import java.util.List; 

import com.spring.miniproject.model.MenuModel;

public interface MenuService {
	public void create(MenuModel menuModel);
	public List<MenuModel> select();
	public MenuModel searchById(Long id);
	public void update(MenuModel menuModel);
	public void deactivate(MenuModel menuModel);
	public List<MenuModel> searchByLikeTitle(String title);
	public List<MenuModel> selectMenuByRole(Long idRole);
	public List<MenuModel> searchAll();
	
}
