package com.github.cmath0.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteRequestDTO;
import com.github.cmath0.ecommerce.dto.frete.CotacaoFreteResponseDTO;
import com.github.cmath0.ecommerce.service.frete.CotacaoFrete;
import com.github.cmath0.ecommerce.service.frete.FreteService;

@RestController
@RequestMapping("/fretes/cotacao")
public class FreteController {

	@Autowired private FreteService freteService;
	
	@GetMapping
	public CotacaoFreteResponseDTO calcularFrete(@RequestBody CotacaoFreteRequestDTO dto) {
		CotacaoFrete cotacao = freteService.calcularFrete(dto);
		
		return new CotacaoFreteResponseDTO(cotacao.getValorFrete(), cotacao.getPrazoEstimadoEntrega());
	}
}
