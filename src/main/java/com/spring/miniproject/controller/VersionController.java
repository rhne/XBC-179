package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionModel;
import com.spring.miniproject.service.QuestionService;
import com.spring.miniproject.service.VersionService;

@Controller
public class VersionController {
	
	@Autowired
	private VersionService versionService;
	@Autowired
	private QuestionService questionService;
	
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
		model.addAttribute("versionModel", versionModel);
		model.addAttribute("latestVersion", versionModel.getVersion());
		String jsp = "version/tambah2";
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
	
}
