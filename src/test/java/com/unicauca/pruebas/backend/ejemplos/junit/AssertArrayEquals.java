package com.unicauca.pruebas.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class AssertArrayEquals {

	@Test
	public void pruebaArregloIguales() {
		
		String[] arreglo1 = {"a","b"};
		String[] arreglo2 = {"a","b"};
		String[] arreglo3 = {"a","b","c"};
		
		assertArrayEquals(arreglo1, arreglo2);
		assertArrayEquals(arreglo1, arreglo3);
		//assertArrayEquals(arreglo2, arreglo3);
	}
}
