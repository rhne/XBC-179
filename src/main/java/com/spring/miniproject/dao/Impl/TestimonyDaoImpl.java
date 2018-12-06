package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TestimonyDao;
import com.spring.miniproject.model.TestimonyModel;

@Repository
public class TestimonyDaoImpl implements TestimonyDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(TestimonyModel testimonyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(testimonyModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestimonyModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		testimonyModelList = session.createQuery(" select t from TestimonyModel t where t.isDeleted = 0 ").list();
		return testimonyModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestimonyModel> searchBy(String title) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		String query = " select t from TestimonyModel t where t.title like '%"+title+"%'";
		
		testimonyModelList = session.createQuery(query).list();
		return testimonyModelList;
	}

	@Override
	public void edit(TestimonyModel testimonyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(testimonyModel);
	}

	@Override
	public TestimonyModel searchById(Long idTestimony) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select t from TestimonyModel t where t.idTestimony="+idTestimony+"";
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel = (TestimonyModel) session.createQuery(query).getSingleResult();
	
		return testimonyModel;
	}

}
