package com.idat.EC3RamirezEmilio.service;

import java.util.List;

import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTORequest;
import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTOResponse;



public interface UsuarioClienteService {
	
	public void guardarUsuario(UsuarioClienteDTORequest usuario);
	public void editarUsuario(UsuarioClienteDTORequest usuario);
	public void eliminarUsuario(Integer id);
	public List<UsuarioClienteDTOResponse> listarUsuario();
	public UsuarioClienteDTOResponse obtenerUsuarioId(Integer id);

}
