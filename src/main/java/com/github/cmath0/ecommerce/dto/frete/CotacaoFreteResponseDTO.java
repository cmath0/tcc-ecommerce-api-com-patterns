package com.github.cmath0.ecommerce.dto.frete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoFreteResponseDTO {

	private double valorFrete;
	private String prazoEstimadoEntrega;
}
