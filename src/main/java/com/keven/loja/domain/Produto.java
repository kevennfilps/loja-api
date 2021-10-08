package com.keven.loja.domain;


import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Produto extends Loja implements Serializable{
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
	}

	public Produto(Integer id, String produto, Integer quantidade, String valor) {
		super(id, produto, quantidade, valor);
	}
	
	

}
