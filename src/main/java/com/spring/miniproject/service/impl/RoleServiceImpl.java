package com.spring.miniproject.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.RoleDao;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public void create(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.create(roleModel);
	}

	@Override
	public List<RoleModel> select() {
		// TODO Auto-generated method stub
		return this.roleDao.select();
	}

	@Override
	public RoleModel searchById(Long id) {
		// TODO Auto-generated method stub
		return this.roleDao.searchById(id);
	}

	@Override
	public void update(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.update(roleModel);
	}

	@Override
	public List<RoleModel> searchByLikeName(String name) {
		// TODO Auto-generated method stub
		return this.roleDao.searchByLikeName(name);
	}

	@Override
	public void deactivate(RoleModel roleModel) {
		// TODO Auto-generated method stub
		this.roleDao.deactivate(roleModel);
	}

}
