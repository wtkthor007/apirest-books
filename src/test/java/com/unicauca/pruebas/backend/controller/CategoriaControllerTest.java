package com.unicauca.pruebas.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.unicauca.pruebas.backend.Entities.Categoria;
import com.unicauca.pruebas.backend.controllers.CategoriaController;
import com.unicauca.pruebas.backend.response.CategoriaResponseRest;
import com.unicauca.pruebas.backend.services.ICategoriaService;

public class CategoriaControllerTest {

	@InjectMocks
	private CategoriaController categoriaController;
	
	@Mock
	private ICategoriaService servicioBDCategoria;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearCategoriaTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Categoria categoria = Categoria.builder().id(Long.valueOf(1))
				.nombre("cat1").descripcion("Descripcion1").build();
		when(servicioBDCategoria.guardarCategoria(any(Categoria.class))).thenReturn(new ResponseEntity<CategoriaResponseRest>(HttpStatus.OK));
		ResponseEntity<CategoriaResponseRest> respuesta = servicioBDCategoria.guardarCategoria(categoria);
		assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
	}

}
