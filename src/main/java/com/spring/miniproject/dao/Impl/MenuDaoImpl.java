package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
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
		String query = "select m from MenuModel m where Active = 1";
		
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
					 + " where Active=1 and m.title like '%"+title+"%' and menuparent > 0";
		
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<MenuModel> selectMenuByRole(Long idRole) {
		// TODO Auto-generated method stub
		String query = "SELECT "
				+" M.ID ID,"
				+" M.MENU_PARENT MENU_PARENT,"
				+" M.KODE KODE,"
				+" M.TITLE TITLE,"
				+" M.DESCRIPTION DESCRIPTION,"
				+" M.IMAGE_URL IMAGE_URL,"
				+" M.MENU_URL MENU_URL,"
				+" M.ACTIVE ACTIVE,"
				+" M.MENU_ORDER MENU_ORDER,"
				+" M.CREATED_BY CREATED_BY,"
				+" M.CREATED_ON CREATED_ON,"
				+" M.MODIFIED_BY MODIFIED_BY,"
				+" M.MODIFIED_ON MODIFIED_ON "
				+ "FROM M_MENU M "
				+ "JOIN MA_MENU_AKSES MA "
				+ "ON MA.ID_MENU = M.ID "
				+ "WHERE MA.ID_ROLE = "+idRole+" "
						+ "ORDER BY M.MENU_ORDER ASC";
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.addEntity(MenuModel.class);
		List<MenuModel> menuModelList = sqlQuery.list();
		
		return menuModelList;
	}
	
}
