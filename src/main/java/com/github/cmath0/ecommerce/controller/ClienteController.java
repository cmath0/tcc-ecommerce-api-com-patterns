package com.github.cmath0.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cmath0.ecommerce.dto.cliente.ClienteRequestDTO;
import com.github.cmath0.ecommerce.dto.cliente.ClienteResponseDTO;
import com.github.cmath0.ecommerce.entity.Cliente;
import com.github.cmath0.ecommerce.mapper.ClienteMapper;
import com.github.cmath0.ecommerce.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired ClienteService service;
	
	@GetMapping
	public List<ClienteResponseDTO> listarClientes() {
		List<Cliente> clientes = service.listarTodos();

		return ClienteMapper.toResponseDTOList(clientes);
	}
	
	@PostMapping
	public ClienteResponseDTO criarCliente(@RequestBody ClienteRequestDTO dto) {
		Cliente cliente = ClienteMapper.toEntity(dto);

		return ClienteMapper.toResponseDTO(service.cadastrar(cliente));
	}
}
