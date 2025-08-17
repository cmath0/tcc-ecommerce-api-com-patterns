package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.type.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StatusPedidoAlteradoEvent {

	private final Long pedidoId;
	private final StatusPedido statusAnterior;
	private final StatusPedido novoStatus;
	
}
