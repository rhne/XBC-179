package com.spring.miniproject.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TestDao;
import com.spring.miniproject.model.TestModel;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TestModel> searchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from TestModel where isActive=1").list();
	}

}
