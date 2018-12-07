package com.spring.miniproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.MonitoringModel;
import com.spring.miniproject.service.BiodataService;
import com.spring.miniproject.service.MonitoringService;

@Controller
public class MonitoringController {

	@Autowired
	private MonitoringService monitoringService;

	@Autowired
	private BiodataService biodataService;

	/* Menu Monitoring */
	@RequestMapping(value = "monitoring")
	public String monitoring(Model model) {
		String jsp = "monitoring/monitoring";
		return jsp;
	}

	/* List Monitoring */
	@RequestMapping(value = "monitoring/list")
	public String listmonitoring(Model model) {
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = this.monitoringService.searchAll();
		model.addAttribute("monitoringModelList", monitoringModelList);
		String jsp = "monitoring/list";
		return jsp;
	}

	/* Popup Add Monitoring */
	@RequestMapping(value = "monitoring/tambah")
	public String tambahmonitoring(Model model) {

		this.listbiodata(model);

		String jsp = "monitoring/tambah";
		return jsp;
	}

	/* List Biodata for Name Dropdown */
	private void listbiodata(Model model) {
		// TODO Auto-generated method stub
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}

	/* Create Monitoring */
	@RequestMapping(value = "monitoring/create")
	public String create(HttpServletRequest request, Model model) throws Exception {

		Long id = Long.valueOf(request.getParameter("testId"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date idleDate = sdf.parse(request.getParameter("idleDate"));

		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel.setTestId(id);
		monitoringModel.setIdleDate(idleDate);
		monitoringModel.setLastProject(request.getParameter("lastProject"));
		monitoringModel.setIdleReason(request.getParameter("idleReason"));

		this.monitoringService.create(monitoringModel);
		model.addAttribute("monitoringModel", monitoringModel);

		String jsp = "monitoring/monitoring";
		return jsp;
	}

	/* Popup Edit Monitoring */
	@RequestMapping(value = "monitoring/edit")
	public String monitoringEdit(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel = this.monitoringService.searchById(id);
		model.addAttribute("monitoringModel", monitoringModel);

		String jsp = "monitoring/edit";
		return jsp;
	}

	/* Edit Monitoring */
	@RequestMapping(value = "monitoring/edit/save")
	public String monitoringEditSave(HttpServletRequest request, Model model) throws Exception {
		Long id = Long.valueOf(request.getParameter("id"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date idleDate = sdf.parse(request.getParameter("idleDate"));

		MonitoringModel monitoringModelDB = new MonitoringModel();
		monitoringModelDB = this.monitoringService.searchById(id);

		monitoringModelDB.setIdleDate(idleDate);
		monitoringModelDB.setLastProject(request.getParameter("lastProject"));
		monitoringModelDB.setIdleReason(request.getParameter("idleReason"));

		this.monitoringService.update(monitoringModelDB);
		model.addAttribute("monitoringModelDB", monitoringModelDB);

		String jsp = "monitoring/monitoring";
		return jsp;
	}

	/* Popup Placement Monitoring */
	@RequestMapping(value = "monitoring/placement")
	public String monitoringPlacement(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel = this.monitoringService.searchById(id);
		model.addAttribute("monitoringModel", monitoringModel);

		String jsp = "monitoring/placement";
		return jsp;
	}

	/* Placement Monitoring */
	@RequestMapping(value = "monitoring/placement/save")
	public String placement(HttpServletRequest request, Model model) throws Exception {

		Long id = Long.valueOf(request.getParameter("id"));

		MonitoringModel monitoringModelDB = new MonitoringModel();
		monitoringModelDB = this.monitoringService.searchById(id);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date placementDate = sdf.parse(request.getParameter("placementDate"));

		monitoringModelDB.setPlacementDate(placementDate);
		monitoringModelDB.setPlacementAt(request.getParameter("placementAt"));
		monitoringModelDB.setNotes(request.getParameter("notes"));

		this.monitoringService.placement(monitoringModelDB);
		model.addAttribute("monitoringModelDB", monitoringModelDB);

		String jsp = "monitoring/monitoring";
		return jsp;
	}

	/* Popup Delete Monitoring */
	@RequestMapping(value = "monitoring/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		
		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel = this.monitoringService.searchById(Long.parseLong(id));
		model.addAttribute("monitoringModel", monitoringModel);
		
		String jsp = "monitoring/delete";
		return jsp;
	}

	/* Delete Monitoring */
	@RequestMapping(value = "monitoring/delete/save")
	public String delete(HttpServletRequest request) {
		
		Long id = Long.valueOf(request.getParameter("id"));

		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel = this.monitoringService.searchById(id);
		this.monitoringService.delete(monitoringModel);

		String jsp = "monitoring/monitoring";
		return jsp;
	}
	
	@RequestMapping(value="monitoring/search/name")
	public String monitoringSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = this.monitoringService.searchByLikeName(name);
		model.addAttribute("monitoringModelList", monitoringModelList);
		String jsp = "monitoring/list";
		return jsp;
	}
}
