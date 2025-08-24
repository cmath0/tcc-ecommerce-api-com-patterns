package com.github.cmath0.ecommerce.dto.pedido;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {

	private Long id;
	private String data;
	private List<Long> produtosDoPedido;
	private double valorTotal;
	private double valorSubtotal;
	private int status;
	private Long clienteId;
	private String cupomDesconto;
	private String obsDescontos;
}
