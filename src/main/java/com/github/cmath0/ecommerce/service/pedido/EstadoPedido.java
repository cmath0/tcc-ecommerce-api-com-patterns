package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.exception.TransicaoInvalidaStatusException;
import com.github.cmath0.ecommerce.type.StatusPedido;

public interface EstadoPedido {

	void alterarPara(StatusPedido novoEstado, Pedido pedido);
	boolean isTransicaoValida(StatusPedido novoEstado);
	StatusPedido getStatus();
	
	default void validarTransicao(StatusPedido novoEstado) {
		if (!isTransicaoValida(novoEstado)) {
			throw new TransicaoInvalidaStatusException(String.format("Transição inválida de status: %s para %s", 
					this.getStatus().getDescricao(), novoEstado.getDescricao()));
		}
	}
}
