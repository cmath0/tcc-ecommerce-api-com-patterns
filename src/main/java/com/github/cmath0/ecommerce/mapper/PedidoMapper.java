package com.github.cmath0.ecommerce.mapper;

import java.util.List;

import com.github.cmath0.ecommerce.dto.pedido.NovoPedidoRequestDTO;
import com.github.cmath0.ecommerce.dto.pedido.PedidoResponseDTO;
import com.github.cmath0.ecommerce.entity.Pedido;

public class PedidoMapper {

	private PedidoMapper() {
		throw new UnsupportedOperationException("Classe utilitária não deve ser instanciada.");
	}
	
	public static PedidoResponseDTO toResponseDTO(Pedido pedido) {
		return new PedidoResponseDTO(pedido.getId(),
				pedido.getData(),
				pedido.getProdutosDoPedido(),
				pedido.getValorTotal(),
				pedido.getStatus(),
				pedido.getClienteId());
	}
	
	public static List<PedidoResponseDTO> toResponseDTOList(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoMapper::toResponseDTO).toList();
	}

	public static Pedido toEntity(NovoPedidoRequestDTO requestDto) {
		return new Pedido(requestDto.getData(), 
				requestDto.getProdutosDoPedido(),
				requestDto.getClienteId());
	}
}
