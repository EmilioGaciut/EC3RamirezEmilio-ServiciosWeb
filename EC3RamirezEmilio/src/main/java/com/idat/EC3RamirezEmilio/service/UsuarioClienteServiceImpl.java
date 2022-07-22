package com.idat.EC3RamirezEmilio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTORequest;
import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTOResponse;
import com.idat.EC3RamirezEmilio.modelo.UsuarioCliente;
import com.idat.EC3RamirezEmilio.repository.UsuarioClienteRepository;
@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {
	@Autowired
	private UsuarioClienteRepository repository;
	@Override
	public void guardarUsuario(UsuarioClienteDTORequest usuario) {
		// TODO Auto-generated method stub
		UsuarioCliente uc= new UsuarioCliente();
		uc.setUsuario(usuario.getUsuarioDTO());
		uc.setPassword(usuario.getPasswordDTO());
		uc.setRol(usuario.getRolDTO());
		uc.setCliente(usuario.getClienteDTO());
		repository.save(uc);
	}

	@Override
	public void editarUsuario(UsuarioClienteDTORequest usuario) {
		// TODO Auto-generated method stub
		UsuarioCliente uc= new UsuarioCliente();
		uc.setUsuario(usuario.getUsuarioDTO());
		uc.setPassword(usuario.getPasswordDTO());
		uc.setRol(usuario.getRolDTO());
		uc.setCliente(usuario.getClienteDTO());
		repository.saveAndFlush(uc);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioClienteDTOResponse> listarUsuario() {
		List<UsuarioClienteDTOResponse> lista = new ArrayList<UsuarioClienteDTOResponse>();
		UsuarioClienteDTOResponse uc = null; 
		for (UsuarioCliente usuariocliente :repository.findAll()) {
			uc = new UsuarioClienteDTOResponse();
			uc.setIdUsuarioDTO(usuariocliente.getIdUsuario());
			uc.setUsuarioDTO(usuariocliente.getUsuario());
			uc.setPasswordDTO(usuariocliente.getPassword());
			uc.setRolDTO(usuariocliente.getRol());
			uc.setClienteDTO(usuariocliente.getCliente());

			lista.add(uc);
			
		}
		return lista;
	}

	@Override
	public UsuarioClienteDTOResponse obtenerUsuarioId(Integer id) {
		UsuarioCliente usuariocliente = repository.findById(id).orElse(null);
		UsuarioClienteDTOResponse uc = new UsuarioClienteDTOResponse();
		uc.setIdUsuarioDTO(usuariocliente.getIdUsuario());
		uc.setUsuarioDTO(usuariocliente.getUsuario());
		uc.setPasswordDTO(usuariocliente.getPassword());
		uc.setRolDTO(usuariocliente.getRol());
		uc.setClienteDTO(usuariocliente.getCliente());
		return uc;
	}

}
