package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.MenuAksesDao;
import com.spring.miniproject.model.MenuAksesModel;

@Repository
public class MenuAksesDaoImpl implements MenuAksesDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void create(MenuAksesModel menuAksesModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(menuAksesModel);
	}

	@SuppressWarnings("unchecked")
	public List<MenuAksesModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<MenuAksesModel> menuAksesModelList = new ArrayList<MenuAksesModel>();
		menuAksesModelList = session.createQuery(" from MenuAksesModel ").list();
		return menuAksesModelList;
	}

	@Override
	public MenuAksesModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "Select a from MenuAksesModel a where id="+id+" ";
		MenuAksesModel menuAksesModel= new MenuAksesModel();
		menuAksesModel = (MenuAksesModel) session.createQuery(query).getSingleResult();
		return menuAksesModel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MenuAksesModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select ma from MenuAksesModel ma "
					 + " where ma.idRole like '%"+name+"%' ";
		
		List<MenuAksesModel> menuAksesModelList = new ArrayList<MenuAksesModel>();
		menuAksesModelList = session.createQuery(query).list();
		
		return menuAksesModelList;
	}

	@Override
	public void delete(MenuAksesModel menuAksesModel) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(menuAksesModel);
	}
}
