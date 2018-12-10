package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.TestModel;
import com.spring.miniproject.model.VersionModel;
import com.spring.miniproject.service.QuestionService;
import com.spring.miniproject.service.TestService;
import com.spring.miniproject.service.VersionDetailService;
import com.spring.miniproject.service.VersionService;

@Controller
public class FeedbackController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private VersionService versionService;
	@Autowired
	private VersionDetailService versionDetailService;
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="feedback")
	public String tambah(Model model) {
		VersionModel latestVersion = this.versionService.getLatestVersionModel();
		List<TestModel> testModels = new ArrayList<TestModel>();
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		
		testModels = this.testService.searchAll();
		if(latestVersion != null) {
			questionModels = this.versionDetailService.getQuestionsByVersionId(latestVersion.getId());
		}
		
		model.addAttribute("versionId", latestVersion.getId());
		model.addAttribute("testModelList", testModels);
		model.addAttribute("questionModelList", questionModels);
		String jsp = "feedback/tambah";
		return jsp;
	}
	
}
