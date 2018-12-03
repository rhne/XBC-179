package com.spring.miniproject.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.QuestionDao;
import com.spring.miniproject.model.QuestionModel;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<QuestionModel> searchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from QuestionModel").list();
	}

}
