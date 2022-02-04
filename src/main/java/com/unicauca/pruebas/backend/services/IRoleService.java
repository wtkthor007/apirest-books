package com.unicauca.pruebas.backend.services;

import org.springframework.http.ResponseEntity;

import com.unicauca.pruebas.backend.Entities.Role;
import com.unicauca.pruebas.backend.response.RoleResponseRest;

public interface IRoleService {

	public ResponseEntity<RoleResponseRest> GuardarRole(Role role); 
}
