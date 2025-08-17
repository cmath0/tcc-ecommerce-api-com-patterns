package com.github.cmath0.ecommerce.service.pedido;

public class EnviarEmailStatusPedidoAlterado implements PedidoStatusObserver {

	@Override
	public void notificar(StatusPedidoAlteradoEvent event) {
		switch (event.getNovoStatus()) {
		case PAGO:
			System.out.println("📧 Enviando e-mail de confirmação de pagamento...");
			break;
		case ENVIADO:
			System.out.println("📧 Enviando e-mail de pedido enviado à transportadora...");
			break;
		case ENTREGUE:
			System.out.println("📧 Enviando e-mail de confirmação de entrega do pedido...");
			break;
		case CANCELADO:
			System.out.println("📧 Enviando e-mail de confirmação de cancelamento do pedido...");
			break;
		default:
			throw new IllegalArgumentException("Status desconhecido: " + event.getNovoStatus());
		}
	}
}
