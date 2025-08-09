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
public class NovoPedidoRequestDTO {

	private String data;
	private List<Long> produtosDoPedido;
	private Long clienteId;
}
