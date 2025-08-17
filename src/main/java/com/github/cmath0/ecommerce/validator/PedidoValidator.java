package com.github.cmath0.ecommerce.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;

@Component
public class PedidoValidator {

	public Map<Long, Produto> validarProdutosDoPedido(Pedido pedido, ProdutoRepository produtoRepository) {
		if (pedido.getProdutosDoPedido() == null || pedido.getProdutosDoPedido().isEmpty()) {
			throw new IllegalArgumentException("O pedido deve conter pelo menos um produto.");
		}
		
		Set<Long> produtosDoPedido = pedido.getProdutosDoPedido().stream().collect(Collectors.toSet());
		Map<Long, Produto> produtosDoPedidoMap = new HashMap<>();

		for (Long produtoId : produtosDoPedido) {
			if (!produtoRepository.existsById(produtoId)) {
				throw new IllegalArgumentException("Produto inexistente. Id: " + produtoId);
			}
			
			Produto produto = produtoRepository.getReferenceById(produtoId);
			
			if (produto.getQuantidadeEstoque() < 1) {
				throw new IllegalArgumentException("Produto fora de estoque: " + produto.getId() + " - " + produto.getNome());
			}
			
			produtosDoPedidoMap.put(produto.getId(), produto);
		}
		
		return produtosDoPedidoMap;
	}
}
