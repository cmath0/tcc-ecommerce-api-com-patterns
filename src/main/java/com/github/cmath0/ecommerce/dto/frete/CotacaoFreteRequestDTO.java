package com.github.cmath0.ecommerce.dto.frete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoFreteRequestDTO {

	private double valorSubtotalPedido;
	private String cepDestino;
	private double pesoTotalEmGramas;
	private int tipoEntrega;
}
