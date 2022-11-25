package com.demo.udemy.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.udemy.project.entities.FacturaEntity;
import com.demo.udemy.project.entities.ProductoEntity;
import com.demo.udemy.project.services.FacturaService;
import com.demo.udemy.project.services.ProductoService;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private ProductoService productoService;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/facturas/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public FacturaEntity show(@PathVariable Long id) {
		return facturaService.findById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		facturaService.delete(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/facturas")
	@ResponseStatus(code = HttpStatus.CREATED)
	public FacturaEntity crear(@RequestBody FacturaEntity factura) {
		return facturaService.save(factura);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("facturas/filtrar-productos/{term}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductoEntity> filtrarProductos(@PathVariable String term){
		return productoService.findByNombre(term);
	}
	
}
