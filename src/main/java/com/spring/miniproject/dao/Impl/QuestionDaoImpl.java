package com.spring.miniproject.dao.Impl;

import java.util.Date;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionModel> searchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from QuestionModel where isDelete=0").list();
	}

	@Override
	public void create(QuestionModel questionModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(questionModel);
	}

	@Override
	public QuestionModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (QuestionModel) session.createQuery("from QuestionModel where id=" + id).getSingleResult();
	}

	@Override
	public void update(QuestionModel questionModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(questionModel);
	}
	
	@Override
	public void delete(QuestionModel questionModel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(questionModel);
	}

	@Override
	public List<QuestionModel> searchByLikeQuestion(String str) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from QuestionModel where isDelete=0 and question like '%"+ str +"%'").list();
	}

}
