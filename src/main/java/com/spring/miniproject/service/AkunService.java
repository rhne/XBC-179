package com.spring.miniproject.service;

import java.util.List;  

import com.spring.miniproject.model.AkunModel;

public interface AkunService {
	public void create(AkunModel akunModel);
	public List<AkunModel> searchAll();
	public AkunModel searchById(Long id);
	public void update(AkunModel akunModelDB);
	public List<AkunModel> searchByLikeName(String name);
	public AkunModel searchByUsernamePassword(String username, String password);
	public void deactivate(AkunModel akunModel);
	public List<AkunModel> searchValidation(String name);
}
