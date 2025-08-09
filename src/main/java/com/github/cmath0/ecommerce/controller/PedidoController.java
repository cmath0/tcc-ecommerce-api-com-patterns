package com.github.cmath0.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cmath0.ecommerce.dto.pedido.NovoPedidoRequestDTO;
import com.github.cmath0.ecommerce.dto.pedido.NovoStatusPedidoRequestDTO;
import com.github.cmath0.ecommerce.dto.pedido.PedidoResponseDTO;
import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.mapper.PedidoMapper;
import com.github.cmath0.ecommerce.service.pedido.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired PedidoService service;
	
	@GetMapping
	public List<PedidoResponseDTO> listarPedidos() {
		List<Pedido> pedidos = service.listarTodos();

		return PedidoMapper.toResponseDTOList(pedidos);
	}
	
	@PostMapping
	public Pedido efetuarPedido(@RequestBody NovoPedidoRequestDTO dto) {
		return service.efetuarPedido(PedidoMapper.toEntity(dto));
	}
	
	@PatchMapping("/{id}/status")
	public PedidoResponseDTO atualizarStatusPedido(@PathVariable long id, @RequestBody NovoStatusPedidoRequestDTO dto) {
		Pedido pedido = service.atualizarStatusPedido(id, dto.getStatus());
		
		return PedidoMapper.toResponseDTO(pedido);
	}
}
