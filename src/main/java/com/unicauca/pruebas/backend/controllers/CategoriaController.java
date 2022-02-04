package com.unicauca.pruebas.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.pruebas.backend.Entities.Categoria;
import com.unicauca.pruebas.backend.response.CategoriaResponseRest;
import com.unicauca.pruebas.backend.services.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
@RequestMapping("/v1")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService servicioBDCategoria;

	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> listarCategorias(){
		ResponseEntity<CategoriaResponseRest> response = servicioBDCategoria.listarCategorias();
		return response;
	}
	
	@GetMapping("/categorias/{idCategoria}")
	public ResponseEntity<CategoriaResponseRest> bucarCategoriaPorId(@PathVariable Long idCategoria){
		ResponseEntity<CategoriaResponseRest> response = servicioBDCategoria.buscarCategoriaPorId(idCategoria);
		return response;
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> guardarCategoria(@RequestBody Categoria categoria){
		ResponseEntity<CategoriaResponseRest> response = this.servicioBDCategoria.guardarCategoria(categoria);
		return response;
	}
}
