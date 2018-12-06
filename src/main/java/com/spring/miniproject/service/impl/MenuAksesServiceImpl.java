package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.MenuAksesDao;
import com.spring.miniproject.model.MenuAksesModel;
import com.spring.miniproject.service.MenuAksesService;

@Service
@Transactional
public class MenuAksesServiceImpl implements MenuAksesService{
	
	@Autowired
	private MenuAksesDao menuAksesDao;

	public void create(MenuAksesModel menuAksesModel) {
		// TODO Auto-generated method stub
		this.menuAksesDao.create(menuAksesModel);
	}

	public List<MenuAksesModel> searchAll() {
		// TODO Auto-generated method stub
		return this.menuAksesDao.searchAll();
	}

	@Override
	public MenuAksesModel searchById(Long id) {
		// TODO Auto-generated method stub
		return this.menuAksesDao.searchById(id);
	}

	@Override
	public List<MenuAksesModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.menuAksesDao.searchByLikeName(name);
	}

	@Override
	public void delete(MenuAksesModel menuAksesModel) {
		// TODO Auto-generated method stub
		this.menuAksesDao.delete(menuAksesModel);
	}
}
