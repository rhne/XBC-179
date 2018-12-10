package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.MenuDao;
import com.spring.miniproject.model.MenuModel;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void create(MenuModel menuModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(menuModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select m from MenuModel m where Active = 1 and menuparent > 0";
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = session.createQuery(query).list();
		
		return menuModelList;
	}

	@Override
	public MenuModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select m from MenuModel m where m.id="+id+"";
		
		MenuModel menuModel = new MenuModel();
		menuModel = (MenuModel) session.createQuery(query).getSingleResult();
		
		return menuModel;
	}

	@Override
	public void update(MenuModel menuModel) {
		// TODO Auto-generated method stub
		menuModel.setModifiedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(menuModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> searchByLikeTitle(String title) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select m from MenuModel m "
					 + " where Active=1 and m.title like '%"+title+"%' ";
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = session.createQuery(query).list();
		
		return menuModelList;
	}

	@Override
	public void deactivate(MenuModel menuModel) {
		// TODO Auto-generated method stub
		menuModel.setActive(0);
		menuModel.setModifiedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(menuModel);
	}
	
}
