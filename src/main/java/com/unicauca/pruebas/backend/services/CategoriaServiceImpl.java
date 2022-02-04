package com.unicauca.pruebas.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.pruebas.backend.Entities.Categoria;
import com.unicauca.pruebas.backend.Repositories.ICategoriaRepository;
import com.unicauca.pruebas.backend.response.CategoriaResponseRest;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	@Autowired
	private ICategoriaRepository categoriaRepostory;

	@Override
	@Transactional()
	public ResponseEntity<CategoriaResponseRest> listarCategorias() {
		log.info("Inicio metodo listarCategorias()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		try {
			List<Categoria> categorias = (List<Categoria>) categoriaRepostory.findAll();
			if(categorias.isEmpty()){
				log.error("NO existen categorias registradas");
				response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NO_CONTENT);
			}
			response.getCategoriaResponse().setCategorias(categorias);
			response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
		}catch(Exception e) {
			log.error("Error al listar las categorias",e.getMessage());
			e.getStackTrace();
			response.setMetadata("Respuesta nok", "-1", "Error al consultar las categorias");
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> buscarCategoriaPorId(Long idCategoria) {
		log.info("Inicio metodo buscarCategoriaPorId()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> categorias = new ArrayList<>();
		try {
			Optional<Categoria> categoriaOptional = this.categoriaRepostory.findById(idCategoria);
			if(categoriaOptional.isPresent()){
				categorias.add(categoriaOptional.get());
				response.getCategoriaResponse().setCategorias(categorias);
				response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
			}else {
				log.error("Error en consultar categoria");
				response.setMetadata("Respuesta nok", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			log.error("Error al consultar categoria",e.getMessage());
			e.getStackTrace();
			response.setMetadata("Respuesta nok", "-1", "Error al consultar categoria");
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategoriaResponseRest> guardarCategoria(Categoria categoria) {
		log.info("Inicio metodo guardarCategoria()");
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> categorias =new ArrayList<>();
		try {
			Categoria categoriaGuardada = this.categoriaRepostory.save(categoria);
			if(categoriaGuardada!=null) {
				categorias.add(categoriaGuardada);
				response.getCategoriaResponse().setCategorias(categorias);
				response.setMetadata("Respuesta ok", "201", "Respuesta exitosa");
			}else {
				log.error("Error al guardar categoria");
				response.setMetadata("Respuesta nok","400", "No es posible almacenar la categoria");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			log.error("Error al consultar categoria");
			response.setMetadata("Respuesta nok", "500", "Error al consultar categoria");
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

}
