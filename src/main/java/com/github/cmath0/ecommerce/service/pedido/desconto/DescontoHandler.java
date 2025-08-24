package com.github.cmath0.ecommerce.service.pedido.desconto;

import com.github.cmath0.ecommerce.entity.Pedido;

public abstract class DescontoHandler {

	private DescontoHandler proximo;
	
	DescontoHandler setProximo(DescontoHandler proximo) {
		this.proximo = proximo;
		return proximo;
	}
	
	ContextoDesconto chamarProximo(Pedido pedido, ContextoDesconto contexto) {
		if (proximo != null) {
			return proximo.aplicarDesconto(pedido, contexto);
		}
		
		return contexto;
	}
	
	public abstract ContextoDesconto aplicarDesconto(Pedido pedido, ContextoDesconto contexto);
}
