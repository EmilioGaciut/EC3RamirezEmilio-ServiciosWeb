package com.idat.EC3RamirezEmilio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.EC3RamirezEmilio.dto.HospitalDTORequest;
import com.idat.EC3RamirezEmilio.dto.HospitalDTOResponse;
import com.idat.EC3RamirezEmilio.modelo.Hospital;
import com.idat.EC3RamirezEmilio.repository.HospitalRepository;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository repository;
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		repository.save(h);

	}

	@Override
	public void editarHospital(HospitalDTORequest hospital) {
		// TODO Auto-generated method stub
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		List<HospitalDTOResponse> lista = new ArrayList<HospitalDTOResponse>();
		HospitalDTOResponse h = null; 
		for (Hospital hospital :repository.findAll()) {
			h = new HospitalDTOResponse();
			h.setIdHospitalDTO(hospital.getIdHospital());
			h.setNombreDTO(hospital.getNombre());
			h.setDescripcionDTO(hospital.getDescripcion());
			h.setDistritoDTO(hospital.getDistrito());

			lista.add(h);
			
		}
		return lista;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse h = new HospitalDTOResponse();
	
		h.setIdHospitalDTO(hospital.getIdHospital());
		h.setNombreDTO(hospital.getNombre());
		h.setDescripcionDTO(hospital.getDescripcion());
		h.setDistritoDTO(hospital.getDistrito());
		return h;
	}

}
