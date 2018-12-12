package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BatchModel;
import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.ClazzModel;
import com.spring.miniproject.service.BatchService;
import com.spring.miniproject.service.BiodataService;
import com.spring.miniproject.service.ClazzService;

@Controller
public class ClazzController extends BaseController {
	
	@Autowired
	private ClazzService clazzService;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private BiodataService biodataService;
	
	@RequestMapping(value="clazz")
	public String homeClazz() {
		String jsp = "clazz/clazz";
		return jsp;
	}
	
	@RequestMapping(value="clazz/listClazz")
	public String listClazz(Model model) {
		List<ClazzModel> clazzModelList = new ArrayList<ClazzModel>();
		clazzModelList = this.clazzService.showAll();
		model.addAttribute("clazzModelList", clazzModelList);
		
		this.listBatch(model);
		this.listBiodata(model);
		
		String jsp = "clazz/listClazz";
		return jsp;
	}
	
	@RequestMapping(value="clazz/deleteParticipant")
	public String deleteParticipant(HttpServletRequest request, Model model) {
		Long idClazz = new Long(request.getParameter("idClazz"));
		
		ClazzModel clazzModel = new ClazzModel();
		clazzModel = this.clazzService.searchById(idClazz);
		model.addAttribute("clazzModel", clazzModel);
		
		this.listBatch(model);
		this.listClazz(model);
		this.listBiodata(model);
		
		String jsp = "clazz/deleteParticipant";
		return jsp;
	}
	
	@RequestMapping(value="clazz/deleteParticipant/save")
	public String deleteSaveParticipant(HttpServletRequest request) {
		Long idClazz = new Long(request.getParameter("idClazz"));
		Long idBatch = new Long(request.getParameter("batchId"));
		Long idName = new Long (request.getParameter("biodataId"));
		Long idUser = this.getAkunModel().getId();
		
		ClazzModel clazzModel = new ClazzModel();
		clazzModel.setClazzId(idClazz);
		clazzModel.setBatchId(idBatch);
		clazzModel.setBiodataId(idName);
		clazzModel.setCreatedBy(idUser);
		clazzModel.setCreatedOn(new Date());
		clazzModel.setIsDeleted(1);
		
		this.clazzService.delete(clazzModel);
		
		String jsp = "clazz/clazz";
		return jsp;
	}
	
	@RequestMapping(value="clazz/searchClazz/batch")
	public String searchClazz(HttpServletRequest request, Model model) {
		String search = request.getParameter("batch");
		
		List<ClazzModel> clazzModelList = new ArrayList<ClazzModel>();
		clazzModelList = this.clazzService.searchByName(search);
		model.addAttribute("clazzModelList", clazzModelList);
		
		String jsp = "clazz/listClazz";
		return jsp;
	}
	
	//LIST
	
	public void listBatch(Model model) {
		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
		batchModelList = this.batchService.showAll();
		model.addAttribute("batchModelList", batchModelList);
	}
	
	public void listBiodata(Model model) {
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}
}
