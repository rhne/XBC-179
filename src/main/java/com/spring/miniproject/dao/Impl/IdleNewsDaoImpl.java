package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.IdleNewsDao;
import com.spring.miniproject.model.IdleNewsModel;
@Repository
public class IdleNewsDaoImpl implements IdleNewsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<IdleNewsModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<IdleNewsModel> idlenewsModelList = new ArrayList<IdleNewsModel>();
		idlenewsModelList = session.createQuery(" from IdleNewsModel where isDeleted=0 ").list();
		return idlenewsModelList;
	}

	@Override
	public void create(IdleNewsModel idlenewsModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(idlenewsModel);
	}
}