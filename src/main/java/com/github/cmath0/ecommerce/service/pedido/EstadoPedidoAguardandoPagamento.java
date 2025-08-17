package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.type.StatusPedido;

public class EstadoPedidoAguardandoPagamento implements EstadoPedido {

	@Override
	public void alterarPara(StatusPedido novoEstado, Pedido pedido) {
		validarTransicao(novoEstado);
		
		pedido.setStatus(novoEstado.getCodigo());
	}

	@Override
	public boolean isTransicaoValida(StatusPedido novoEstado) {
		return novoEstado == StatusPedido.PAGO
				|| novoEstado == StatusPedido.CANCELADO;
	}

	@Override
	public StatusPedido getStatus() {
		return StatusPedido.AGUARDANDO_PAGAMENTO;
	}

}
