package com.miguel.DojosNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.DojosNinjas.Models.Dojo;
import com.miguel.DojosNinjas.Repositories.DojoRepository;

@Service
public class DojoService {

	//	se inyecta dependecia
	
	private final DojoRepository dojoRepository;
	
	//Constructor
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	//	Crea un nuevo dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//obtiene todos los Dojo
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}
	
	// busca los dojo por ID
	public Dojo findDojo(Long id) {
		Optional<Dojo> findDojo = dojoRepository.findById(id);
		if(findDojo.isPresent()) {
			System.out.println(findDojo.get());
			return findDojo.get();
		} else {
			return null;
		}
	}
	
	
	
	
	
}


