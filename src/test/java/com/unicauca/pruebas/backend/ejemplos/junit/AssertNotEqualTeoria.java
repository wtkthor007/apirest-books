package com.unicauca.pruebas.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class AssertNotEqualTeoria {
	
	@Test
	public void miTest() {
		assertNotEquals(2, 1);
		//assertNotEquals(2, 2);
	}

}
