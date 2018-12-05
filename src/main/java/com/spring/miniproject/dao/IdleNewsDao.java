package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.IdleNewsModel;

public interface IdleNewsDao {
	public void create(IdleNewsModel idlenewsModel);
	public List<IdleNewsModel> searchAll();
	public List<IdleNewsModel> searchByLikeName(String name);
}
