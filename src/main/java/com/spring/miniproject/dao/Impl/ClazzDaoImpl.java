package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.ClazzDao;
import com.spring.miniproject.model.ClazzModel;

@Repository
public class ClazzDaoImpl implements ClazzDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(ClazzModel clazzModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(clazzModel);
	}

	@Override
	public void delete(ClazzModel clazzModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(clazzModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClazzModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<ClazzModel> clazzModelList = new ArrayList<ClazzModel>();
		String query = " select c from ClazzModel c where c.isDeleted=0 ";
		clazzModelList = session.createQuery(query).list();
		return clazzModelList;
	}

	@Override
	public ClazzModel searchById(Long idClazz) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ClazzModel clazzModel = new ClazzModel();
		String query = " select c from ClazzModel c where c.clazzId = "+idClazz+"";
		clazzModel =  (ClazzModel) session.createQuery(query).getSingleResult();
		return clazzModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClazzModel> searchByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<ClazzModel> clazzModelList = new ArrayList<ClazzModel>();
		String query = " select c from ClazzModel c join BatchModel b on b.batchId = c.batchId where b.name like '%"+name+"%'";
		clazzModelList = session.createQuery(query).list();
		return clazzModelList;
	}
}
