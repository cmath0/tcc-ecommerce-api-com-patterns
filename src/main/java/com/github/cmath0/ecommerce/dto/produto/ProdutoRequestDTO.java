package com.github.cmath0.ecommerce.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

	private String nome;
	private String descricao;
	private double preco;
	private int quantidadeEstoque;
}
