package com.qa.pokemon.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.pokemon.domain.Pokemon;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"})
public class PokemonControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Pokemon bulbasaur = new Pokemon(2L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		String bulbasaurAsJSON = this.mapper.writeValueAsString(bulbasaur);
		RequestBuilder mockRequest =
				post("/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(bulbasaurAsJSON);
		Pokemon savedBulbasaur = new Pokemon(2L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		String savedBulbasaurAsJSON = this.mapper.writeValueAsString(savedBulbasaur);
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedBulbasaurAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	@Test
	void testRead() throws Exception {
		RequestBuilder mockRequest =
				get("/getAll");
		ResultMatcher matchStatus = status().isOk();
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
	}
	@Test
	void testReadOne() throws Exception {
		RequestBuilder mockRequest =
				get("/getOne/1");
		Pokemon savedBulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 3L, 3L, "fire", "ground", true);
		String savedBulbasaurAsJSON = this.mapper.writeValueAsString(savedBulbasaur);
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedBulbasaurAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
	@Test
	void testUpdate() throws Exception {
		Pokemon bulbasaur = new Pokemon(1L, "bulbasaur", "grass", "poison", 3L, 4L, 3L, "fire", "ground", true);
		String bulbasaurAsJSON = this.mapper.writeValueAsString(bulbasaur);
		RequestBuilder mockRequest =
				put("/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(bulbasaurAsJSON);
//		Pokemon savedBulbasaur = new Pokemon(1L, 1L, "bulbasaur", "grass", "poison", 3L, 4L, 3L, "fire", "ground", true);
//		String savedBulbasaurAsJSON = this.mapper.writeValueAsString(savedBulbasaur);
		ResultMatcher matchStatus = status().isAccepted();
//		ResultMatcher matchBody = content().json(savedBulbasaurAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);//.andExpect(matchBody);
	}
	@Test
	void testDelete() throws Exception {
		RequestBuilder mockRequest =
				delete("/remove/1");
		ResultMatcher matchStatus = status().isOk();
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
	}
}
