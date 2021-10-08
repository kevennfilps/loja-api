package com.keven.loja.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.keven.loja.domain.Produto;
import com.keven.loja.dtos.ProdutoDTO;
import com.keven.loja.services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	
	/*
	 * Buscar por ID de Produto
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id){
		ProdutoDTO objDTO = new ProdutoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	/*
	 * Listagem de todos os Produto
	 */
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		
		List<ProdutoDTO> listDTO = service.findAll()
				.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);

	}
	
	
	/*
	 * Cadastro de Produto
	 */
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO objDTO){
		Produto newObj = service.create(objDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Atualização de Produto
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id, @RequestBody ProdutoDTO objDTO){
		ProdutoDTO newObj = new ProdutoDTO(service.update(id, objDTO));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Atualização de Produto
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
