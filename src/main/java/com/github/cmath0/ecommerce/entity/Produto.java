package com.github.cmath0.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

	public Produto(String nome, String descricao, double preco, int quantidadeEstoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private double preco;
	private int quantidadeEstoque;
}
