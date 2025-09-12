package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;
import com.github.cmath0.ecommerce.type.TipoEntrega;

public class FreteCalculatorFactory {

	public static FreteCalculator createCalculator(CotacaoFreteRequestDTO cotacaoRequestDto) {
		if (cotacaoRequestDto.getValorSubtotalPedido() > 200) {
			return new FreteGratisCalculator(cotacaoRequestDto);
		}
		
		TipoEntrega tipoEntrega = TipoEntrega.fromCodigo(cotacaoRequestDto.getTipoEntrega());
		
		switch (tipoEntrega) {
		case NORMAL:
			return new FreteEntregaNormalCalculator(cotacaoRequestDto);
		case EXPRESSA:
			return new FreteEntregaExpressaCalculator(cotacaoRequestDto);
		case TERCEIRIZADA_RAPIDA_EXPRESS:
			return new FreteEntregaRapidaExpressCalculator(cotacaoRequestDto);
		default:
			throw new IllegalArgumentException("Tipo de entrega inválido: " + cotacaoRequestDto.getTipoEntrega());
		}
	}
}
