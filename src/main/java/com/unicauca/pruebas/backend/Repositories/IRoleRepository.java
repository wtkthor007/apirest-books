package com.unicauca.pruebas.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.pruebas.backend.Entities.Role;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Long> {

}
