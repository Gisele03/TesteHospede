package com.projetojpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.projetojpa.entities.Cliente;

@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		Cliente cliente1 = new Cliente(null, "Yasmin", "111111111", "2222222", "1111");

		Cliente saveCliente = clienteRepository.save(cliente1);

		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}

	@DisplayName("Testando Get para todos Hospedes")
	@Test
	void testGetAllRepository() {

		Cliente cliente1 = new Cliente(null, "Yasmin", "111111111", "2222222", "1111");

		Cliente cliente2 = new Cliente(null, "Beatriz", "12121212", "1111111", "222222");

		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);

		List<Cliente> clienteList = clienteRepository.findAll();

		assertNotNull(clienteList);
		assertEquals(2, clienteList.size());

	}

	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {

		Cliente cliente1 = new Cliente(null, "Yasmin", "111111111", "2222222", "1111");

		clienteRepository.save(cliente1);

		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();

		assertNotNull(saveCliente);
		assertEquals(cliente1.getId(), saveCliente.getId());
	}

	@DisplayName("Testando o Update")
	@Test
	void testUpdateCliente() {
		Cliente cliente1 = new Cliente(null, "Beatriz", "12121212", "1111111", "222222");

		clienteRepository.save(cliente1);

		Cliente saveCliente = clienteRepository.findById(cliente1.getId()).get();
		cliente1.setNome("Isabely");
		cliente1.setTelefone("111111");

		Cliente updateCliente = clienteRepository.save(saveCliente);

		assertNotNull(updateCliente);
		assertEquals("Isabely", updateCliente.getNome());
		assertEquals("111111", updateCliente.getTelefone());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteCliente() {

		Cliente cliente1 = new Cliente(null, "Beatriz", "12121212", "1111111", "222222");

		clienteRepository.save(cliente1);

		clienteRepository.deleteById(cliente1.getId());

		Optional<Cliente> clienteOptional = clienteRepository.findById(cliente1.getId());

		assertTrue(clienteOptional.isEmpty());

	}
}
