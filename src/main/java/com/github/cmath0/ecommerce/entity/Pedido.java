package com.github.cmath0.ecommerce.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

	public Pedido(String data, List<Long> produtosDoPedido, Long clienteId) {
		this.data = data;
		this.produtosDoPedido = produtosDoPedido;
		this.clienteId = clienteId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String data;
	
	@ElementCollection
	private List<Long> produtosDoPedido;
	private double valorTotal;
	private int status;
	private Long clienteId;
}
