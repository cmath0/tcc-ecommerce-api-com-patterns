package com.github.cmath0.ecommerce.service.frete;

import com.github.cmath0.ecommerce.type.Regiao;

public class MultiplicadorFretePorRegiao {

	private double multiplicadorRegiaoNorte;
	private double multiplicadorRegiaoNordeste;
	private double multiplicadorRegiaoCentroOeste;
	private double multiplicadorRegiaoSudeste;
	private double multiplicadorRegiaoSul;
	
	private MultiplicadorFretePorRegiao(double multiplicadorRegiaoNorte,
			double multiplicadorRegiaoNordeste, double multiplicadorRegiaoCentroOeste,
			double multiplicadorRegiaoSudeste, double multiplicadorRegiaoSul) {
		this.multiplicadorRegiaoNorte = multiplicadorRegiaoNorte;
		this.multiplicadorRegiaoNordeste = multiplicadorRegiaoNordeste;
		this.multiplicadorRegiaoCentroOeste = multiplicadorRegiaoCentroOeste;
		this.multiplicadorRegiaoSudeste = multiplicadorRegiaoSudeste;
		this.multiplicadorRegiaoSul = multiplicadorRegiaoSul;
	}
	
	public static MultiplicadorFretePorRegiao getInstance() {
		return new Builder()
				.regiaoNorte(1.2)
				.regiaoNordeste(1.15)
				.regiaoCentroOeste(1.1)
				.regiaoSudeste(1.0)
				.regiaoSul(1.1)
				.build();
	}
	
	public double getMultiplicadorPorRegiao(Regiao regiao) {
		switch (regiao) {
		case NORTE:
			return multiplicadorRegiaoNorte;
		case NORDESTE:
			return multiplicadorRegiaoNordeste;
		case CENTRO_OESTE:
			return multiplicadorRegiaoCentroOeste;
		case SUDESTE:
			return multiplicadorRegiaoSudeste;
		case SUL:
			return multiplicadorRegiaoSul;
		default:
			throw new IllegalArgumentException("Região inválida.");
		}
	}
	
	public static class Builder {
		
		private double multiplicadorRegiaoNorte;
		private double multiplicadorRegiaoNordeste;
		private double multiplicadorRegiaoCentroOeste;
		private double multiplicadorRegiaoSudeste;
		private double multiplicadorRegiaoSul;
		
		public MultiplicadorFretePorRegiao build() {
			if (multiplicadorRegiaoNorte <= 0 || multiplicadorRegiaoNordeste <= 0 || multiplicadorRegiaoCentroOeste <= 0
					|| multiplicadorRegiaoSudeste <= 0 || multiplicadorRegiaoSul <= 0) {
				throw new IllegalArgumentException("Multiplicadores devem ser maiores que zero");
			}
			
			return new MultiplicadorFretePorRegiao(multiplicadorRegiaoNorte, multiplicadorRegiaoNordeste,
					multiplicadorRegiaoCentroOeste, multiplicadorRegiaoSudeste, multiplicadorRegiaoSul);
		}

		public Builder regiaoNorte(double multiplicador) {
			multiplicadorRegiaoNorte = multiplicador;
			return this;
		}

		public Builder regiaoNordeste(double multiplicador) {
			multiplicadorRegiaoNordeste = multiplicador;
			return this;
		}

		public Builder regiaoCentroOeste(double multiplicador) {
			multiplicadorRegiaoCentroOeste = multiplicador;
			return this;
		}

		public Builder regiaoSudeste(double multiplicador) {
			multiplicadorRegiaoSudeste = multiplicador;
			return this;
		}

		public Builder regiaoSul(double multiplicador) {
			multiplicadorRegiaoSul = multiplicador;
			return this;
		}
	}
}
