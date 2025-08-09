package com.github.cmath0.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cmath0.ecommerce.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
