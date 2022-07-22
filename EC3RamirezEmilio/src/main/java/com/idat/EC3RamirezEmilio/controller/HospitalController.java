package com.idat.EC3RamirezEmilio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.EC3RamirezEmilio.dto.HospitalDTORequest;
import com.idat.EC3RamirezEmilio.dto.HospitalDTOResponse;
import com.idat.EC3RamirezEmilio.service.HospitalService;




@RequestMapping("/reservacita")
public class HospitalController {


	@Autowired
	private HospitalService servicio;
	
	@RequestMapping(path = "/hospital/listar", method = RequestMethod.GET)
	public ResponseEntity<List<HospitalDTOResponse>> listarHospitales(){
		return new ResponseEntity<List<HospitalDTOResponse>>(servicio.listarHospital(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/hospital/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody HospitalDTORequest hospital){
		servicio.guardarHospital(hospital);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);	
	}
	
	@RequestMapping(path = "/hospital/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<HospitalDTOResponse> listarPorId(@PathVariable Integer id) {
		HospitalDTOResponse c = servicio.obtenerHospitalId(id);
		if(c != null) {
			return new ResponseEntity<HospitalDTOResponse>(c, HttpStatus.OK);
		}
		return new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/hospital/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody HospitalDTORequest hospital){
		HospitalDTOResponse c = servicio.obtenerHospitalId(hospital.getIdHospitalDTO());
		if(c != null) {
			servicio.editarHospital(hospital);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/hospital/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		HospitalDTOResponse c = servicio.obtenerHospitalId(id);
		if(c != null) {
			servicio.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
