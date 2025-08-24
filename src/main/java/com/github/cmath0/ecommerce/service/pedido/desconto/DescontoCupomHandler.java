package com.github.cmath0.ecommerce.service.pedido.desconto;

import com.github.cmath0.ecommerce.entity.Pedido;

public class DescontoCupomHandler extends DescontoHandler {

	@Override
	public ContextoDesconto aplicarDesconto(Pedido pedido, ContextoDesconto contexto) {
		if ("PROMO50".equals(pedido.getCupomDesconto()) && contexto.getValorSubtotalPedido() > 500.00) {
			contexto.adicionarDesconto(50.00, "Cupom de desconto PROMO50 aplicado.");
		}
		
		return chamarProximo(pedido, contexto);
	}

}
