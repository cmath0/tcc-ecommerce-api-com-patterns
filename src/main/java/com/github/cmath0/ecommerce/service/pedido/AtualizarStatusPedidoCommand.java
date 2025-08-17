package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.type.StatusPedido;

public class AtualizarStatusPedidoCommand implements PedidoCommand {

	private final PedidoRepository pedidoRepository;
	private final StatusPedidoAlteradoPublisher statusPedidoAlteradoPublisher;
	
	private long id;
	private int status;
	
	public AtualizarStatusPedidoCommand(long id, int status, PedidoRepository pedidoRepository, StatusPedidoAlteradoPublisher statusPedidoAlteradoPublisher) {
		this.id = id;
		this.status = status;
		this.pedidoRepository = pedidoRepository;
		this.statusPedidoAlteradoPublisher = statusPedidoAlteradoPublisher;
	}
	
	@Override
	public Pedido executar() {
		if (!pedidoRepository.existsById(id)) {
			throw new IllegalArgumentException(String.format("Pedido '%d' não encontrado", id));
		}
		
		Pedido pedido = pedidoRepository.getReferenceById(id);
		StatusPedido statusAnterior = StatusPedido.fromCodigo(pedido.getStatus());
		StatusPedido novoStatus = StatusPedido.fromCodigo(status);
		
		EstadoPedido estadoPedido = EstadoPedidoFactory.criar(StatusPedido.fromCodigo(pedido.getStatus()));
		estadoPedido.alterarPara(novoStatus, pedido);
		
		Pedido pedidoAtualizado = pedidoRepository.save(pedido);
		
		statusPedidoAlteradoPublisher.publicar(new StatusPedidoAlteradoEvent(pedido.getId(), statusAnterior, novoStatus));
		
		return pedidoAtualizado;
	}
}
