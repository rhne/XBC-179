package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.RoomDao;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.service.RoomService;


@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public RoomModel create(RoomModel roomModel) {
		// TODO Auto-generated method stub
		return this.roomDao.create(roomModel);
	}
	
	public List<RoomModel> searchAll() {
		// TODO Auto-generated method stub
		return this.roomDao.searchAll();
	}
	
	@Override
	public List<RoomModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.roomDao.searchByLikeName(name);
	}
	
	@Override
	public RoomModel searchById(Long id) {
		return this.roomDao.searchById(id);
	}
	
	@Override
	public void delete(RoomModel roomModel) {
		this.roomDao.delete(roomModel);
	}

}
