package com.github.cmath0.ecommerce.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleExceptionGeral(Exception ex) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("erro", "Erro inesperado: " + ex.getMessage()));
	}
	
	@ExceptionHandler(ProdutoInvalidoException.class)
	public ResponseEntity<Map<String, String>> handleProdutoInvalidoException(Exception ex) {
		return ResponseEntity
				.badRequest()
				.body(Map.of("erro", ex.getMessage()));
	}
}
