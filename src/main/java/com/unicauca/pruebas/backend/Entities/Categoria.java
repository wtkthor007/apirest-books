package com.unicauca.pruebas.backend.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Categoria implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7359833353170909506L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;

}
