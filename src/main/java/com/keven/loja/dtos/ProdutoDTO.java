package com.keven.loja.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.keven.loja.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo Produto é requerido")
	private String produto;
	
	@NotEmpty(message = "O campo Quantidade é requerido")
	private Integer quantidade;
	
	@NotEmpty(message = "O campo Valor é requerido")
	private String valor;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.quantidade = obj.getQuantidade();
		this.valor = obj.getValor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
}
