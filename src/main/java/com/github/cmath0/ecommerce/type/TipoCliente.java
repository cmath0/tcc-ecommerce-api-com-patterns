package com.github.cmath0.ecommerce.type;

public enum TipoCliente {
	NIVEL_1(1, "Nível 1"),
	NIVEL_2(2, "Nível 2"),
	NIVEL_3(3, "Nível 3"),
	NIVEL_4(4, "Nível 4");
	
	private final int nivel;
	private final String descricao;
	
	TipoCliente(int nivel, String descricao) {
		this.nivel = nivel;
		this.descricao = descricao;
	}
	
	public static TipoCliente fromNivel(int nivel) {
		for (TipoCliente tipo : TipoCliente.values()) {
			if (tipo.nivel == nivel) {
				return tipo;
			}
		}
		
		return null;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
