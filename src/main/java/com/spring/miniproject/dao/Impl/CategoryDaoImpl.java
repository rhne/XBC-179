package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.CategoryDao;
import com.spring.miniproject.model.CategoryModel;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<CategoryModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = session.createQuery(" from CategoryModel where isActive =1 ").list();
		return categoryModelList;
	}

	@Override
	public void create(CategoryModel categoryModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(categoryModel);
	}

	@Override
	public List<CategoryModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select c from CategoryModel c where c.isActive=1";
		
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = session.createQuery(query).list();
		
		return categoryModelList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from CategoryModel a "
					 + " where a.code like '%"+name+"%' ";
		
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = session.createQuery(query).list();
		
		return categoryModelList;
	}
}
