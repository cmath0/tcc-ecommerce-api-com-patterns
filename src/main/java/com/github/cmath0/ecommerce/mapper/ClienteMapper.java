package com.github.cmath0.ecommerce.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.github.cmath0.ecommerce.dto.cliente.ClienteRequestDTO;
import com.github.cmath0.ecommerce.dto.cliente.ClienteResponseDTO;
import com.github.cmath0.ecommerce.entity.Cliente;

public class ClienteMapper {

	public static ClienteResponseDTO toResponseDTO(Cliente cliente) {
		return new ClienteResponseDTO(cliente.getId(), cliente.getNivel());
	}

	public static List<ClienteResponseDTO> toResponseDTOList(List<Cliente> clientes) {
		return clientes.stream().map(ClienteMapper::toResponseDTO).collect(Collectors.toList());
	}
	
	public static Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNivel(dto.getNivel());
        
        return cliente;
    }
}
