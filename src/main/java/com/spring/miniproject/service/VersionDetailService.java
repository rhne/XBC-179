package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionDetailModel;

public interface VersionDetailService {

	public VersionDetailModel create(VersionDetailModel versionDetailModel);
	public List<VersionDetailModel> searchAll();
	public List<QuestionModel> getQuestionsByVersionId(Long versionId);
	
}
