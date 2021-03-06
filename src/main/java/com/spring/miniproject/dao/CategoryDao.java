package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.CategoryModel;

public interface CategoryDao {
	public void create(CategoryModel categoryModel);
	public List<CategoryModel> searchAll();
	public List<CategoryModel> select();
	public List<CategoryModel> searchByLikeName(String name);
	public CategoryModel searchById(Long id);
	public void delete(CategoryModel categoryModel);
	public void update(CategoryModel categoryModel);
}
