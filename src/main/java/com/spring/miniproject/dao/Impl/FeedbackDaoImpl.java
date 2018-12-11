package com.spring.miniproject.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.FeedbackDao;
import com.spring.miniproject.model.FeedbackModel;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public FeedbackModel create(FeedbackModel feedbackModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(feedbackModel);
		return feedbackModel;
	}
	
}
