package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.BatchDao;
import com.spring.miniproject.model.BatchModel;

@Repository
public class BatchDaoImpl implements BatchDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(BatchModel batchModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(batchModel);
	}

	@Override
	public void edit(BatchModel batchModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(batchModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BatchModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
		String query = " select b from BatchModel b where b.idDeleted = 0 ";
		batchModelList = session.createQuery(query).list();
		return batchModelList;
	}

	@Override
	public BatchModel searchById(Long idBatch) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select b from BatchModel b where b.idBatch="+idBatch+"";
		BatchModel batchModel = new BatchModel();
		batchModel = (BatchModel) session.createQuery(query).getSingleResult();
	
		return batchModel;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BatchModel> searchBy(String nameTech) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
		String query = " select b from BatchModel t where b.name like '%"+nameTech+"%'";
		batchModelList = session.createQuery(query).list();
		return batchModelList;
	}

}
