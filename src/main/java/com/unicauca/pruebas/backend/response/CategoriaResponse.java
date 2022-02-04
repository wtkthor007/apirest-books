package com.unicauca.pruebas.backend.response;

import java.util.List;

import com.unicauca.pruebas.backend.Entities.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
	private List<Categoria> categorias;
}
