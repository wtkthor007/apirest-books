package com.unicauca.pruebas.backend.response;

import java.util.List;
import com.unicauca.pruebas.backend.Entities.Libro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroResponse {
	private List<Libro> libros;
}
