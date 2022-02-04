package com.unicauca.pruebas.backend.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7488361176984607884L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String nombre;

}
