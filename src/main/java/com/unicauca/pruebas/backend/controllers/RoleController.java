package com.unicauca.pruebas.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.pruebas.backend.Entities.Role;
import com.unicauca.pruebas.backend.response.RoleResponseRest;
import com.unicauca.pruebas.backend.services.IRoleService;

@RestController
@RequestMapping("/v1")
public class RoleController {

	@Autowired
	private IRoleService serviceBDRole;
	
	@PostMapping("/roles")
	public ResponseEntity<RoleResponseRest> guardarRole(@RequestBody Role role){
		ResponseEntity<RoleResponseRest> response = this.serviceBDRole.GuardarRole(role);
		return response;
	}
}
