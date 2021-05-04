package com.qa.pokemon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.qa.pokemon.domain.Pokemon;
@Component
public class PokemonService implements Service{
	private List<Pokemon> pokemonList = new ArrayList<>();

	@Override
	public boolean create(Pokemon p) {
		return this.pokemonList.add(p);
	}

	@Override
	public List<Pokemon> getAll() {
		return this.pokemonList;
	}

	@Override
	public Pokemon getById(int id) {
		return this.pokemonList.get(id);
	}

	@Override
	public Pokemon updatePokemon(int id, Pokemon p) {
		return this.pokemonList.set(id, p);
		}

	@Override
	public Pokemon removePokemon(int id) {
		return this.pokemonList.remove(id);
	}


}
