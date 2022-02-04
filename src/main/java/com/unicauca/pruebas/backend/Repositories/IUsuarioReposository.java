package com.unicauca.pruebas.backend.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.pruebas.backend.Entities.Usuario;

public interface IUsuarioReposository extends CrudRepository<Usuario, Long> {

	public Usuario findByNombreUsuario(String nombreUsuario); 
}
