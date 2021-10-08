package com.keven.loja.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keven.loja.domain.Produto;
import com.keven.loja.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public void instanciaDB() {
		
		Produto p1 = new Produto(null, "Notebook Acer Aspire", 841, "R$ 1.984,00");

		produtoRepository.saveAll(Arrays.asList(p1));
	}
}
