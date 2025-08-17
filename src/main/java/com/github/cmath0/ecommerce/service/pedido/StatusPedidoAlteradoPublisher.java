package com.github.cmath0.ecommerce.service.pedido;

import java.util.ArrayList;
import java.util.List;

public class StatusPedidoAlteradoPublisher {

	private List<PedidoStatusObserver> observers = new ArrayList<>();
	
	public static StatusPedidoAlteradoPublisher getInstance(PedidoStatusObserver observer, PedidoStatusObserver ... observers) {
		StatusPedidoAlteradoPublisher publisher = new StatusPedidoAlteradoPublisher();
		
		publisher.adicionarObserver(observer);
		
		for (PedidoStatusObserver o : observers) {
			publisher.adicionarObserver(o);
		}
		
		return publisher;
	}
	
	public void adicionarObserver(PedidoStatusObserver observer) {
		observers.add(observer);
	}
	
	public void removerObserver(PedidoStatusObserver observer) {
		observers.remove(observer);
	}
	
	public void publicar(StatusPedidoAlteradoEvent event) {
		for (PedidoStatusObserver observer : observers) {
			observer.notificar(event);
		}
	}
}
