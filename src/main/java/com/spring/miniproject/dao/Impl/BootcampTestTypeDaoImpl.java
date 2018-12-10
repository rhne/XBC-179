package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BootcampTestTypeDao;
import com.spring.miniproject.model.BootcampTestTypeModel;

@Repository
public class BootcampTestTypeDaoImpl implements BootcampTestTypeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<BootcampTestTypeModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = session.createQuery(" from BootcampTestTypeModel where isActive =1").list();
		return bootcamptesttypeModelList;
	}

	@Override
	public void create(BootcampTestTypeModel bootcamptesttypeModel) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bootcamptesttypeModel);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BootcampTestTypeModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from BootcampTestTypeModel a "
					 + " where a.isActive =1 and a.name like '%"+name+"%' ";
		
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = session.createQuery(query).list();
		
		return bootcamptesttypeModelList;
	}
	@Override
	public BootcampTestTypeModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (BootcampTestTypeModel) session.createQuery("from BootcampTestTypeModel where id=" + id).getSingleResult();
	}
	
	@Override
	public void delete(BootcampTestTypeModel bootcamptesttypeModel) {
		bootcamptesttypeModel.setIsActive(0);
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bootcamptesttypeModel);
	}
	@Override
	public void update(BootcampTestTypeModel bootcamptesttypeModel) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bootcamptesttypeModel);
	}
}
