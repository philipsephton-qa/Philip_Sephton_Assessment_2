package com.qa.pokemon.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import com.qa.pokemon.domain.Pokemon;
import com.qa.pokemon.repo.PokemonRepo;

@SpringBootTest
public class PokemonServiceUnitTest {
	
	@Autowired
	private PokemonService service;
	
	@MockBean
	private PokemonRepo repo;
	
	@Test
	void testCreate() {
		Pokemon bulbasaur = new Pokemon(1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		Pokemon savedBulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		Mockito.when(this.repo.save(bulbasaur)).thenReturn(savedBulbasaur);
		assertThat(this.service.create(bulbasaur)).isEqualTo(savedBulbasaur);
		Mockito.verify(this.repo, Mockito.times(1)).save(bulbasaur);
	}
	@Test
	void testGetAll() {
		Pokemon bulbasaur = new Pokemon(1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		Pokemon savedBulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		Mockito.when(this.repo.save(bulbasaur)).thenReturn(savedBulbasaur);
		assertThat(this.service.create(bulbasaur)).isEqualTo(savedBulbasaur);
		Mockito.verify(this.repo, Mockito.times(1)).save(bulbasaur);
	}
	@Test
	void testGetById() {
		Pokemon bulbasaur = new Pokemon(2L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		this.repo.save(bulbasaur);
		Mockito.when(this.repo.findAllById(bulbasaur, 2L)).thenReturn(bulbasaur);
		assertThat(this.service.getById(1L)).isEqualTo(bulbasaur);
		Mockito.verify(this.repo, Mockito.times(1)).getOne(1L);
	}
	@Test
	void testpdate() {
		Pokemon bulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		Pokemon savedBulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 4L, 3L, "fire", "ground", true);
		Mockito.when(this.repo.getOne(1L)).thenReturn(bulbasaur);
		assertThat(this.service.updatePokemon(1L, bulbasaur)).isEqualTo(savedBulbasaur);
		Mockito.verify(this.repo, Mockito.times(1)).save(bulbasaur);
	}
	@Test
	void testRemove() {
		Mockito.when(this.repo.deleteById(1L)).thenReturn(!this.repo.existsById(1L));
		assertThat(this.service.removePokemon(1L)).isEqualTo(!this.repo.existsById(1L));
		Mockito.verify(this.repo, Mockito.times(1));
	}

}
