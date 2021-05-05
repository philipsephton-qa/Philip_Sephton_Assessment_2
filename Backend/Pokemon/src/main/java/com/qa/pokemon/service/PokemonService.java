package com.qa.pokemon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Component;
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
		Optional<Pokemon> optionalCharacter = this.repo.findById(id);
		return optionalCharacter.get();
	}

	@Override
	public Pokemon updatePokemon(Long id, Pokemon p) {
		Optional<Pokemon> pokemonToUpdate = repo.findById(id);
		pokemonToUpdate.get().setAttack(p.getAttack());
		pokemonToUpdate.get().setDefence(p.getDefence());
		pokemonToUpdate.get().setEvolves(p.getEvolves());
		pokemonToUpdate.get().setName(p.getName());
		pokemonToUpdate.get().setPokeDex(p.getPokeDex());
		pokemonToUpdate.get().setSpeed(p.getSpeed());
		pokemonToUpdate.get().setType1(p.getType1());
		pokemonToUpdate.get().setType2(p.getType2());
		pokemonToUpdate.get().setWeakness1(p.getWeakness1());
		pokemonToUpdate.get().setWeakness2(p.getWeakness2());
		return this.repo.saveAndFlush(null);
		
		}

	@Override
	public boolean removePokemon(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}


}
