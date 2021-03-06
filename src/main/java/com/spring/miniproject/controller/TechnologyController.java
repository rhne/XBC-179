package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
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
//import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyService;
import com.spring.miniproject.service.TechnologyTrainerService;

@Controller
public class TechnologyController extends BaseController {
	
	@Autowired
	private TechnologyService technologyService;
	
	
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
		
		//get from form
		Long idUser = this.getAkunModel().getId();
		technologyModel.setCreatedBy(idUser);
		technologyModel.setCreatedOn(new Date());
		technologyModel.setName(request.getParameter("name"));
		technologyModel.setNotes(request.getParameter("note"));
		
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
			trainerModel.setId(idTrainer);
			trainerModelList.add(trainerModel);
			
			technologyTrainerModel = new TechnologyTrainerModel();
			technologyTrainerModel.setTrainerModel(trainerModel);
			technologyTrainerModel.setTechnologyModel(technologyModel);
			technologyTrainerModel.setIdTrainer(idTrainer);
			technologyTrainerModel.setIdTech(technologyModel.getId());
			technologyTrainerModel.setCreatedBy(idUser);
			technologyTrainerModel.setCreatedOn(new Date());
			technologyTrainerModel.setIsDeleted(0);
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
		Long idUser = this.getAkunModel().getId();
		
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel = this.technologyService.searchById(idTech);
		
		technologyModel.setId(idTech);
		technologyModel.setModifiedBy(idUser);
		technologyModel.setModifiedOn(new Date());
		
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
	
	@RequestMapping(value="technology/editTechnology/save")
	public String editSaveTechnology(HttpServletRequest request) {
		//parse json array
		String trainerJsonArray = request.getParameter("trainer");
		JsonParser jsonParser = new JsonParser();
		Object obj = jsonParser.parse(trainerJsonArray);
		JsonArray trainerArray = (JsonArray) obj;
		JsonObject jsonObject = new JsonObject();
		
		Long idTech = new Long (request.getParameter("id"));
		
		//Technology model instance
		TechnologyModel technologyModel = new TechnologyModel();
//		technologyModel.setTechnologyTrainer(new ArrayList<TechnologyTrainerModel>());
		technologyModel = this.technologyService.searchById(idTech);
		
		//get from form
		Long idUser = this.getAkunModel().getId();
		technologyModel.setModifiedBy(idUser);
		technologyModel.setModifiedOn(new Date());
		technologyModel.setName(request.getParameter("name"));
		technologyModel.setNotes(request.getParameter("note"));
		
		this.technologyService.edit(technologyModel);
		
		
		
		//TechTrainer instance
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		List<TechnologyTrainerModel> technologyTrainerModelList = new ArrayList<TechnologyTrainerModel>();
		TrainerModel trainerModel;
		TechnologyTrainerModel technologyTrainerModel;
		
		for (int i = 0; i < trainerArray.size(); i++) {
			jsonObject = (JsonObject) trainerArray.get(i);
			trainerModel = new TrainerModel();
			Long idTrainer = jsonObject.get("id").getAsLong();
			trainerModel.setId(idTrainer);
			trainerModelList.add(trainerModel);
			
			technologyTrainerModel = new TechnologyTrainerModel();
			technologyTrainerModel.setTrainerModel(trainerModel);
//			technologyTrainerModel.setTechnologyModel(technologyModel);
			technologyTrainerModel.setIdTrainer(idTrainer);
			technologyTrainerModel.setIdTech(idTech);
			technologyTrainerModel.setCreatedBy(idUser);
			technologyTrainerModel.setCreatedOn(new Date());
			technologyTrainerModel.setIsDeleted(0);
			technologyTrainerModel = this.technologyTrainerService.create(technologyTrainerModel);
			technologyTrainerModelList.add(technologyTrainerModel);
		}
		
		String jsp = "technology/technology";
		return jsp;
	}
	
	
	@RequestMapping(value="technology/deleteTrainer/save")
	public String deleteSaveTrainer(HttpServletRequest request, Model model) {
		Long id = new Long(request.getParameter("idTech"));
		TechnologyTrainerModel technologyTrainerModel = new TechnologyTrainerModel();
		technologyTrainerModel = this.technologyTrainerService.deleteById(id);
		
		this.technologyTrainerService.delete(technologyTrainerModel);
		
		String jsp = "technology/editTechnology";
		return jsp;
	}
}
