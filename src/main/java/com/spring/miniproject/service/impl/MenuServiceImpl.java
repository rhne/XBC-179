package com.spring.miniproject.service.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.MenuDao;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public void create(MenuModel menuModel) {
		// TODO Auto-generated method stub
		this.menuDao.create(menuModel);
	}

	@Override
	public List<MenuModel> select() {
		// TODO Auto-generated method stub
		return this.menuDao.select();
	}

	@Override
	public MenuModel searchById(Integer id) {
		// TODO Auto-generated method stub
		return menuDao.searchById(id);
	}

	@Override
	public void update(MenuModel menuModel) {
		// TODO Auto-generated method stub
		this.menuDao.update(menuModel);
	}
	
	@Override
	public List<MenuModel> searchByRole(Long idRole) {
		// TODO Auto-generated method stub
		return this.menuDao.searchByRole(idRole);
	}
}
