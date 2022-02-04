package com.unicauca.pruebas.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.pruebas.backend.Entities.Libro;

@Repository
public interface ILibroRepository extends CrudRepository<Libro,Long> {

}
