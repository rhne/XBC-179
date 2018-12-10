package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.model.TechnologyTrainerModel;
import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyService;
import com.spring.miniproject.service.TechnologyTrainerService;

@Controller
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TechnologyTrainerService technologyTrainerService;
	
	
	@RequestMapping(value="technology")
	public String homeTechnology() {
		String jsp = "technology/technology";
		return jsp;
	}
	
	@RequestMapping(value="technology/addTechnology")
	public String addTechnology() {
		String jsp="technology/addTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/listTechnology")
	public String listTechnology(Model model) {
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.showAll();
		
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/listTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/addTechnology/save")
	public String addSaveTechnology(HttpServletRequest request, Model model) {
		//parse json array
		String trainerJsonArray = request.getParameter("trainer");
		JsonParser jsonParser = new JsonParser();
		Object obj = jsonParser.parse(trainerJsonArray);
		JsonArray trainerArray = (JsonArray) obj;
		JsonObject jsonObject = new JsonObject();
		
		//Technology model instance
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel.setTechnologyTrainer(new ArrayList<TechnologyTrainerModel>());
		technologyModel = this.technologyService.create(technologyModel);
		
		//get from form
		Long idTech = new Long(this.sequenceService.nextIdTechnology());
		model.addAttribute("idTech", idTech);
		
		technologyModel.setIdTech(idTech);
		technologyModel.setName(request.getParameter("name"));
		technologyModel.setNotes(request.getParameter("note"));
		technologyModel.setCreatedBy(request.getParameter("createdBy"));
		
		this.technologyService.create(technologyModel);
		
		//TechTrainer instance
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		List<TechnologyTrainerModel> technologyTrainerModelList = new ArrayList<TechnologyTrainerModel>();
		TrainerModel trainerModel;
		TechnologyTrainerModel technologyTrainerModel;
		
		for (int i = 0; i < trainerArray.size(); i++) {
			jsonObject = (JsonObject) trainerArray.get(i);
			trainerModel = new TrainerModel();
			Long idTrainer = jsonObject.get("id").getAsLong();
			trainerModel.setIdTrainer(idTrainer);
			trainerModelList.add(trainerModel);
			
			technologyTrainerModel = new TechnologyTrainerModel();
			technologyTrainerModel.setTrainerModel(trainerModel);
			technologyTrainerModel.setTechnologyModel(technologyModel);
			technologyTrainerModel.setTrainerId(idTrainer);
			technologyTrainerModel.setTechnologyId(idTech);
			technologyTrainerModel = this.technologyTrainerService.create(technologyTrainerModel);
			technologyTrainerModelList.add(technologyTrainerModel);
		}
		
		String jsp = "technology/technology";
		return jsp;
	}
	
	@RequestMapping(value="technology/searchTechnology/text")
	public String searchTechnology(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.searchBy(text);
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/listTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/deactiveTechnology")
	public String deactiveTechnology(HttpServletRequest request, Model model) {
		Long idTech = new Long(request.getParameter("idDeact"));
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel = this.technologyService.searchById(idTech);
		
		model.addAttribute("technologyModel", technologyModel);

		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.showAll();
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/deactiveTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/deactiveTechnology/save")
	public String deactiveSaveTechnology(HttpServletRequest request) {
		Long idTech = new Long(request.getParameter("idTech"));
		
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel = this.technologyService.searchById(idTech);
		
		technologyModel.setIdTech(idTech);
		
		this.technologyService.delete(technologyModel);
		
		String jsp = "technology/technology";
		return jsp;
	}
	
	@RequestMapping(value="technology/editTechnology")
	public String editTechnology(HttpServletRequest request, Model model) {
		Long idTech = new Long(request.getParameter("idEdit"));
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel = this.technologyService.searchById(idTech);
		
		model.addAttribute("technologyModel", technologyModel);

		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.showAll();
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/editTechnology";
		return jsp;
	}
	
}
