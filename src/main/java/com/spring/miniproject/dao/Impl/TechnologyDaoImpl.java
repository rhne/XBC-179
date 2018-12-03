package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TechnologyDao;
import com.spring.miniproject.model.TechnologyModel;

import antlr.collections.impl.LList;

@Repository
public class TechnologyDaoImpl implements TechnologyDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crete(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(technologyModel);
	}

	@Override
	public List<TechnologyModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = session.createQuery(" from TechnologyModel ").list();
		return technologyModelList;
	}
}
