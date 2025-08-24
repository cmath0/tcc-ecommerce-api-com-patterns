package com.github.cmath0.ecommerce.service.pedido;

import java.util.Map;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.service.pedido.desconto.CadeiaDescontos;
import com.github.cmath0.ecommerce.service.pedido.desconto.ContextoDesconto;
import com.github.cmath0.ecommerce.service.pedido.desconto.DescontoHandler;
import com.github.cmath0.ecommerce.type.StatusPedido;
import com.github.cmath0.ecommerce.validator.PedidoValidator;

public class EfetuarPedidoCommand implements PedidoCommand {

	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoValidator pedidoValidator;
	
	private final Pedido pedido;
	
	public EfetuarPedidoCommand(Pedido pedido, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, PedidoValidator pedidoValidator) {
		this.pedido = pedido;
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoValidator = pedidoValidator;
	}
	
	@Override
	public Pedido executar() {
		pedido.setValorTotal(0.0);
		pedido.setValorSubtotal(0.0);
		pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO.getCodigo());
		
		Map<Long, Produto> produtosDoPedido = pedidoValidator.validarProdutosDoPedido(pedido, produtoRepository);
		
		for (Long produtoId : pedido.getProdutosDoPedido()) {
			Produto produto = produtosDoPedido.get(produtoId);
			
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
			pedido.setValorSubtotal(pedido.getValorSubtotal() + produto.getPreco());
		}
		pedido.setValorTotal(pedido.getValorSubtotal());
		
		calcularDescontos();
		produtoRepository.saveAll(produtosDoPedido.values());
		
		return pedidoRepository.save(pedido);
	}

	private void calcularDescontos() {
		DescontoHandler descontoHandler = CadeiaDescontos.criarCadeiaPadrao();
		
		ContextoDesconto descontos = descontoHandler.aplicarDesconto(pedido, new ContextoDesconto(pedido.getValorSubtotal()));
		pedido.setValorTotal(descontos.getValorSubtotalPedido() - descontos.getValorDescontos());
		pedido.setObsDescontos(descontos.getDescontosAplicados());
	}

}
