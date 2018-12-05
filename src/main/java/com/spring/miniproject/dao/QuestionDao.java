package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.QuestionModel;

public interface QuestionDao {
	
	public List<QuestionModel> searchAll();
	public void create(QuestionModel questionModel);
	public QuestionModel searchById(Long id);
	public void update(QuestionModel questionModel);
	public void delete(QuestionModel questionModel);
	public List<QuestionModel> searchByLikeQuestion(String str);
	
}
