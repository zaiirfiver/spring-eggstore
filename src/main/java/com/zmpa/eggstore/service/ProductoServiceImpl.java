package com.zmpa.eggstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmpa.eggstore.model.Producto;
import com.zmpa.eggstore.repository.IProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public Producto save(Producto producto) {					//metodo save para guardar producto
		return productoDao.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {					//metodo get para obtener el producto
		return productoDao.findById(id);
	}

	@Override
	public void update(Producto producto) {						//metodo update para actualizar el producto
		productoDao.save(producto);
	}

	@Override
	public void delete(Integer id) {							//metodo delete para eliminar el producto
		productoDao.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		return productoDao.findAll();
	}
	
}
