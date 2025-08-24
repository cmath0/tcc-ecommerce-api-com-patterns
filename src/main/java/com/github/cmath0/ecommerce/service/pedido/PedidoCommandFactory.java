package com.github.cmath0.ecommerce.service.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.cmath0.ecommerce.entity.Pedido;
import com.github.cmath0.ecommerce.repository.PedidoRepository;
import com.github.cmath0.ecommerce.repository.ProdutoRepository;
import com.github.cmath0.ecommerce.validator.PedidoValidator;

@Component
public class PedidoCommandFactory {

    @Autowired private PedidoRepository pedidoRepository;

    @Autowired private ProdutoRepository produtoRepository;

    @Autowired private PedidoValidator pedidoValidator;
    
    public EfetuarPedidoCommand efetuarPedidoCommand(Pedido pedido) {
        return new EfetuarPedidoCommand(pedido, pedidoRepository, produtoRepository, pedidoValidator);
    }

    public AtualizarStatusPedidoCommand atualizarStatusPedidoCommand(long id, int status) {
    	StatusPedidoAlteradoPublisher statusPedidoAlteradoPublisher = StatusPedidoAlteradoPublisher.getInstance(
    			new EnviarEmailStatusPedidoAlterado(),
    			new AtualizarEstoqueStatusPedidoAlterado());
    	
        return new AtualizarStatusPedidoCommand(id, status, pedidoRepository, statusPedidoAlteradoPublisher);
    }
}
