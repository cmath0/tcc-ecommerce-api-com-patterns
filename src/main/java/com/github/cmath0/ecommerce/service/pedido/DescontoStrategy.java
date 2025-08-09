package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;

public interface DescontoStrategy {

	void aplicarDesconto(Pedido pedido);
	
	default double calcularDesconto(double valorTotal, double percentualDesconto) {
		return valorTotal * (1 - percentualDesconto);
	}
}
