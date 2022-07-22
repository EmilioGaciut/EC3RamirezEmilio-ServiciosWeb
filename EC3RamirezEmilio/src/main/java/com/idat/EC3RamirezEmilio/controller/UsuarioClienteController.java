package com.idat.EC3RamirezEmilio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTORequest;
import com.idat.EC3RamirezEmilio.dto.UsuarioClienteDTOResponse;
import com.idat.EC3RamirezEmilio.service.UsuarioClienteService;


@RequestMapping("/reservacita")
public class UsuarioClienteController {

	@Autowired
	private UsuarioClienteService servicio;
	
	@RequestMapping(path = "/usuario/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioClienteDTOResponse>> listarUsuarios(){
		return new ResponseEntity<List<UsuarioClienteDTOResponse>>(servicio.listarUsuario(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/usuario/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteDTORequest usuario){
		servicio.guardarUsuario(usuario);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);	
	}
	
	@RequestMapping(path = "/usuario/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTOResponse> listarPorId(@PathVariable Integer id) {
		UsuarioClienteDTOResponse c = servicio.obtenerUsuarioId(id);
		if(c != null) {
			return new ResponseEntity<UsuarioClienteDTOResponse>(c, HttpStatus.OK);
		}
		return new ResponseEntity<UsuarioClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/usuario/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioClienteDTORequest usuario){
		UsuarioClienteDTOResponse c = servicio.obtenerUsuarioId(usuario.getIdUsuarioDTO());
		if(c != null) {
			servicio.editarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/usuario/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		UsuarioClienteDTOResponse c = servicio.obtenerUsuarioId(id);
		if(c != null) {
			servicio.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
