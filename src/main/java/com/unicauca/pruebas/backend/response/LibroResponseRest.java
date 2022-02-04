package com.unicauca.pruebas.backend.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LibroResponseRest extends ResponseRest{
	private LibroResponse libroResponse;
	
	public LibroResponseRest() {
		this.libroResponse = new LibroResponse();
	}
	

}
