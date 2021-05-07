package com.qa.pokemon.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import com.qa.pokemon.domain.Pokemon;
import com.qa.pokemon.repo.PokemonRepo;

@SpringBootTest
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"})
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
		Pokemon bulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		List<Pokemon> savedBulbasaur = new ArrayList<>();
		savedBulbasaur.add(bulbasaur);
		Mockito.when(this.repo.findAll()).thenReturn(savedBulbasaur);
		assertThat(this.service.getAll().isEmpty()).isEqualTo(false);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	@Test
	void testGetById() {
		Long id = 1L;
		Optional<Pokemon> bulbasaur = Optional.ofNullable(new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true));
		Mockito.when(this.repo.findById(id)).thenReturn(bulbasaur);
		assertThat(this.service.getById(id)).isNotNull();
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	@Test
	void testUpdate() {
		Long id = 1L;
		Pokemon bulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 4L, 3L, "fire", "ground", true);
		Optional<Pokemon> savedBulbasaur = Optional.ofNullable(new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 4L, 3L, "fire", "ground", true));
		Mockito.when(this.repo.findById(id)).thenReturn(savedBulbasaur);
		Mockito.when(this.repo.saveAndFlush(bulbasaur)).thenReturn(bulbasaur);
		assertThat(this.service.updatePokemon(1L, bulbasaur)).isNotNull();
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(bulbasaur);
	}
	@Test
	void testRemove() {
		assertThat(this.service.removePokemon(1L)).isEqualTo(!this.repo.existsById(1L));
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
	}

}
