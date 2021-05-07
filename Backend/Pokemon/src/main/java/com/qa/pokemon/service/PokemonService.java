package com.qa.pokemon.service;

import java.util.List;
import java.util.Optional;

import com.qa.pokemon.domain.Pokemon;
import com.qa.pokemon.repo.PokemonRepo;

@org.springframework.stereotype.Service
public class PokemonService implements Service{
	
	private PokemonRepo repo;
	public PokemonService(PokemonRepo repo) {
		this.repo = repo;
	}

	@Override
	public Pokemon create(Pokemon p) {
		return this.repo.save(p);
	}

	@Override
	public List<Pokemon> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Pokemon getById(Long id) {
		Pokemon optionalCharacter = this.repo.findById(id).orElseThrow();
		return optionalCharacter;
	}

	@Override
	public Pokemon updatePokemon(Long id, Pokemon p) {
		Pokemon pokemonToUpdate = repo.findById(id).orElseThrow();
		pokemonToUpdate.setAttack(p.getAttack());
		pokemonToUpdate.setDefence(p.getDefence());
		pokemonToUpdate.setEvolves(p.getEvolves());
		pokemonToUpdate.setName(p.getName());
		pokemonToUpdate.setPokeDex(p.getPokeDex());
		pokemonToUpdate.setSpeed(p.getSpeed());
		pokemonToUpdate.setType1(p.getType1());
		pokemonToUpdate.setType2(p.getType2());
		pokemonToUpdate.setWeakness1(p.getWeakness1());
		pokemonToUpdate.setWeakness2(p.getWeakness2());
		return this.repo.saveAndFlush(pokemonToUpdate);
		
		}

	@Override
	public boolean removePokemon(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}


}
