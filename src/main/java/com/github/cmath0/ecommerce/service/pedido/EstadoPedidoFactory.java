package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.type.StatusPedido;

public final class EstadoPedidoFactory {

	public static EstadoPedido criar(StatusPedido status) {
		if (status == null) {
			throw new IllegalArgumentException("Status do pedido não pode ser nulo");
		}

		switch (status) {
		case AGUARDANDO_PAGAMENTO:
			return new EstadoPedidoAguardandoPagamento();
		case PAGO:
			return new EstadoPedidoPago();
		case ENVIADO:
			return new EstadoPedidoEnviado();
		case ENTREGUE:
			return new EstadoPedidoEntregue();
		case CANCELADO:
			return new EstadoPedidoCancelado();
		default:
			throw new IllegalArgumentException("Estado do pedido desconhecido: " + status.getDescricao());
		}
	}
}
