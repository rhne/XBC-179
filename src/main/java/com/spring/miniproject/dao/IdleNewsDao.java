package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.IdleNewsModel;
import com.spring.miniproject.model.OfficeModel;

public interface IdleNewsDao {
	public void create(IdleNewsModel idlenewsModel);
	public List<IdleNewsModel> searchAll();
	public List<IdleNewsModel> searchByLikeName(String name);
	public IdleNewsModel searchById(Long id);
	public void delete(IdleNewsModel idlenewsModel);
}
