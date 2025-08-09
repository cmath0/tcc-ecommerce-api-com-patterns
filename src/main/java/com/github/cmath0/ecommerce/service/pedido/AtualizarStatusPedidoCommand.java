package com.github.cmath0.ecommerce.service.pedido;

import java.util.List;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.type.StatusPedido;
import com.github.cmath0.ecommerce.validator.PedidoValidator;

public class AtualizarStatusPedidoCommand implements PedidoCommand {

	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoValidator pedidoValidator;
	
	private long id;
	private int status;
	
	public AtualizarStatusPedidoCommand(long id, int status, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, PedidoValidator pedidoValidator) {
		this.id = id;
		this.status = status;
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoValidator = pedidoValidator;
	}
	
	@Override
	public Pedido executar() {
		Pedido pedido = pedidoValidator.validarNovoStatus(status, id, pedidoRepository);
		
		if (StatusPedido.CANCELADO.getCodigo() == status) {
			List<Produto> produtosParaAtualizarEstoque = produtoRepository.findAllById(pedido.getProdutosDoPedido());
			
			for (Produto produto : produtosParaAtualizarEstoque) {
				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
			}
			
			produtoRepository.saveAll(produtosParaAtualizarEstoque);
		}
		
		return pedidoRepository.save(pedido);
	}
}
