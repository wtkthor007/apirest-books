package com.unicauca.pruebas.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.pruebas.backend.Entities.Libro;
import com.unicauca.pruebas.backend.response.LibroResponseRest;
import com.unicauca.pruebas.backend.services.ILibroService;

@RestController
@RequestMapping("/v1")
public class LibroController {
	
	@Autowired
	private ILibroService servicioBDLibro;
	
	@GetMapping("/libros")
	public ResponseEntity<LibroResponseRest> listarLibros(){
		ResponseEntity<LibroResponseRest> response = servicioBDLibro.listarLibros();
		return response;
	}
	
	@GetMapping("/libros/{idLibro}")
	public ResponseEntity<LibroResponseRest> buscarLibroPorId(@PathVariable Long idLibro){
		ResponseEntity<LibroResponseRest> response = servicioBDLibro.buscarLibroPorId(idLibro);
		return response;
	}
	
	@PostMapping("/libros")
	public ResponseEntity<LibroResponseRest> guardarLibro(@RequestBody Libro libro){
		ResponseEntity<LibroResponseRest> response = servicioBDLibro.guardarLibro(libro);
		return response;
	}

}
