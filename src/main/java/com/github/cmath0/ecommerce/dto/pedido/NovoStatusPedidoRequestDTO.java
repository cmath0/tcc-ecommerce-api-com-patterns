package com.github.cmath0.ecommerce.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovoStatusPedidoRequestDTO {

	private Long id;
	private int status;
}
