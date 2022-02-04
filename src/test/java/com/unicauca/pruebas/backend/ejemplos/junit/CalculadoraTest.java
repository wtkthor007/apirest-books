package com.unicauca.pruebas.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	Calculadora calculadora;
	
	@BeforeAll
	public static void primero() {
		System.out.println("Primero");
	}
	
	@AfterAll
	public static void ultimo() {
		System.out.println("Ultimo");
	}
	
	@BeforeEach
	public void instanciaObjeto() {
		calculadora = new Calculadora();
		System.out.println("@BeforeEach");
	}
	
	@AfterEach
	public void despuesTest() {
		System.out.println("@AfterEach");
	}
	
	@Test
	@DisplayName("Prueba que usa assertEqual")
	@Disabled("Este metodo no se ejecutara")
	public void calculadoraAssertEqualsTest() {
		assertEquals(4, calculadora.sumar(2, 2));
		assertEquals(4, calculadora.restar(8, 4));
		assertEquals(16, calculadora.multiplicar(4, 4));
		assertEquals(8, calculadora.dividir(16, 2));
		System.out.println("calculadoraAssertEqualsTest");
	}
	
	@Test
	public void calculadoraTrueFalse() {
		assertTrue(calculadora.sumar(2, 2)==4);
		assertTrue(calculadora.multiplicar(4, 2)==8);
		assertFalse(calculadora.restar(8, 5)==4);
		assertFalse(calculadora.dividir(16, 3)==8);
		System.out.println("calculadoraTrueFalse");
	}

}
