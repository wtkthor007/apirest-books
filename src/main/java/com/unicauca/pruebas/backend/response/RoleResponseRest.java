package com.unicauca.pruebas.backend.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseRest extends ResponseRest{
	
	private RoleResponse roleResponse;
	
	public RoleResponseRest() {
		this.roleResponse = new RoleResponse();
	}

}
