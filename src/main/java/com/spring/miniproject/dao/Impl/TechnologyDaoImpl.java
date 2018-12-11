package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TechnologyDao;
import com.spring.miniproject.model.TechnologyModel;

@Repository
public class TechnologyDaoImpl implements TechnologyDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public TechnologyModel create(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		technologyModel.setActive(1);
		Session session = this.sessionFactory.getCurrentSession();
		session.save(technologyModel);
		return technologyModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechnologyModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = session.createQuery(" select t from TechnologyModel t where t.active = 1 ").list();
		return technologyModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TechnologyModel> searchBy(String text) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select t from TechnologyModel t where t.name like '%"+text+"%'";
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = session.createQuery(query).list();
		return technologyModelList;
	}

	@Override
	public TechnologyModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select t from TechnologyModel t where t.id="+id+"";
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel = (TechnologyModel) session.createQuery(query).getSingleResult();
		return technologyModel;
	}

	@Override
	public void edit(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(technologyModel);
	}

	@Override
	public TechnologyModel delete(TechnologyModel technologyModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		technologyModel.setActive(0);
		session.update(technologyModel);
		return technologyModel;
	}
}
