package com.github.cmath0.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.type.StatusPedido;

public class AtualizarEstoqueStatusPedidoAlterado implements PedidoStatusObserver {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void notificar(StatusPedidoAlteradoEvent event) {
		if (event.getNovoStatus() == StatusPedido.PAGO) {
			debitarProdutosDoEstoque(event);
		}
		
		if (event.getStatusAnterior() == StatusPedido.PAGO && event.getNovoStatus() == StatusPedido.CANCELADO) {
			retornarProdutosAoEstoque(event);
		}
	}
	
	private void debitarProdutosDoEstoque(StatusPedidoAlteradoEvent event) {
		Pedido pedido = pedidoRepository.getReferenceById(event.getPedidoId());
		List<Produto> produtosParaAtualizarEstoque = produtoRepository.findAllById(pedido.getProdutosDoPedido());

		for (Produto produto : produtosParaAtualizarEstoque) {
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
		}

		produtoRepository.saveAll(produtosParaAtualizarEstoque);
	}

	private void retornarProdutosAoEstoque(StatusPedidoAlteradoEvent event) {
		Pedido pedido = pedidoRepository.getReferenceById(event.getPedidoId());
		List<Produto> produtosParaAtualizarEstoque = produtoRepository.findAllById(pedido.getProdutosDoPedido());
		
		for (Produto produto : produtosParaAtualizarEstoque) {
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
		}
		
		produtoRepository.saveAll(produtosParaAtualizarEstoque);
	}

}
