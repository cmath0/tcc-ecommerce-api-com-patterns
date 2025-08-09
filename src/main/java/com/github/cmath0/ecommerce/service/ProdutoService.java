package com.github.cmath0.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.validator.ProdutoValidator;

@Service
public class ProdutoService {
	
	@Autowired private ProdutoRepository repository;
	@Autowired private ProdutoValidator validator;

	public Produto cadastrar(Produto produto) {
		validator.validarCadastro(produto);
    	
        return repository.save(produto);
	}

	public List<Produto> listarDisponiveis() {
		return repository.findAll()
				.stream()
				.filter(p -> p.getQuantidadeEstoque() > 0)
				.toList();
	}
}
