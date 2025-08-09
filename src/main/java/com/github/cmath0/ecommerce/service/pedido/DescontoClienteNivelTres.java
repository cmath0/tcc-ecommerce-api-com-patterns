package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;

public class DescontoClienteNivelTres implements DescontoStrategy {

	private static final double DESCONTO_PADRAO = 0.10;
	
	@Override
	public void aplicarDesconto(Pedido pedido) {
		double descontoFinal = DESCONTO_PADRAO;
		
		if (pedido.getValorTotal() > 200.0) {
			descontoFinal += 0.02;
		}
		
		pedido.setValorTotal(calcularDesconto(pedido.getValorTotal(), descontoFinal));
	}
	
}
