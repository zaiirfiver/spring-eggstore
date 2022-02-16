package com.zmpa.eggstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmpa.eggstore.model.DetalleOrden;
import com.zmpa.eggstore.repository.IDetalleOrdenDao;

@Service
public class DetalleOrdenServiceImpl implements IDetalleOrdenService{

	@Autowired
	private IDetalleOrdenDao detalleOrdenDao;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenDao.save(detalleOrden);
	}
	
	

}
