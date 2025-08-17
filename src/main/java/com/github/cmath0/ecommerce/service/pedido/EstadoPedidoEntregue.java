package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.exception.TransicaoInvalidaStatusException;
import com.github.cmath0.ecommerce.type.StatusPedido;

public class EstadoPedidoEntregue implements EstadoPedido {

	@Override
	public void alterarPara(StatusPedido novoEstado, Pedido pedido) {
		throw new TransicaoInvalidaStatusException("Não é possível alterar o status de um pedido entregue.");
		
	}

	@Override
	public boolean isTransicaoValida(StatusPedido novoEstado) {
		return false;
	}

	@Override
	public StatusPedido getStatus() {
		return StatusPedido.ENTREGUE;
	}

}
