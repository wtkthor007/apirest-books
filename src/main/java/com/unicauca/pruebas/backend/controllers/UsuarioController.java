package com.unicauca.pruebas.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.pruebas.backend.Entities.Usuario;
import com.unicauca.pruebas.backend.response.UsuarioResponseRest;
import com.unicauca.pruebas.backend.services.IUsuarioService;

@RestController
@RequestMapping("/v1")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceBDUsuario;
	
	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioResponseRest> guardarUsuario(@RequestBody Usuario usuario){
		ResponseEntity<UsuarioResponseRest> response = serviceBDUsuario.guardarUsuario(usuario);
		return response;
	}
}
