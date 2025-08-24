package com.github.cmath0.ecommerce.service.pedido.desconto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.cmath0.ecommerce.entity.Cliente;
import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.repository.ClienteRepository;

@Component
public class DescontoPorTipoClienteHandler extends DescontoHandler {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ContextoDesconto aplicarDesconto(Pedido pedido, ContextoDesconto contexto) {
		if (pedido.getClienteId() != null && clienteRepository.existsById(pedido.getClienteId())) {
			Cliente cliente = clienteRepository.getReferenceById(pedido.getClienteId());
			
			if (cliente.getNivel() == 2) {
				double desconto = contexto.getValorSubtotalPedido() * 0.05;
				contexto.adicionarDesconto(desconto, "5% de desconto para clientes nível 2.");
			} else if (cliente.getNivel() == 3) {
				double desconto = contexto.getValorSubtotalPedido() * 0.10;
				contexto.adicionarDesconto(desconto, "10% de desconto para clientes nível 3.");
			}
		}
		
		return chamarProximo(pedido, contexto);
	}

}
