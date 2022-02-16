package com.zmpa.eggstore.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String show(Model model) {									//lleva la información del backend al frontend
		model.addAttribute("productos", productoService.findAll());		//recibe la vista de productoService
		return "productos/show";										//muestra la vista de show.html
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
