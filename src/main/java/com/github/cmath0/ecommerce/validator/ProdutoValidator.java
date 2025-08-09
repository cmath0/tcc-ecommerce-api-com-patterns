package com.github.cmath0.ecommerce.validator;

import org.springframework.stereotype.Component;

import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.exception.ProdutoInvalidoException;

@Component
public class ProdutoValidator {

	public void validarCadastro(Produto produto) {
		if (produto == null) {
			throw new ProdutoInvalidoException("Produto não pode ser nulo!");
		}

		if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
    		throw new ProdutoInvalidoException("Nome não pode ser vazio!");
    	}
    	
    	if (produto.getPreco() <= 0) {
    		throw new ProdutoInvalidoException("Preço inválido!");
    	}
    	
    	if (produto.getQuantidadeEstoque() < 0) {
    		throw new ProdutoInvalidoException("Quantidade em estoque inválida!");
    	}
	}
}
