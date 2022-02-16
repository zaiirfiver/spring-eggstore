package com.zmpa.eggstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmpa.eggstore.model.Producto;
import com.zmpa.eggstore.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String index(Model model) {
		
		List<Producto> productos = productoService.findAll();				//Obtiene los productos mediante una peticion al index.html
		model.addAttribute("productos", productos);
		
		return "administrador/index";
	}
}
