package com.zmpa.eggstore.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zmpa.eggstore.model.Producto;
import com.zmpa.eggstore.model.Usuario;
import com.zmpa.eggstore.service.IUsuarioService;
import com.zmpa.eggstore.service.ProductoService;
import com.zmpa.eggstore.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER  = LoggerFactory.getLogger(ProductoController.class);			//Indica un mensaje en consola donde se encuentre un posible error o si se ejecutó correctamente 
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private UploadFileService upload;
	
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
	public String save(Producto producto, @RequestParam("img") MultipartFile file, HttpSession session) throws IOException { 
		LOGGER.info("Este es el objeto producto {}",producto);
		
		
		Usuario u= usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
		producto.setUsuario(u);
		
		
		//imagen
		if(producto.getId()==null) {										//cuando se crea un producto
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}else {
			
		}
		
		productoService.save(producto);
		return "redirect:/productos";									//redirije a la vista show.html
	}
	
	@GetMapping("/edit/{id}")											//direcciona a edit.html
	public String edit(@PathVariable Integer id, Model model){			//busca el registro del id mediante el mapeo 
		Producto producto = new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
		LOGGER.info("Producto buscado: {}", producto);
		model.addAttribute("producto", producto);
		
		return "productos/edit";
	}
	
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		Producto p = new Producto();
		p=productoService.get(producto.getId()).get();
		
		if (file.isEmpty()) {											//Define que si cambia un prodcuto pero no se cambia la imagen por lo tanto se conserva la misma imagen
			
			producto.setImagen(p.getImagen());
		}else {														//cuando se edita tambien la imagen
			
			if (!p.getImagen().equals("default.jpg")) {						//Eliminar cuando no sea la imagen por defecto
				upload.deleteImage(p.getImagen());
			}
			
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p = productoService.get(id).get();
		
		if (!p.getImagen().equals("default.jpg")) {						//Eliminar cuando no sea la imagen por defecto
			upload.deleteImage(p.getImagen());
		}
		
		productoService.delete(id);
		return "redirect:/productos";
	}
}
