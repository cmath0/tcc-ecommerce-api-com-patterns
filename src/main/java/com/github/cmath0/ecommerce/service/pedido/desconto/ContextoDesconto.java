package com.github.cmath0.ecommerce.service.pedido.desconto;

import java.util.ArrayList;
import java.util.List;

public class ContextoDesconto {

	private double valorSubtotalPedido;
	private double valorDescontos;
	private List<String> descontosAplicados = new ArrayList<>();
	
	public ContextoDesconto(double valorSubtotalPedido) {
		this.valorSubtotalPedido = valorSubtotalPedido;
		this.valorDescontos = 0.0;
	}
	
	public void adicionarDesconto(double valorDesconto, String descricao) {
		this.valorDescontos += valorDesconto;
		this.descontosAplicados.add(descricao);
	}
	
	public double getValorSubtotalPedido() {
		return valorSubtotalPedido;
	}
	
	public double getValorDescontos() {
		return valorDescontos;
	}
	
	public String getDescontosAplicados() {
		return descontosAplicados.stream().map(String::valueOf).reduce((a, b) -> a + ", " + b)
				.orElse("Nenhum desconto aplicado");
	}
}
