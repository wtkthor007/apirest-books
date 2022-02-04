package com.unicauca.pruebas.backend.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseRest extends ResponseRest{

	private UsuarioResponse usuarioResponse;
	
	public UsuarioResponseRest() {
		this.usuarioResponse = new UsuarioResponse();
	}
}
