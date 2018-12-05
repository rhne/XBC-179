package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TechnologyTrainerDao;
import com.spring.miniproject.model.TechnologyTrainerModel;

@Repository
public class TechnologyTrainerDaoImpl implements TechnologyTrainerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(TechnologyTrainerModel technologyTrainerModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(technologyTrainerModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechnologyTrainerModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TechnologyTrainerModel> technologyTrainerModelList = new ArrayList<TechnologyTrainerModel>();
		technologyTrainerModelList = session.createQuery(" from TechnologyTrainerModel ").list();
		return technologyTrainerModelList;
	}

}
