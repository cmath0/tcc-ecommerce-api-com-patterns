package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;

public class DescontoClienteNivelDois implements DescontoStrategy {

	private static final double DESCONTO_PADRAO = 0.05;
	
	@Override
	public void aplicarDesconto(Pedido pedido) {
		pedido.setValorTotal(calcularDesconto(pedido.getValorTotal(), DESCONTO_PADRAO));
	}
	
}
