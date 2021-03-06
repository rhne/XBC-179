package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
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
	public TechnologyTrainerModel create(TechnologyTrainerModel technologyTrainerModel) {
		// TODO Auto-generated method stub
		technologyTrainerModel.setCreatedOn(new Date());
		Session session = this.sessionFactory.getCurrentSession();
		session.save(technologyTrainerModel);
		return technologyTrainerModel;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<TechnologyTrainerModel> searchByIdTech(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<TechnologyTrainerModel> technologyTrainerModelList = new ArrayList<TechnologyTrainerModel>();
		String query = " select t from TechnologyTrainerModel t join TechnologyModel c on c.id = t.idTech where t.idTech ="+id+"";
		technologyTrainerModelList = session.createQuery(query).list();
		return technologyTrainerModelList;
	}

	@Override
	public void delete(TechnologyTrainerModel technologyTrainerModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(technologyTrainerModel);
	}

	@Override
	public TechnologyTrainerModel deleteById(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select t from TechnologyTrainerModel t where t.id ="+id+"";
		TechnologyTrainerModel technologyTrainerModel = new TechnologyTrainerModel();
		technologyTrainerModel = (TechnologyTrainerModel) session.createQuery(query).getSingleResult();
		return technologyTrainerModel;
	}

}
