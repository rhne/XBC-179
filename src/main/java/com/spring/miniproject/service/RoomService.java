package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.RoomModel;

public interface RoomService {
	public RoomModel create(RoomModel roomModel);
	public List<RoomModel> searchAll();
	public List<RoomModel> searchByLikeName(String name);
	public RoomModel searchById(Long id);
	public void delete(RoomModel roomModel);
	public List<RoomModel> showAll();
	public List<RoomModel> searchByIdOffice(Long id);
}
