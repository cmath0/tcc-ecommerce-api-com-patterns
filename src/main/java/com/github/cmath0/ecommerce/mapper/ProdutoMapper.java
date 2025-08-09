package com.github.cmath0.ecommerce.mapper;

import com.github.cmath0.ecommerce.dto.produto.ProdutoRequestDTO;
import com.github.cmath0.ecommerce.dto.produto.ProdutoResponseDTO;
import com.github.cmath0.ecommerce.entity.Produto;

public class ProdutoMapper {

	private ProdutoMapper() {
		throw new UnsupportedOperationException("Classe utilitária não deve ser instanciada.");
	}
	
	public static ProdutoResponseDTO toResponseDTO(Produto produto) {
		return new ProdutoResponseDTO(produto.getId(), 
				produto.getNome(), 
				produto.getDescricao(), 
				produto.getPreco(),
				produto.getQuantidadeEstoque());
	}

	public static Produto toEntity(ProdutoRequestDTO requestDto) {
		return new Produto(requestDto.getNome(), 
				requestDto.getDescricao(), 
				requestDto.getPreco(),
				requestDto.getQuantidadeEstoque());
	}
}
