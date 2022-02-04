package com.unicauca.pruebas.backend.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.pruebas.backend.Entities.Categoria;
import com.unicauca.pruebas.backend.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> guardarCategoria(Categoria categoria);
	public ResponseEntity<CategoriaResponseRest> listarCategorias();
	public ResponseEntity<CategoriaResponseRest> buscarCategoriaPorId(Long idCategoria);
}
