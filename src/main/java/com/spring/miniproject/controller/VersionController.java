package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.model.QuestionModel;
import com.spring.miniproject.model.VersionDetailModel;
import com.spring.miniproject.model.VersionModel;
import com.spring.miniproject.service.QuestionService;
import com.spring.miniproject.service.VersionDetailService;
import com.spring.miniproject.service.VersionService;

@Controller
public class VersionController extends BaseController {
	
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
//		VersionModel versionModel = new VersionModel();
//		versionModel = this.versionService.create(versionModel);
//		
//		QuestionModel questionModel = new QuestionModel();
//		questionModel.setId((long) 1);
//		
//		VersionDetailModel versionDetailModel = new VersionDetailModel();
//		versionDetailModel.setVersion(versionModel);
//		versionDetailModel.setQuestion(questionModel);
//		versionDetailModel = this.versionDetailService.create(versionDetailModel);
//		
//		model.addAttribute("versionModel", versionModel);
		
		model.addAttribute("latestVersion", this.versionService.getLatestVersion()+1);
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
	public String tambahquestion(HttpServletRequest request, Model model) {
		JsonParser jsonParser = new JsonParser();
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		Gson gson = new Gson();
		
		String questionJsonArrayString = request.getParameter("data");
		JsonArray questionJsonArray = jsonParser.parse(questionJsonArrayString).getAsJsonArray();
		questionModels = this.questionService.searchAll();
		//ArrayList selectedQuestionArray = gson.fromJson(questionJsonArrayString, ArrayList.class);
		
		for (int i = 0; i < questionJsonArray.size(); i++) {
			JsonObject jsonObject = questionJsonArray.get(i).getAsJsonObject();
			Long qId = jsonObject.get("id").getAsLong();
			
			for (int j = 0; j < questionModels.size(); j++) {
				if(questionModels.get(j).getId() == qId) {
					questionModels.remove(j);
				}
			}
		}
		
		model.addAttribute("questionModelList", questionModels);
		String jsp = "version/tambahquestion";
		return jsp;
	}
	
	@RequestMapping(value="version/list")
	public String list(Model model) {
		List<VersionModel> versionModels = new ArrayList<VersionModel>();
		versionModels = this.versionService.searchAll();
//		List<VersionDetailModel> versionDetailModels = new ArrayList<VersionDetailModel>();
//		versionDetailModels = this.versionDetailService.searchAll();
		
		model.addAttribute("versionModelList", versionModels);
		String jsp = "version/list";
		return jsp;
	}
	
	@RequestMapping(value="version/create")
	public String create(HttpServletRequest request, Model model) {
		//parse inputed question json array 
		String stringQuestionJsonArray = request.getParameter("questions");
		JsonParser jsonParser = new JsonParser();
		Object obj = jsonParser.parse(stringQuestionJsonArray);
		JsonArray questionArray = (JsonArray) obj;
		JsonObject jsonObject = new JsonObject();
		
		//create Version model instance in table
		VersionModel versionModel = new VersionModel();
		versionModel.setVersionDetails(new ArrayList<VersionDetailModel>());
		AkunModel createdBy = this.getAkunModel();
		versionModel.setVersion(this.versionService.getLatestVersion() + 1);
		versionModel.setCreatedBy(createdBy);
		versionModel.setCreatedOn(new Date());
		versionModel.setIsDelete(0);
		versionModel = this.versionService.create(versionModel);
		
		//create VersionDetail instances in table
		List<QuestionModel> questionModels = new ArrayList<QuestionModel>();
		List<VersionDetailModel> versionDetailModels = new ArrayList<VersionDetailModel>();
		QuestionModel questionModel;
		VersionDetailModel versionDetailModel;
		for(int i=0; i<questionArray.size(); i++) {
			jsonObject = (JsonObject) questionArray.get(i);
			questionModel = new QuestionModel();
			Long id = jsonObject.get("id").getAsLong();
			questionModel.setId(id);
			questionModels.add(questionModel);
			
			versionDetailModel = new VersionDetailModel();
			versionDetailModel.setVersion(versionModel);
			versionDetailModel.setQuestion(questionModel);
			versionDetailModel.setCreatedBy(createdBy);
			versionDetailModel.setCreatedOn(new Date());
			versionDetailModel = this.versionDetailService.create(versionDetailModel);
			versionDetailModels.add(versionDetailModel);
			//versionModel.getVersionDetails().add(versionDetailModel);
		}
		
		//versionModel.setVersionDetails(versionDetailModels);
		//this.versionService.update(versionModel);
		
		String jsp = "version/home";
		return jsp;
	}
	
	@RequestMapping(value="version/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		VersionModel versionModel = new VersionModel();
		versionModel = this.versionService.searchById(Long.parseLong(id));
		AkunModel deletedBy = this.getAkunModel();
		versionModel.setDeletedBy(deletedBy);
		versionModel.setDeletedOn(new Date());
		versionModel.setIsDelete(1);
		this.versionService.delete(versionModel);
		
		String jsp = "version/home";
		return jsp;
	}
}
