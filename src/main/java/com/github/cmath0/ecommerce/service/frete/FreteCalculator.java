package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;

public abstract class FreteCalculator {

	protected final MultiplicadorFretePorRegiao multiplicadorPorRegiao;
	protected final CotacaoFreteRequestDTO cotacaoRequestDto;
	
	protected FreteCalculator(CotacaoFreteRequestDTO cotacaoFreteRequestDTO) {
		this.cotacaoRequestDto = cotacaoFreteRequestDTO;
		this.multiplicadorPorRegiao = MultiplicadorFretePorRegiao.getInstance();
	}
	
	protected FreteCalculator(CotacaoFreteRequestDTO cotacaoFreteRequestDTO, MultiplicadorFretePorRegiao multiplicadorPorRegiao) {
		this.cotacaoRequestDto = cotacaoFreteRequestDTO;
		this.multiplicadorPorRegiao = multiplicadorPorRegiao;
	}
	
	public abstract CotacaoFrete calcularFrete();
}
