package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.IdleNewsModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.IdleNewsService;
import com.spring.miniproject.service.OfficeService;
import com.spring.miniproject.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private OfficeService officeService;
	
	@RequestMapping(value="office/room")
	public String tambahroom(Model model) {
		this.listDataOffice(model);
		String jsp = "office/room";
		return jsp;
	}	
	
	@RequestMapping(value="office/create_room")
	public String create(HttpServletRequest request, Model model) throws Exception{
		RoomModel roomModel = new RoomModel();
		roomModel.setCode(request.getParameter("code"));		
		roomModel.setName(request.getParameter("name"));
		roomModel.setCapacity(Integer.valueOf(request.getParameter("capacity")));
		roomModel.setProjector(Integer.valueOf(request.getParameter("projector")));
		roomModel.setNotes(request.getParameter("notes"));
		roomModel.setIdOffice(Long.valueOf(request.getParameter("idOffice")));
		roomModel.setIsActive(1);
		
		this.roomService.create(roomModel);
		model.addAttribute("roomModel", roomModel);
		
		String jsp = "office/office";
		return jsp;
	}
	
	@RequestMapping(value="office/list_room")
	public String listroom(Model model) {
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = this.roomService.searchAll();
		model.addAttribute("roomModelList", roomModelList);
		String jsp = "office/list_room";
		return jsp;
	}
	@SuppressWarnings("unused")
	private void listDataOffice(Model model) {
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchAll();
		model.addAttribute("officeModelList", officeModelList);
	}
	
	@RequestMapping (value="office/delete_room")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		RoomModel roomModel = new RoomModel();
		roomModel = this.roomService.searchById(Long.parseLong(id));
		model.addAttribute("roomModel", roomModel);
		String jsp = "office/delete_room";
		return jsp;
	}
	
	@RequestMapping (value="office/delete_room/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		RoomModel roomModel = new RoomModel();
		roomModel = this.roomService.searchById(Long.parseLong(id));
		this.roomService.delete(roomModel);
		
		String jsp = "office/tambah";
		return jsp;
	}
}
