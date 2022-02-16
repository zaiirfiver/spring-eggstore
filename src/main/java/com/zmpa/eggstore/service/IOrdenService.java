package com.zmpa.eggstore.service;

import java.util.List;

import com.zmpa.eggstore.model.Orden;

public interface IOrdenService {
	List<Orden> findAll();
	Orden save (Orden orden);
}
