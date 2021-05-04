package com.qa.pokemon.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qa.pokemon.domain.Pokemon;
@Component
public interface Service {
	boolean create(Pokemon p);
	List<Pokemon> getAll();
	Pokemon getById(int id);
	Pokemon updatePokemon(int id, Pokemon p);
	Pokemon removePokemon(int id);
	

}
