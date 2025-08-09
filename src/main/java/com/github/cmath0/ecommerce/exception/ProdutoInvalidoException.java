package com.github.cmath0.ecommerce.exception;

public class ProdutoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = -5360468792539954349L;
	
	public ProdutoInvalidoException(String message) {
		super(message);
	}
}
