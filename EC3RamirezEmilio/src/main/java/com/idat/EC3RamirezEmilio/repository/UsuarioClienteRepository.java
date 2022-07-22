package com.idat.EC3RamirezEmilio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.EC3RamirezEmilio.modelo.UsuarioCliente;



public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {

	UsuarioCliente findByUsuario(String username);

}
