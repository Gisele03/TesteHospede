package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MedicamentoTest {
	
	private Medicamento medicamento;
	
	@BeforeEach
	void setUp() {
		medicamento = new Medicamento(1L, "Advil", "Usar a cada dois dias", "10/09/24");
	}

	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		medicamento.setId(2L);
		
		assertEquals(2L,medicamento.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Nome")
	void testNome() {
		medicamento.setNome("Rivotril");
		
		assertEquals("Rivotril",medicamento.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Bula")
	void testBula() {
		medicamento.setBula("Usar a cada 20 dias");
		
		assertEquals("Usar a cada 20 dias",medicamento.getBula());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo dataValidade")
	void testdataValidade() {
		medicamento.setDataValidade("23/11/24");
		
		assertEquals("23/11/24",medicamento.getDataValidade());
	}
	
	@Test
	@DisplayName("Tentando o construtor com todos os argumentos")
	void testConstructorAll() {
		
		Medicamento novoMedicamento = new Medicamento(3L,"Buscopan", "Uso oral", "12/12/24");
		
		assertAll("novoMedicamento",
				()-> assertEquals(3L, novoMedicamento.getId()),
				()-> assertEquals("Buscopan", novoMedicamento.getNome()),
				()-> assertEquals("Uso oral", novoMedicamento.getBula()),
				()-> assertEquals("12/12/24", novoMedicamento.getDataValidade()));
	}

}
