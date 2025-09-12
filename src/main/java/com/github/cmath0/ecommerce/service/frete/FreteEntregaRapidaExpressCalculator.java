package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;
import com.github.cmath0.ecommerce.type.Regiao;

public class FreteEntregaRapidaExpressCalculator extends FreteCalculator {

	public FreteEntregaRapidaExpressCalculator(CotacaoFreteRequestDTO cotacaoRequestDto) {
		super(cotacaoRequestDto, new MultiplicadorFretePorRegiao.Builder()
				.regiaoNorte(1.4)
				.regiaoNordeste(1.3)
				.regiaoCentroOeste(1.2)
				.regiaoSudeste(1.0)
				.regiaoSul(1.1)
				.build());
	}
	
	@Override
	public CotacaoFrete calcularFrete() {
		
		Regiao regiao = Regiao.obterRegiaoPorCep(cotacaoRequestDto.getCepDestino());
		String prazoEstimado = "1 dia útil";
		
		if (regiao == Regiao.NORTE || regiao == Regiao.NORDESTE) {
			prazoEstimado = "2 dias úteis";
		}
		
		double valorFreteBase = 35.00;
		double multiplicador = multiplicadorPorRegiao.getMultiplicadorPorRegiao(regiao);
		double valorFrete = valorFreteBase * multiplicador;
		
		return new CotacaoFrete(valorFrete, prazoEstimado, cotacaoRequestDto.getTipoEntrega());
	}

}
