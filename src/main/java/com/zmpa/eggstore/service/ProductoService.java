package com.zmpa.eggstore.service;

import java.util.Optional;

import com.zmpa.eggstore.model.Producto;

public interface ProductoService {
	public Producto save(Producto producto);
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
}
