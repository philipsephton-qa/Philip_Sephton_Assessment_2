package com.qa.pokemon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.pokemon.domain.Pokemon;
import com.qa.pokemon.service.PokemonService;

@RestController
@CrossOrigin
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
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long index) {
		return ResponseEntity.ok(this.service.getById(index));
	}
	
	//UPDATE
	@PutMapping("/update/{index}")
	public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long index,@RequestBody Pokemon pokemon) {
		this.service.updatePokemon(index, pokemon);
		return new ResponseEntity<Pokemon>( HttpStatus.ACCEPTED);
	}
	
	//DELETE
	@DeleteMapping("/remove/{index}")
	public ResponseEntity<Boolean> removePokemon(@PathVariable Long index) {
		return ResponseEntity.ok(this.service.removePokemon(index));
	}


}
