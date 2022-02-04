package com.unicauca.pruebas.backend.response;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.pruebas.backend.Entities.Role;

import lombok.Data;

@Data
public class RoleResponse {
	private List<Role> roles;
	
	public RoleResponse() {
		this.roles = new ArrayList<Role>();
	}

}
