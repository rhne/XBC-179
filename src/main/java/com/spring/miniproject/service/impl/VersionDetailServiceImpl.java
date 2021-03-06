package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.VersionDetailDao;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionDetailModel;
import com.spring.miniproject.service.VersionDetailService;

@Service
@Transactional
public class VersionDetailServiceImpl implements VersionDetailService {

	@Autowired
	private VersionDetailDao versionDetailDao;
	
	@Override
	public VersionDetailModel create(VersionDetailModel versionDetailModel) {
		return this.versionDetailDao.create(versionDetailModel);
	}

	@Override
	public List<VersionDetailModel> searchAll() {
		return this.versionDetailDao.searchAll();
	}

	@Override
	public List<QuestionModel> getQuestionsByVersionId(Long versionId) {
		return this.versionDetailDao.getQuestionsByVersionId(versionId);
	}

}
