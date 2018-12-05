package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.CategoryDao;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.service.CategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void create(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		this.categoryDao.create(categoryModel);
	}
	
	public List<CategoryModel> searchAll() {
		// TODO Auto-generated method stub
		return this.categoryDao.searchAll();
	}

	@Override
	public List<CategoryModel> select() {
		// TODO Auto-generated method stub
		return this.categoryDao.select();
	}
	
	@Override
	public List<CategoryModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.categoryDao.searchByLikeName(name);
	}

}
