package com.spring.miniproject.dao.Impl;

import java.util.ArrayList; 
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
		String query = "select r from RoleModel r";
		
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = session.createQuery(query).list();
		
		return roleModelList;
	}

	@Override
	public RoleModel searchById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select r from RoleModel r where r.id="+id+"";
		
		RoleModel roleModel = new RoleModel();
		roleModel = (RoleModel) session.createQuery(query).getSingleResult();
		
		return roleModel;
	}

	@Override
	public void delete(RoleModel roleModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(roleModel);
	}

	@Override
	public void update(RoleModel roleModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roleModel);
	}
	
}
