package com.github.cmath0.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired PedidoRepository repository;
	@Autowired PedidoCommandFactory commandFactory;
	
	public List<Pedido> listarTodos() {
		return repository.findAll();
	}
	
	public Pedido efetuarPedido(Pedido pedido) {
		return commandFactory.efetuarPedidoCommand(pedido).executar();
	}
	
	public Pedido atualizarStatusPedido(long id, int status) {
		return commandFactory.atualizarStatusPedidoCommand(id, status).executar();
	}
}
