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

import com.projetojpa.entities.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		Veiculo veiculo1 = new Veiculo(null, "Honda", "Civic", "2009", "Cinza");

		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);

		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
	}

	@DisplayName("Testando Get para todos Veiculos")
	@Test
	void testGetAllRepository() {

		Veiculo veiculo1 = new Veiculo(null, "Honda", "Civic", "2009", "Cinza");

		Veiculo veiculo2 = new Veiculo(null, "BMW", "X1", "2010", "Branco");

		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);

		List<Veiculo> veiculoList = veiculoRepository.findAll();

		assertNotNull(veiculoList);
		assertEquals(2, veiculoList.size());

	}

	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {

		Veiculo veiculo1 = new Veiculo(null, "Honda", "Civic", "2009", "Cinza");

		veiculoRepository.save(veiculo1);

		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();

		assertNotNull(saveVeiculo);
		assertEquals(veiculo1.getId(), saveVeiculo.getId());
	}

	@DisplayName("Testando o Update")
	@Test
	void testUpdateCliente() {
		Veiculo veiculo1 = new Veiculo(null, "BMW", "X1", "2010", "Branco");

		veiculoRepository.save(veiculo1);

		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("Honda");
		veiculo1.setModelo("HB20");

		Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);

		assertNotNull(updateVeiculo);
		assertEquals("Honda", updateVeiculo.getMarca());
		assertEquals("HB20", updateVeiculo.getModelo());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteVeiculo() {

		Veiculo veiculo1 = new Veiculo(null, "BMW", "X1", "2010", "Branco");

		veiculoRepository.save(veiculo1);

		veiculoRepository.deleteById(veiculo1.getId());

		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo1.getId());

		assertTrue(veiculoOptional.isEmpty());

	}
}