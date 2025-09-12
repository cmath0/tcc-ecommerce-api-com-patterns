package com.github.cmath0.ecommerce.service.frete;

import org.springframework.stereotype.Service;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;

@Service
public class FreteService {

	public CotacaoFrete calcularFrete(CotacaoFreteRequestDTO cotacaoRequestDto) {
		
		FreteCalculator freteCalculator = FreteCalculatorFactory.createCalculator(cotacaoRequestDto);
		
		return freteCalculator.calcularFrete();
	}
}
