package com.qa.pokemon.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qa.pokemon.domain.Pokemon;
@Component
public interface Service {
	Pokemon create(Pokemon p);
	List<Pokemon> getAll();
	Pokemon getById(Long id);
	Pokemon updatePokemon(Long id, Pokemon p);
	boolean removePokemon(Long id);
	

}
