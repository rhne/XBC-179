package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BiodataDao;
import com.spring.miniproject.model.BiodataModel;

@Repository
public class BiodataDaoImpl implements BiodataDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* Biodata Add */
	public void create(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(biodataModel);
	}

	/* Biodata List */
	@SuppressWarnings("unchecked")
	public List<BiodataModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = session.createQuery(" from BiodataModel where active = 1").list();
		return biodataModelList;
	}

	/* Select Biodata ID to Modify */
	@Override
	public BiodataModel searchById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = "select b from BiodataModel b where b.id=" + id + "";
		BiodataModel biodataModel = new BiodataModel();
		biodataModel = (BiodataModel) session.createQuery(query).getSingleResult();
		return biodataModel;
	}

	/* Biodata Edit */
	@Override
	public void update(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(biodataModel);
	}

	/* Biodata Search */
	@SuppressWarnings("unchecked")
	@Override
	public List<BiodataModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select b from BiodataModel b where b.active=1 and b.name like '%" + name + "%' ";
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = session.createQuery(query).list();
		return biodataModelList;
	}

	/* Biodata Deactivate */
	@Override
	public void deactivate(BiodataModel biodataModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(biodataModel);
	}
}
