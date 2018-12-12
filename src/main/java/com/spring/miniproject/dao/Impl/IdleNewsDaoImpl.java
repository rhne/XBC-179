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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IdleNewsModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from IdleNewsModel a "
					 + " where a.title like '%"+name+"%' ";
		
		List<IdleNewsModel> idlenewsModelList = new ArrayList<IdleNewsModel>();
		idlenewsModelList = session.createQuery(query).list();
		
		return idlenewsModelList;
	}
	@Override
	public IdleNewsModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (IdleNewsModel) session.createQuery("from IdleNewsModel where id=" + id).getSingleResult();
	}
	
	@Override
	public void delete(IdleNewsModel idlenewsModel) {
		
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(idlenewsModel);
	}
	@Override
	public void update(IdleNewsModel idlenewsModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(idlenewsModel);
	}
	@Override
	public void publish(IdleNewsModel idlenewsModel) {
		idlenewsModel.setIsPublish(1);
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(idlenewsModel);
	}
}
