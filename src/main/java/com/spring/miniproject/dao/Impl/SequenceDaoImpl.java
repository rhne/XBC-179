package com.spring.miniproject.dao.Impl;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.SequenceDao;
import com.spring.miniproject.model.SequenceModel;

@Repository
public class SequenceDaoImpl implements SequenceDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Integer nextIdAkun() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idAkun = 0;
		String query = "from SequenceModel where sequenceName='A_AKUN_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idAkun = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idAkun = 1;
		}
		return idAkun;
	}

	@Override
	public Integer nextIdRole() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idRole = 0;
		String query = "from SequenceModel where sequenceName='R_ROLE_ID' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idRole = sequenceModel.getSequenceValue();
		} catch (Exception e) {
			// TODO: handle exception
			idRole = 1;
		}
		return idRole;
	}

	@Override
	public Integer nextIdTechnology() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idTech = 0;
		String query = " from SequenceModel where sequenceName='ID_TECHNOLOGY' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idTech = sequenceModel.getSequenceValue();
			
		} catch (Exception e) {
			// TODO: handle exception
			idTech = 1;
		}
		return idTech;
	}

	@Override
	public Integer nextIdTrainer() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idTrainer = 0;
		String query = " from SequenceModel where sequenceName='ID_TRAINER' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idTrainer = sequenceModel.getSequenceValue();
			
		} catch (Exception e) {
			// TODO: handle exception
			idTrainer = 1;
		}
		return idTrainer;
	}

	@Override
	public Integer nextIdBiodata() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Integer idBiodata = 0;
		String query = " from SequenceModel where sequenceName='ID_BIODATA' ";
		try {
			SequenceModel sequenceModel = new SequenceModel();
			sequenceModel = (SequenceModel) session.createQuery(query).getSingleResult();
			idBiodata = sequenceModel.getSequenceValue();
			
		} catch (Exception e) {
			// TODO: handle exception
			idBiodata = 1;
		}
		return idBiodata;
	}

}
