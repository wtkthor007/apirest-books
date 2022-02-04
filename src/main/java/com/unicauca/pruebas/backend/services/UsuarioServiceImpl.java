package com.unicauca.pruebas.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.pruebas.backend.Entities.Usuario;
import com.unicauca.pruebas.backend.Repositories.IUsuarioReposository;
import com.unicauca.pruebas.backend.response.UsuarioResponseRest;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioReposository UsuarioRepository;
	
	@Override
	@Transactional()
	public ResponseEntity<UsuarioResponseRest> guardarUsuario(Usuario usuario) {
		log.info("Inicio metodo guardarUsuario()");
		UsuarioResponseRest response = new UsuarioResponseRest();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Usuario usuarioGuardado = this.UsuarioRepository.save(usuario);
			if(usuarioGuardado != null) {
				usuarios.add(usuarioGuardado);
				response.getUsuarioResponse().setUsuarios(usuarios);
				response.setMetadata("Respuesta ok","00", "Respuesta exitosa");
			}else {
				log.error("Error al guardar usuario");
				response.setMetadata("Respuesta nok", "-1", "No es posible almacenar el usuario");
				return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);
			}	
		}catch(Exception e) {
			log.error("Error al guardar usuario",e.getMessage());
			e.getStackTrace();
			response.setMetadata("Respuesta nok", "-1", "Error al guardar usuario");
			return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UsuarioResponseRest>(response, HttpStatus.OK);
	}

}
