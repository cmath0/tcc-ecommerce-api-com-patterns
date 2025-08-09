package com.github.cmath0.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cmath0.ecommerce.dto.produto.ProdutoRequestDTO;
import com.github.cmath0.ecommerce.dto.produto.ProdutoResponseDTO;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.mapper.ProdutoMapper;
import com.github.cmath0.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
    public List<ProdutoResponseDTO> listarProdutosDisponiveis() {
		List<Produto> produtosDisponiveis = service.listarDisponiveis();
		
		return produtosDisponiveis
				.stream()
				.map(ProdutoMapper::toResponseDTO)
				.toList();
    }

	@PostMapping
    public ProdutoResponseDTO criarProduto(@RequestBody ProdutoRequestDTO dto) {
		Produto produto = ProdutoMapper.toEntity(dto);
    	
    	return ProdutoMapper.toResponseDTO(service.cadastrar(produto));
    }
}
