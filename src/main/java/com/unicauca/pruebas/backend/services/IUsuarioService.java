package com.unicauca.pruebas.backend.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.pruebas.backend.Entities.Usuario;
import com.unicauca.pruebas.backend.response.UsuarioResponseRest;

public interface IUsuarioService {
	
	public ResponseEntity<UsuarioResponseRest> guardarUsuario(Usuario usuario); 
}
