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
	private BiodataService biodataService ;
	
	
	/*Menu Monitoring*/
	@RequestMapping(value="monitoring")
	public String monitoring(Model model) {
		String jsp = "monitoring/monitoring";
		return jsp;
	}
	
	@RequestMapping(value="monitoring/list")
	public String listmonitoring(Model model) {
		List<MonitoringModel> monitoringModelList = new ArrayList<MonitoringModel>();
		monitoringModelList = this.monitoringService.searchAll();
		model.addAttribute("monitoringModelList", monitoringModelList);
		String jsp = "monitoring/list";
		return jsp;
	}
	
	@RequestMapping(value="monitoring/tambah")
	public String tambahmonitoring(Model model) {
		
		this.listbiodata(model);
		
		
		String jsp = "monitoring/tambah";
		return jsp;
	}
	
	private void listbiodata(Model model) {
		// TODO Auto-generated method stub
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}

	@RequestMapping(value="monitoring/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		Long testId = Long.valueOf(request.getParameter("testID"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date idleDate = sdf.parse(request.getParameter("idleDate"));
		
		MonitoringModel monitoringModel = new MonitoringModel();
		monitoringModel.setTestId(testId);
		monitoringModel.setIdleDate(idleDate);
		monitoringModel.setLastProject(request.getParameter("lastProject"));
		monitoringModel.setIdleReason(request.getParameter("idleReason"));
		monitoringModel.setIsDelete(0);
		
		this.monitoringService.create(monitoringModel);
		model.addAttribute("monitoringModel", monitoringModel);
		
		String jsp = "monitoring/monitoring";
		return jsp;
	}
}
