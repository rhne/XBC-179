package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.QuestionModel;

public interface QuestionService {

	public List<QuestionModel> searchAll();
	public void create(QuestionModel questionModel);
	public QuestionModel searchById(Long id);
	public void update(QuestionModel questionModel);
	public void delete(QuestionModel questionModel);
	
}
