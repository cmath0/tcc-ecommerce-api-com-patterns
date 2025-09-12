package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;
import com.github.cmath0.ecommerce.type.Regiao;

public class FreteEntregaNormalCalculator extends FreteCalculator {

	public FreteEntregaNormalCalculator(CotacaoFreteRequestDTO cotacaoRequestDto) {
		super(cotacaoRequestDto);
	}
	
	@Override
	public CotacaoFrete calcularFrete() {
		
		double valorFreteBase = 15.00;
		double valorAdicionalPorKg = 2.00;
		String prazoEstimado = "5 a 7 dias";
		Regiao regiao = Regiao.obterRegiaoPorCep(cotacaoRequestDto.getCepDestino());
		
		double multiplicador = multiplicadorPorRegiao.getMultiplicadorPorRegiao(regiao);
		double pesoEmKg = cotacaoRequestDto.getPesoTotalEmGramas() / 1000.0;
		double valorFrete = (valorFreteBase + (valorAdicionalPorKg * pesoEmKg)) * multiplicador;
		
		return new CotacaoFrete(valorFrete, prazoEstimado, cotacaoRequestDto.getTipoEntrega());
	}

}
