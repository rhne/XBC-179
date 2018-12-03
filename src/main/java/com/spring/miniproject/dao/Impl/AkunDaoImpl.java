package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
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
		akunModelList = session.createQuery(" from AkunModel ").list();
		return akunModelList;
	}
}
