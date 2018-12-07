package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionDetailModel;
import com.spring.miniproject.model.VersionModel;
import com.spring.miniproject.service.QuestionService;
import com.spring.miniproject.service.VersionDetailService;
import com.spring.miniproject.service.VersionService;

@Controller
public class VersionController {
	
	@Autowired
	private VersionService versionService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private VersionDetailService versionDetailService;
	
	@RequestMapping(value="version")
	public String home() {
		String jsp = "version/home";
		return jsp;
	}
	
	@RequestMapping(value="version/tambah")
	public String tambah(Model model) {
		//immediately create a record to db, and pass the id to frontend
		VersionModel versionModel = new VersionModel();
		versionModel = this.versionService.create(versionModel);
		
		QuestionModel questionModel = new QuestionModel();
		questionModel.setId((long) 1);
		
		VersionDetailModel versionDetailModel = new VersionDetailModel();
		versionDetailModel.setVersion(versionModel);
		versionDetailModel.setQuestion(questionModel);
		versionDetailModel = this.versionDetailService.create(versionDetailModel);
		
		model.addAttribute("versionModel", versionModel);
		model.addAttribute("latestVersion", versionModel.getVersion());
		String jsp = "version/tambah2";
		return jsp;
	}
	
	@RequestMapping(value="version/listquestion")
	public String listquestion(HttpServletRequest request, Model model) {
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		questionModels = this.questionService.searchAll();
		
		model.addAttribute("questionModelList", questionModels);
		String jsp = "question/list";
		return jsp;
	}
	
	@RequestMapping(value="version/tambahquestion")
	public String tambahquestion(Model model) {
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		questionModels = this.questionService.searchAll();
		model.addAttribute("questionModelList", questionModels);
		String jsp = "version/tambahquestion";
		return jsp;
	}
	
	@RequestMapping(value="version/list")
	public String list(Model model) {
		List<VersionModel> versionModels = new ArrayList<VersionModel>();
		versionModels = this.versionService.searchAll();
		
		model.addAttribute("versionModelList", versionModels);
		
		String jsp = "version/list";
		return jsp;
	}
	
	@RequestMapping(value="version/create")
	public String create(HttpServletRequest request, Model model) {
		
		String input = request.getParameter("questions");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsp = "version/home";
		return jsp;
	}
}
