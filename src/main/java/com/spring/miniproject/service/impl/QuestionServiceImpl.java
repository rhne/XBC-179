package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.QuestionDao;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<QuestionModel> searchAll() {
		return this.questionDao.searchAll();
	}

	@Override
	public void create(QuestionModel questionModel) {
		this.questionDao.create(questionModel);
	}

	@Override
	public QuestionModel searchById(Long id) {
		return this.questionDao.searchById(id);
	}

	@Override
	public void update(QuestionModel questionModel) {
		this.questionDao.update(questionModel);
	}

	@Override
	public void delete(QuestionModel questionModel) {
		this.questionDao.delete(questionModel);
	}

	@Override
	public List<QuestionModel> searchByLikeQuestion(String str) {
		return this.questionDao.searchByLikeQuestion(str);
	}

}
