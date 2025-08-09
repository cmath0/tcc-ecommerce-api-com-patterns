package com.github.cmath0.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cmath0.ecommerce.entity.Cliente;
import com.github.cmath0.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired ClienteRepository repository;
	
	public List<Cliente> listarTodos() {
		return repository.findAll();
	}
	
	public Cliente buscarPorId(long id) {
		return repository.getReferenceById(id);
	}
	
	public Cliente cadastrar(Cliente cliente) {
		return repository.save(cliente);
	}
}
