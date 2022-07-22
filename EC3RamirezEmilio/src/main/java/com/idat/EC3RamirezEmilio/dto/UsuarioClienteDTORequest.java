package com.idat.EC3RamirezEmilio.dto;

import com.idat.EC3RamirezEmilio.modelo.Cliente;

public class UsuarioClienteDTORequest {

	private int idUsuarioDTO;
	private String usuarioDTO;
	private String passwordDTO;
	private String rolDTO;
	private Cliente clienteDTO;
	
	public int getIdUsuarioDTO() {
		return idUsuarioDTO;
	}
	public void setIdUsuarioDTO(int idUsuarioDTO) {
		this.idUsuarioDTO = idUsuarioDTO;
	}
	public String getUsuarioDTO() {
		return usuarioDTO;
	}
	public void setUsuarioDTO(String usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	public String getPasswordDTO() {
		return passwordDTO;
	}
	public void setPasswordDTO(String passwordDTO) {
		this.passwordDTO = passwordDTO;
	}
	public String getRolDTO() {
		return rolDTO;
	}
	public void setRolDTO(String rolDTO) {
		this.rolDTO = rolDTO;
	}
	public Cliente getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(Cliente clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	
}
