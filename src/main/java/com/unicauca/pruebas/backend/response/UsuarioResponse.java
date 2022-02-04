package com.unicauca.pruebas.backend.response;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.pruebas.backend.Entities.Usuario;

import lombok.Data;

@Data
public class UsuarioResponse {
	
	private List<Usuario> usuarios;
	
	public UsuarioResponse() {
		this.usuarios = new ArrayList<Usuario>();
	}
}
