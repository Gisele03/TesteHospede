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

import com.projetojpa.entities.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

	@Autowired
	private QuartoRepository quartoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		Quarto quarto1 = new Quarto(null, "300", "Quarto solteiro");

		Quarto saveQuarto = quartoRepository.save(quarto1);

		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Quartos")
	@Test
	void testGetAllRepository() {

		Quarto quarto1 = new Quarto(null, "300", "Quarto solteiro");

		Quarto quarto2 = new Quarto(null, "330", "Suíte");

		quartoRepository.save(quarto1);
		quartoRepository.save(quarto2);

		List<Quarto> quartoList = quartoRepository.findAll();

		assertNotNull(quartoList);
		assertEquals(2, quartoList.size());

	}

	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {

		Quarto quarto1 = new Quarto(null, "330", "Suíte");

		quartoRepository.save(quarto1);

		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();

		assertNotNull(saveQuarto);
		assertEquals(quarto1.getId(), saveQuarto.getId());
	}

	@DisplayName("Testando o Update")
	@Test
	void testUpdateQuarto() {
		Quarto quarto1 = new Quarto(null, "330", "Suíte");

		quartoRepository.save(quarto1);

		Quarto saveQuarto = quartoRepository.findById(quarto1.getId()).get();
		quarto1.setNum("350");
		quarto1.setTipo("Quarto casal");

		Quarto updateQuarto = quartoRepository.save(saveQuarto);

		assertNotNull(updateQuarto);
		assertEquals("350", updateQuarto.getNum());
		assertEquals("Quarto casal", updateQuarto.getTipo());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteQuarto() {

		Quarto quarto1 = new Quarto(null, "330", "Suíte");

		quartoRepository.save(quarto1);

		quartoRepository.deleteById(quarto1.getId());

		Optional<Quarto> quartoOptional = quartoRepository.findById(quarto1.getId());

		assertTrue(quartoOptional.isEmpty());

	}
}











