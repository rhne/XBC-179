package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.RoleDao;
import com.spring.miniproject.model.RoleModel;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void create(RoleModel roleModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(roleModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleModel> select() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select r from RoleModel r where r.isActive=1";
		
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = session.createQuery(query).list();
		
		return roleModelList;
	}

	@Override
	public RoleModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select r from RoleModel r where r.id="+id+"";
		
		RoleModel roleModel = new RoleModel();
		roleModel = (RoleModel) session.createQuery(query).getSingleResult();
		
		return roleModel;
	}

	@Override
	public void update(RoleModel roleModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roleModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select r from RoleModel r "
					 + " where r.isActive=1 and r.name like '%"+name+"%' ";
		
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = session.createQuery(query).list();
		
		return roleModelList;
	}

	@Override
	public void deactivate(RoleModel roleModel) {
		// TODO Auto-generated method stub
		roleModel.setIsActive(0);
		roleModel.setModifiedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roleModel);
	}
	
}
