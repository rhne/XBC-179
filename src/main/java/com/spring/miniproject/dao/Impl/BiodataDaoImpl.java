package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BiodataDao;
import com.spring.miniproject.model.BiodataModel;

@Repository
public class BiodataDaoImpl implements BiodataDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void create(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(biodataModel);
	}

	@SuppressWarnings("unchecked")
	public List<BiodataModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = session.createQuery(" from BiodataModel ").list();
		return biodataModelList;
	}
}
