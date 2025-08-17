package com.github.cmath0.ecommerce.service.pedido;

public interface PedidoStatusObserver {

	void notificar(StatusPedidoAlteradoEvent event);
}
