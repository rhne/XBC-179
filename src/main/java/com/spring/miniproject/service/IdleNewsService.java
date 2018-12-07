package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.IdleNewsModel;

public interface IdleNewsService {
	public void create(IdleNewsModel idlenewsModel);
	public List<IdleNewsModel> searchAll();
	public List<IdleNewsModel> searchByLikeName(String name);
	public IdleNewsModel searchById(Long id);
	public void delete(IdleNewsModel idlenewsModel);
	public void update(IdleNewsModel idlenewsModel);
	public void publish(IdleNewsModel idlenewsModel);
}
