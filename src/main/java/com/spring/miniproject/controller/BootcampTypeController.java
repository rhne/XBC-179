package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BootcampTypeModel;
import com.spring.miniproject.service.BootcampTypeService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class BootcampTypeController {

	@Autowired
	private BootcampTypeService bootcampTypeService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="bootcamp")
	public String homeBootcamp() {
		String jsp = "bootcamp/bootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/addBootcamp")
	public String addBootcamp() {
		String jsp = "bootcamp/addBootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/listBootcamp")
	public String listBootcamp(Model model) {
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = this.bootcampTypeService.showAll();
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
		
		String jsp = "bootcamp/listBootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/addBootcamp/save")
	public String addSavebootcamp(HttpServletRequest request, Model model) {
		Long idBootcamp = new Long(this.sequenceService.nextIdBootcamp());
		model.addAttribute("idBootcamp", idBootcamp);
		
		String name = request.getParameter("bootcampName");
		String notes = request.getParameter("bootcampNotes");
		Integer isActive = 1;
		
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel.setIdBootcamp(idBootcamp);
		bootcampTypeModel.setName(name);
		bootcampTypeModel.setNotes(notes);
		bootcampTypeModel.setActive(isActive);
		
		this.bootcampTypeService.create(bootcampTypeModel);
		
		
		String jsp = "bootcamp/bootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/editBootcamp")
	public String editbootcamp(HttpServletRequest request, Model model) {
		Long idBootcamp = new Long(request.getParameter("idEdit"));
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel = this.bootcampTypeService.searchById(idBootcamp);
		
		model.addAttribute("bootcampTypeModel", bootcampTypeModel);
		
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = this.bootcampTypeService.showAll();
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
		
		String jsp = "bootcamp/editBootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/editBootcamp/save")
	public String editSaveBootcamp(HttpServletRequest request) {
		Long idBootcamp = new Long(request.getParameter("idBootcamp"));
		String name = request.getParameter("bootcampName");
		String notes = request.getParameter("bootcampNotes");
		
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel = this.bootcampTypeService.searchById(idBootcamp);
		
		bootcampTypeModel.setIdBootcamp(idBootcamp);
		bootcampTypeModel.setName(name);
		bootcampTypeModel.setNotes(notes);
		bootcampTypeModel.setActive(1);
		
		this.bootcampTypeService.edit(bootcampTypeModel);
		
		String jsp = "bootcamp/bootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/searchBootcamp/name")
	public String searchBootcamp(HttpServletRequest request, Model model) {
		String name = request.getParameter("searchName");
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = this.bootcampTypeService.searchByName(name);
		
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
		
		String jsp = "bootcamp/listBootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/deactiveBootcamp")
	public String deactiveBootcamp(HttpServletRequest request, Model model) {
		Long idBootcamp = new Long(request.getParameter("idDeactive"));
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel = this.bootcampTypeService.searchById(idBootcamp);
		
		model.addAttribute("bootcampTypeModel", bootcampTypeModel);
		
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = this.bootcampTypeService.showAll();
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
		
		String jsp = "bootcamp/deactiveBootcamp";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp/deactiveBootcamp/save")
	public String deactiveSaveBootcamp(HttpServletRequest request, Model model) {
		Long idBootcamp = new Long(request.getParameter("idBootcamp"));
		String modifiedBy = request.getParameter("modifiedBy");
		
		Integer isActive = 0;
		
		BootcampTypeModel bootcampTypeModel = new BootcampTypeModel();
		bootcampTypeModel = this.bootcampTypeService.searchById(idBootcamp);
		
		bootcampTypeModel.setIdBootcamp(idBootcamp);
		bootcampTypeModel.setModifiedBy(modifiedBy);
		bootcampTypeModel.setActive(isActive);
		
		this.bootcampTypeService.edit(bootcampTypeModel);
		
		String jsp = "bootcamp/bootcamp";
		return jsp;
	}
}
