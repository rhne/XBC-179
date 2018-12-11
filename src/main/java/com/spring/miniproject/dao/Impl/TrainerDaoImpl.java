package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.TrainerDao;
import com.spring.miniproject.model.TrainerModel;

@Repository
public class TrainerDaoImpl implements TrainerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(TrainerModel trainerModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(trainerModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainerModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = session.createQuery(" select t from TrainerModel t where t.active = 1 ").list();
		return trainerModelList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainerModel> searchBy(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		String query = " select t from TrainerModel t where t.name like '%"+name+"%'";
		
		trainerModelList = session.createQuery(query).list();
		return trainerModelList;
	}

	@Override
	public TrainerModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select t from TrainerModel t where t.id="+id+"";
		TrainerModel trainerModel = new TrainerModel();
		trainerModel = (TrainerModel) session.createQuery(query).getSingleResult();
	
		return trainerModel;
	}

	@Override
	public void edit(TrainerModel trainerModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trainerModel);
	}


}
