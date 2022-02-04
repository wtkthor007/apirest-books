package com.unicauca.pruebas.backend.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.pruebas.backend.Entities.Libro;
import com.unicauca.pruebas.backend.response.LibroResponseRest;


public interface ILibroService {
	public ResponseEntity<LibroResponseRest> listarLibros();
	public ResponseEntity<LibroResponseRest> buscarLibroPorId(Long idLibro);
	public ResponseEntity<LibroResponseRest> guardarLibro(Libro libro);

}
