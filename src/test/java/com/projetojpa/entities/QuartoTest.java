package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {
	
	private Quarto quarto;
	
	@BeforeEach
	void setUp() {
		quarto = new Quarto(1L, "10", "Quarto Solteiro");
	}

	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		quarto.setId(2L);
		
		assertEquals(2L,quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Num")
	void testNum() {
		quarto.setNum("15");
		
		assertEquals("15",quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Tipo")
	void testTipo() {
		quarto.setTipo("Quarto casal");
		
		assertEquals("Quarto casal",quarto.getTipo());
	}
	
	@Test
	@DisplayName("Tentando o construtor com todos os argumentos")
	void testConstructorAll() {
		
		Quarto novoQuarto = new Quarto(3L,"20", "Suíte presidencial");
		
		assertAll("novoQuarto",
				()-> assertEquals(3L, novoQuarto.getId()),
				()-> assertEquals("20", novoQuarto.getNum()),
				()-> assertEquals("Suíte presidencial", novoQuarto.getTipo()));
	}

}
