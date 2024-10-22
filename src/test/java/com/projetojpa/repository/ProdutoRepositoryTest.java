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

import com.projetojpa.entities.Produto;

@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		Produto produto1 = new Produto(null, "Carro", "50.000");

		Produto saveProduto = produtoRepository.save(produto1);

		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Produtos")
	@Test
	void testGetAllRepository() {

		Produto produto1 = new Produto(null, "Carro", "50.000");

		Produto produto2 = new Produto(null, "Moto", "15.000");

		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		List<Produto> produtoList = produtoRepository.findAll();

		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());

	}

	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {

		Produto produto1 = new Produto(null, "Carro", "50.000");

		produtoRepository.save(produto1);

		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();

		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());
	}

	@DisplayName("Testando o Update")
	@Test
	void testUpdateProduto() {
		Produto produto1 = new Produto(null, "Moto", "15.000");

		produtoRepository.save(produto1);

		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Carro");
		produto1.setPreco("30.000");

		Produto updateProduto = produtoRepository.save(saveProduto);

		assertNotNull(updateProduto);
		assertEquals("Carro", updateProduto.getNome());
		assertEquals("30.000", updateProduto.getPreco());
	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteProduto() {

		Produto produto1 = new Produto(null, "Moto", "15.000");

		produtoRepository.save(produto1);

		produtoRepository.deleteById(produto1.getId());

		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());

		assertTrue(produtoOptional.isEmpty());

	}
}