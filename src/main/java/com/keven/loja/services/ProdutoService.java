package com.keven.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keven.loja.domain.Produto;
import com.keven.loja.dtos.ProdutoDTO;
import com.keven.loja.repositories.ProdutoRepository;
import com.keven.loja.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " +id+ ", Tipo: "+Produto.class.getName()));
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto create(ProdutoDTO objDTO) {
		return repository.save(new Produto(null, objDTO.getProduto(), objDTO.getQuantidade(), objDTO.getValor()));
	}

	public Produto update(Integer id, ProdutoDTO objDTO) {
		Produto oldObj = findById(id);
		
		oldObj.setProduto(objDTO.getProduto());
		oldObj.setQuantidade(objDTO.getQuantidade());
		oldObj.setValor(objDTO.getValor());
		
		return repository.save(oldObj);
		
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
		
		
	}
}
