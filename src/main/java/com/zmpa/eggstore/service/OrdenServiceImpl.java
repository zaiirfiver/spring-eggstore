package com.zmpa.eggstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmpa.eggstore.model.Orden;
import com.zmpa.eggstore.repository.IOrdenDao;

@Service
public class OrdenServiceImpl implements IOrdenService{

	@Autowired
	private IOrdenDao ordenDao;
	
	@Override
	public Orden save(Orden orden) {
		return ordenDao.save(orden);
	}

}
