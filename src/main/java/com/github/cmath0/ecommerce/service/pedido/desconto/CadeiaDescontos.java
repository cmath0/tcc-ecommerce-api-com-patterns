package com.github.cmath0.ecommerce.service.pedido.desconto;

public class CadeiaDescontos {

	public static DescontoHandler criarCadeiaPadrao() {
		DescontoHandler descontoPorVolume = new DescontoPorVolumeHandler();
		DescontoHandler descontoPorTipoCliente = new DescontoPorTipoClienteHandler();
		DescontoHandler descontoCupom = new DescontoCupomHandler();

		descontoPorVolume.setProximo(descontoPorTipoCliente);
		descontoPorTipoCliente.setProximo(descontoCupom);

		return descontoPorVolume;
	}
}
