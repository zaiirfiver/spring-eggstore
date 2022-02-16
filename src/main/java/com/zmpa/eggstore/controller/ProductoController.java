package com.zmpa.eggstore.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmpa.eggstore.model.Producto;
import com.zmpa.eggstore.model.Usuario;
import com.zmpa.eggstore.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER  = LoggerFactory.getLogger(ProductoController.class);			//Indica un mensaje en consola donde se encuentre un posible error o si se ejecutó correctamente 
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String show() {
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}
	
	@PostMapping("/save")
	public String save(Producto producto) { 
		LOGGER.info("Este es el objeto producto {}",producto);
		Usuario u= new Usuario(1, "", "", "", "", "", "", "");
		producto.setUsuario(u);
		
		productoService.save(producto);
		return "redirect:/productos";					//redirije a la vista show.html
	}

}
