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

import com.unicauca.pruebas.backend.Entities.Role;
import com.unicauca.pruebas.backend.Repositories.IRoleRepository;
import com.unicauca.pruebas.backend.response.RoleResponseRest;

@Service
public class RoleServiceImpl implements IRoleService {

	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Override
	@Transactional
	public ResponseEntity<RoleResponseRest> GuardarRole(Role role) {
		log.info("Inicio metodo GuardarRole");
		RoleResponseRest response = new RoleResponseRest();
		List<Role> roles = new ArrayList<Role>();
		try {
			System.out.println("ANTES DE GUARDAR ROLE");
			Role roleGuardado = this.roleRepository.save(role);
			System.out.println("ANTES DE GUARDAR ROLE");
			if(roleGuardado != null) {
				roles.add(roleGuardado);
				response.getRoleResponse().setRoles(roles);
				response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			}else {
				log.error("Error al almacenar role");
				response.setMetadata("Respuesta nok", "-1", "No se pudo almacenar el role");
				return new ResponseEntity<RoleResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			log.error("Error al almacenar role",e.getMessage());
			e.getStackTrace();
			response.setMetadata("Respuesta nok", "-1", "Error al almacenar role");
		}
		return new ResponseEntity<RoleResponseRest>(response, HttpStatus.OK);
	}

}
