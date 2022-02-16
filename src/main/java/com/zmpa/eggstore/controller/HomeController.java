package com.zmpa.eggstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zmpa.eggstore.model.DetalleOrden;
import com.zmpa.eggstore.model.Orden;
import com.zmpa.eggstore.model.Producto;
import com.zmpa.eggstore.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final Logger log = LoggerFactory.getLogger(HomeController.class);			//imprime los resultados en la terminal
	
	@Autowired
	private ProductoService productoService;				//permite obtener todos los productos
	
	List<DetalleOrden> detalles= new ArrayList<DetalleOrden>();			//Almacena los detalles de la orden
	
	Orden orden = new Orden();										//datos de la orden
	
	@GetMapping("")
	public String index(Model model) {
		
		model.addAttribute("productos", productoService.findAll());
		
		return "usuario/index";
	}
	
	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("id enviado como parametro {}", id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoService.get(id);
		producto = productoOptional.get();
		
		model.addAttribute("producto", producto);
		
		return "usuario/productohome";
	}
	
	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal = 0;
		
		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		
		return "usuario/carrito";
	}
}
