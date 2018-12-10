package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BootcampTypeDao;
import com.spring.miniproject.model.BootcampTypeModel;

@Repository
public class BootcampTypeDaoImpl implements BootcampTypeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(BootcampTypeModel bootcampTypeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bootcampTypeModel);
	}

	@Override
	public void edit(BootcampTypeModel bootcampTypeModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bootcampTypeModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BootcampTypeModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select b from BootcampTypeModel b where b.active = 1 ";
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = session.createQuery(query).list();
		return bootcampTypeModelList;
	}

	@Override
	public BootcampTypeModel searchById(Long idBootcamp) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select b from BootcampTypeModel b where b.idBootcamp="+idBootcamp+"";
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel = (BootcampTypeModel) session.createQuery(query).getSingleResult();
		return bootcampTypeModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BootcampTypeModel> searchByName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select b from BootcampTypeModel b where b.name like '%"+name+"%'";
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = session.createQuery(query).list();
		return bootcampTypeModelList;
	}

}
