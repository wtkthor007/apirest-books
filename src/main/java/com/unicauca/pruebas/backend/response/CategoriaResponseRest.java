package com.unicauca.pruebas.backend.response;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CategoriaResponseRest extends ResponseRest{
	private CategoriaResponse categoriaResponse;

	public CategoriaResponseRest() {
		this.categoriaResponse = new CategoriaResponse();
	}
	
	
}
