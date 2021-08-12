package com.miguel.DojosNinjas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miguel.DojosNinjas.Models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

	List<Ninja> findAll();
}
