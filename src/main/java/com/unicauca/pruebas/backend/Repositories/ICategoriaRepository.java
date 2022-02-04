package com.unicauca.pruebas.backend.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.pruebas.backend.Entities.Categoria;

public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {

}
