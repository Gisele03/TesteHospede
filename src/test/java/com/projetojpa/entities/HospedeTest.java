package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {
	
	private Hospede hospede;
	
	@BeforeEach
	void setUp() {
		hospede = new Hospede(1L, "Julia Maria", "julia@gmail.com", "(00)0000-0000");
	}

	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		hospede.setId(2L);
		
		assertEquals(2L,hospede.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Nome")
	void testNome() {
		hospede.setNome("Gisele");
		
		assertEquals("Gisele",hospede.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Email")
	void testEmail() {
		hospede.setEmail("gi@email.com");
		
		assertEquals("gi@email.com",hospede.getEmail());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Telefone")
	void testTelefone() {
		hospede.setTelefone("1111111");
		
		assertEquals("1111111",hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Tentando o construtor com todos os argumentos")
	void testConstructorAll() {
		
		Hospede novoHospede = new Hospede(3L,"Beatriz", "bia@gmail.com", "1212");
		
		assertAll("novoHospede",
				()-> assertEquals(3L, novoHospede.getId()),
				()-> assertEquals("Beatriz", novoHospede.getNome()),
				()-> assertEquals("bia@gmail.com", novoHospede.getEmail()),
				()-> assertEquals("1212", novoHospede.getTelefone()));
	}

}
