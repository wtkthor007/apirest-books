package com.unicauca.pruebas.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.unicauca.pruebas.backend.Entities.Categoria;
import com.unicauca.pruebas.backend.Repositories.ICategoriaRepository;
import com.unicauca.pruebas.backend.response.CategoriaResponseRest;
import com.unicauca.pruebas.backend.services.CategoriaServiceImpl;

public class CategoriaServiceImplTest {
	
	@InjectMocks
	CategoriaServiceImpl categoriaServiceImpl;
	
	@Mock
	ICategoriaRepository categoriaRepostory;
	
	List<Categoria> categorias = new ArrayList<Categoria>();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		cargarCategorias();
	}
	
	@Test
	public void listarCategoriasTest() {
		when(categoriaRepostory.findAll()).thenReturn(categorias);
		ResponseEntity<CategoriaResponseRest> response = this.categoriaServiceImpl.listarCategorias();
		assertEquals(3, response.getBody().getCategoriaResponse().getCategorias());
		verify(categoriaRepostory,times(1)).findAll();
	}
	
	public void cargarCategorias() {
		Categoria categoria1 = Categoria.builder().id(Long.valueOf(1))
				.nombre("Cat1")
				.descripcion("Desc1")
				.build();
		
		Categoria categoria2 = Categoria.builder().id(Long.valueOf(1))
				.nombre("cat2")
				.descripcion("Desc2")
				.build();
		
		Categoria categoria3 = Categoria.builder().id(Long.valueOf(2))
				.nombre("cat3")
				.descripcion("Desc3")
				.build();
		
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
	}
}
