package com.github.cmath0.ecommerce.service.pedido;

import java.util.Map;

import com.github.cmath0.ecommerce.entity.Cliente;
import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.entity.Produto;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.service.ClienteService;
import com.github.cmath0.ecommerce.type.StatusPedido;
import com.github.cmath0.ecommerce.type.TipoCliente;
import com.github.cmath0.ecommerce.validator.PedidoValidator;

public class EfetuarPedidoCommand implements PedidoCommand {

	private final ClienteService clienteService;
	private final PedidoRepository pedidoRepository;
	private final ProdutoRepository produtoRepository;
	private final PedidoValidator pedidoValidator;
	
	private final Pedido pedido;
	
	public EfetuarPedidoCommand(Pedido pedido, ClienteService clienteService, PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, PedidoValidator pedidoValidator) {
		this.pedido = pedido;
		this.clienteService = clienteService;
		this.pedidoRepository = pedidoRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoValidator = pedidoValidator;
	}
	
	@Override
	public Pedido executar() {
		pedido.setValorTotal(0.0);
		pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO.getCodigo());
		
		Map<Long, Produto> produtosDoPedido = pedidoValidator.validarProdutosDoPedido(pedido, produtoRepository);
		
		for (Long produtoId : pedido.getProdutosDoPedido()) {
			Produto produto = produtosDoPedido.get(produtoId);
			
			produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);
			pedido.setValorTotal(pedido.getValorTotal() + produto.getPreco());
		}
		
		calcularDesconto();
		produtoRepository.saveAll(produtosDoPedido.values());
		
		return pedidoRepository.save(pedido);
	}

	private void calcularDesconto() {
		Cliente cliente = clienteService.buscarPorId(pedido.getClienteId());
		
		if (cliente != null) {
			DescontoStrategy descontoStrategy = DescontoStrategyFactory.getDescontoStrategy(TipoCliente.fromNivel(cliente.getNivel()));
			
			descontoStrategy.aplicarDesconto(pedido);
		}
	}

}
