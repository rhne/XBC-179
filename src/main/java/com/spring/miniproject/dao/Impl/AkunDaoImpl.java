package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.AkunDao;
import com.spring.miniproject.model.AkunModel;

@Repository
public class AkunDaoImpl implements AkunDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void create(AkunModel akunModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(akunModel);
	}

	@SuppressWarnings("unchecked")
	public List<AkunModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<AkunModel> akunModelList = new ArrayList<AkunModel>();
		akunModelList = session.createQuery(" from AkunModel where isActive = 1").list();
		return akunModelList;
	}

	@Override
	public AkunModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "Select a from AkunModel a where id="+id+" ";
		AkunModel akunModel= new AkunModel();
		akunModel = (AkunModel) session.createQuery(query).getSingleResult();
		return akunModel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AkunModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from AkunModel a "
					 + " where a.name like '%"+name+"%' ";
		
		List<AkunModel> akunModelList = new ArrayList<AkunModel>();
		akunModelList = session.createQuery(query).list();
		
		return akunModelList;
	}

	@Override
	public void update(AkunModel akunModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(akunModel);
	}

	@Override
	public AkunModel searchByUsernamePassword(String username, String password) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		AkunModel akunModel = new AkunModel();
		String query = " from AkunModel "
				     + " where name='"+username+"' "
				     + "   and password='"+password+"' ";
		try {
			akunModel = (AkunModel) session.createQuery(query).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return akunModel;
	}

	@Override
	public void deactivate(AkunModel akunModel) {
		// TODO Auto-generated method stub
		akunModel.setIsActive(0);
		akunModel.setModifiedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(akunModel);
	}
}
