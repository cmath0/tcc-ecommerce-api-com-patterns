package com.github.cmath0.ecommerce.service.pedido.desconto;

import com.github.cmath0.ecommerce.entity.Pedido;

public class DescontoPorVolumeHandler extends DescontoHandler {

	@Override
	public ContextoDesconto aplicarDesconto(Pedido pedido, ContextoDesconto contexto) {
		if (contexto.getValorSubtotalPedido() > 200.00) {
			double desconto = contexto.getValorSubtotalPedido() * 0.10;
			contexto.adicionarDesconto(desconto, "10% de desconto para pedidos acima de R$ 200.");
		}
		
		return chamarProximo(pedido, contexto);
	}

}
