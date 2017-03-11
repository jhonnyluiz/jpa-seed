package com.desenvolvimento.pos.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProdutoTest extends BaseCrudTest<Produto>{
	
	
	@Test
	public void deveSalvarProduto(){
		Produto produto = getNovoProduto();
		assertTrue("Não pode ter id definido", produto.isTransient());
		salvar(produto);
		assertNotNull("Deverá ter id definido", produto.getId());
	}
	
	@Test
	public void deveListarProdutos(){
		for (int i = 0; i < 10; i++) {
			salvar(getNovoProduto());
		}
		
		
	}
	
	/**
	 * Método responsável por retornar uma nova instancia de um produto.
	 * 
	 * @return
	 */
	public Produto getNovoProduto() {
		return new Produto("Produto Teste","Fabricante Teste");
	}
}
