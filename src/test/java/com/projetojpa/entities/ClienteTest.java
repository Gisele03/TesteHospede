package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		cliente = new Cliente(1L, "Yasmin", "111111111", "2222222", "1111");
	}

	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		cliente.setId(2L);
		
		assertEquals(2L,cliente.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Nome")
	void testNome() {
		cliente.setNome("Yasmin");
		
		assertEquals("Yasmin",cliente.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Telefone")
	void testTelefone() {
		cliente.setTelefone("111111111");
		
		assertEquals("111111111",cliente.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Cpf")
	void testCpf() {
		cliente.setCpf("2222222");
		
		assertEquals("2222222",cliente.getCpf());
	}
	
	@Test
	@DisplayName("Tentando o construtor com todos os argumentos")
	void testConstructorAll() {
		
		Cliente novoCliente = new Cliente(3L,"Beatriz", "12121212", "1111111", "222222");
		
		assertAll("novoCliente",
				()-> assertEquals(3L, novoCliente.getId()),
				()-> assertEquals("Beatriz", novoCliente.getNome()),
				()-> assertEquals("12121212", novoCliente.getTelefone()),
				()-> assertEquals("1111111", novoCliente.getCpf()),
		        ()-> assertEquals("222222", novoCliente.getRg()));
	}

}