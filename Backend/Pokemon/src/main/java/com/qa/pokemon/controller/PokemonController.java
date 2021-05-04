package com.qa.pokemon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokemon.domain.Pokemon;
import com.qa.pokemon.service.PokemonService;

@RestController
public class PokemonController {
	private PokemonService service;
	public PokemonController(PokemonService service) {
	this.service = service; 
	}
	//CRUD
	
	//CREATE
	@PostMapping("/create")
	public ResponseEntity<Pokemon> createCharacter(@RequestBody Pokemon pokemon) {
		this.service.create(pokemon);
		return new ResponseEntity<Pokemon>(HttpStatus.CREATED);
	}
	
	//READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Pokemon>> getPokemon(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	//READ ONE
	@GetMapping("/getOne/{index}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable int index) {
		return ResponseEntity.ok(this.service.getById(index));
	}
	
	//UPDATE
	@PostMapping("/update/{index}")
	public ResponseEntity<Pokemon> updatePokemon(@PathVariable int index,@RequestBody Pokemon pokemon) {
		return ResponseEntity.ok(this.service.updatePokemon(index, pokemon));
	}
	
	//DELETE
	@DeleteMapping("/remove/{index}")
	public ResponseEntity<Pokemon> removePokemon(@PathVariable int index) {
		return ResponseEntity.ok(this.service.removePokemon(index));
	}


}
