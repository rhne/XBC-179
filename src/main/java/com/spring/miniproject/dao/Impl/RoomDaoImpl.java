package com.spring.miniproject.dao.Impl;

import java.util.ArrayList;  
import java.util.List;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.RoomDao;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.model.TechnologyTrainerModel;
@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<RoomModel> searchAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = session.createQuery(" from RoomModel where isActive=1").list();
		return roomModelList;
	}

	@Override
	public RoomModel create(RoomModel roomModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(roomModel);
		return roomModel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String query = " select a from RoomModel a "
					 + " where a.title like '%"+name+"%' ";
		
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = session.createQuery(query).list();
		
		return roomModelList;
	}
	@Override
	public RoomModel searchById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (RoomModel) session.createQuery("from RoomModel where id=" + id).getSingleResult();
	}
	
	@Override
	public void delete(RoomModel roomModel) {
		roomModel.setIsActive(0);
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(roomModel);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomModel> showAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = session.createQuery(" from RoomModel ").list();
		return roomModelList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoomModel> searchByIdOffice(Long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = session.createQuery(" select t from RoomModel t join OfficeModel c on c.id = t.idOffice where t.idOffice ="+id+"").list();
		return roomModelList;
	}

}
