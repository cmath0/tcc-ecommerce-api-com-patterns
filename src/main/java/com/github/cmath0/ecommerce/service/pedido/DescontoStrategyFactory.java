package com.github.cmath0.ecommerce.service.pedido;

import com.github.cmath0.ecommerce.type.TipoCliente;

public class DescontoStrategyFactory {

	public static DescontoStrategy getDescontoStrategy(TipoCliente tipoCliente) {
		switch (tipoCliente) {
		case NIVEL_1:
			return new DescontoClienteNivelUm();
		case NIVEL_2:
			return new DescontoClienteNivelDois();
		case NIVEL_3:
			return new DescontoClienteNivelTres();
		case NIVEL_4:
			return new DescontoClienteNivelQuatro();
		default:
			throw new IllegalArgumentException("Nível de cliente inválido: " + tipoCliente.getNivel());
		}
	}
}
