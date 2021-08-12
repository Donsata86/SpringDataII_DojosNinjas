package com.miguel.DojosNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.miguel.DojosNinjas.Models.Ninja;
import com.miguel.DojosNinjas.Repositories.NinjaRepository;

@Service
public class NinjaService {

//	se inyecta dependecia
	private final NinjaRepository ninjaRepository;
	
	//Constructor
	public NinjaService(NinjaRepository ninjarepository) {
		this.ninjaRepository = ninjarepository;
	}
	
	//Crea un nuevo ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//obtiene todos los Ninjas
	
	public List<Ninja> findAll(){
		return ninjaRepository.findAll();
	}

	
	
	// busca los ninjas por ID
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> findNinja = ninjaRepository.findById(id);
		if(findNinja.isPresent()) {
			System.out.println(findNinja.get());
			return findNinja.get();
		} else {
			return null;
		}
	}
}
