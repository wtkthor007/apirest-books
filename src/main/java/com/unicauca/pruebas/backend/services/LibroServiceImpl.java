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

import com.unicauca.pruebas.backend.Entities.Libro;
import com.unicauca.pruebas.backend.Repositories.ILibroRepository;
import com.unicauca.pruebas.backend.response.LibroResponseRest;

@Service
public class LibroServiceImpl implements ILibroService{
	private static final Logger log = LoggerFactory.getLogger(LibroServiceImpl.class);
	
	@Autowired
	private ILibroRepository libroRespository;

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> listarLibros() {
		log.info("Inicio metodo listarLibros()");
		LibroResponseRest response = new LibroResponseRest();
		try {
			List<Libro> libros = (List<Libro>) libroRespository.findAll();
			if(libros.isEmpty()) {
				log.error("Error al listar libros");
				response.setMetadata("Respuesta ok", "200", "NO hay libros registrados");
				return new ResponseEntity<LibroResponseRest>(response, HttpStatus.NO_CONTENT);
			}
			response.getLibroResponse().setLibros(libros);
			response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
		}catch(Exception e) {
			log.error("Error a listar libros",e.getMessage());
			e.getStackTrace();
			response.setMetadata("Respuesta nok", "-1", "Error al listar libros");
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> buscarLibroPorId(Long idLibro) {
		log.info("Inicio metodo buscarLibroPorId()");
		LibroResponseRest response = new LibroResponseRest();
		List<Libro> libros = new ArrayList<Libro>();
		try {
			Optional<Libro> libroOptional = this.libroRespository.findById(idLibro);
			if(libroOptional.isPresent()) {
				libros.add(libroOptional.get());
				response.getLibroResponse().setLibros(libros);
				response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
			}else {
				log.error("Error al consultar libro");
				response.setMetadata("Respuesta nok", "-1", "libro no encontrada");
				return new ResponseEntity<LibroResponseRest>(response, HttpStatus.NO_CONTENT);
			}
			
		}catch(Exception e) {
			log.error("Error al consultar libro",e.getMessage());
			response.setMetadata("Respuesta nok", "-1", "Error al consultar libro");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> guardarLibro(Libro libro) {
		log.info("Inicio metodo guardarLibro()");
		LibroResponseRest response = new LibroResponseRest();
		List<Libro> libros = new ArrayList<Libro>();
		try {
			Libro libroGuardado = this.libroRespository.save(libro);
			
			if(libroGuardado !=null) {
				
				libros.add(libroGuardado);
				response.getLibroResponse().setLibros(libros);
				response.setMetadata("Respuesta ok", "200", "Respuesta exitosa");
			}else {
				log.error("Error en guardar libro");
				response.setMetadata("Respuesta nok", "-1", "Libro no guardado");
				return new ResponseEntity<LibroResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception e) {
			log.error("Error al guardar libro");
			response.setMetadata("Respuesta nok", "-1", "Error al guardar libro");
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

}
