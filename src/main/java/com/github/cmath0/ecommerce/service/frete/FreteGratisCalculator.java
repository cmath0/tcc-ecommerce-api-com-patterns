package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;
import com.github.cmath0.ecommerce.type.TipoEntrega;

public class FreteGratisCalculator extends FreteCalculator {

	public FreteGratisCalculator(CotacaoFreteRequestDTO cotacaoFreteRequestDTO) {
		super(cotacaoFreteRequestDTO);
	}
	
	@Override
	public CotacaoFrete calcularFrete() {
		return new CotacaoFrete(0.0, "2 a 3 dias", TipoEntrega.EXPRESSA.getCodigo());
	}

}
