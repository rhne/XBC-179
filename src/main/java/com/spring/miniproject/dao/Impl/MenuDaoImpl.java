package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.MenuDao;
import com.spring.miniproject.model.MenuModel;

@SuppressWarnings("deprecation")
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
		String query = "select m from MenuModel m";
		
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
		Session session = this.sessionFactory.getCurrentSession();
		session.update(menuModel);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<MenuModel> searchByRole(Long idRole) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "SELECT "
					 + " M.ID ID, "
					 + " M.TITLE TITLE,"
					 + " M.KODE KODE, "
					 + " M.MENU_PARENT MENU_PARENT"
					 + "FROM M_MENU M "
					 + "JOIN M_MENUACCESS MA "
					 + " ON MA.ID_MENU = M.ID "
					 + "WHERE MA.ID_ROLE="+idRole+" "
					 + "ORDER BY M.TITLE ASC ";
		
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.addEntity(MenuModel.class);
		menuModelList = sqlQuery.list();
		
		return menuModelList;
	}
	
}
