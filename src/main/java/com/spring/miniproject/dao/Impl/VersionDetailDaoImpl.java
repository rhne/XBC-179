package com.spring.miniproject.dao.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.miniproject.dao.VersionDetailDao;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionDetailModel;

@Repository
public class VersionDetailDaoImpl implements VersionDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public VersionDetailModel create(VersionDetailModel versionDetailModel) {
		versionDetailModel.setCreatedOn(new Date());
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(versionDetailModel);
		return versionDetailModel;
	}

	@Override
	public List<VersionDetailModel> searchAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from VersionDetailModel").list();
	}

	@Override
	public List<QuestionModel> getQuestionsByVersionId(Long versionId) {
		Session session = this.sessionFactory.getCurrentSession();
		String query = "SELECT TQ.* FROM T_VERSION_DETAIL VD JOIN T_QUESTION TQ ON TQ.ID = VD.QUESTION_ID WHERE VD.VERSION_ID=";
		//List<QuestionModel> questionModels = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(QuestionModel.class)).list();
		SQLQuery q = session.createSQLQuery(query + versionId);
		q.addEntity(QuestionModel.class);
		List<QuestionModel> questionModels = q.list();
		return questionModels;
	}

}
