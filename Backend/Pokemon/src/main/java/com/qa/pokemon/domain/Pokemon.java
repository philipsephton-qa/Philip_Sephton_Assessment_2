package com.qa.pokemon.domain;


public class Pokemon {

	private Long id;
	private Long pokeDex;
	private String name;
	private String type1;
	private String type2;
	private Long attack;
	private Long defence;
	private Long speed;
	private String weakness1;
	private String weakness2;
	private Boolean evolves;


	public Pokemon() {
		super();
	}
	public Pokemon(Long id, Long pokeDex, String name, String type1, String type2, Long attack, Long defence,
			Long speed, String weakness1, String weakness2, Boolean evolves) {
		super();
		this.id = id;
		this.pokeDex = pokeDex;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.attack = attack;
		this.defence = defence;
		this.speed = speed;
		this.weakness1 = weakness1;
		this.weakness2 = weakness2;
		this.evolves = evolves;
	}
	public Pokemon(Long pokeDex, String name, String type1, String type2, Long attack, Long defence, Long speed,
			String weakness1, String weakness2, Boolean evolves) {
		super();
		this.pokeDex = pokeDex;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.attack = attack;
		this.defence = defence;
		this.speed = speed;
		this.weakness1 = weakness1;
		this.weakness2 = weakness2;
		this.evolves = evolves;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPokeDex() {
		return pokeDex;
	}
	public void setPokeDex(Long pokeDex) {
		this.pokeDex = pokeDex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public Long getAttack() {
		return attack;
	}
	public void setAttack(Long attack) {
		this.attack = attack;
	}
	public Long getDefence() {
		return defence;
	}
	public void setDefence(Long defence) {
		this.defence = defence;
	}
	public Long getSpeed() {
		return speed;
	}
	public void setSpeed(Long speed) {
		this.speed = speed;
	}
	public String getWeakness1() {
		return weakness1;
	}
	public void setWeakness1(String weakness1) {
		this.weakness1 = weakness1;
	}
	public String getWeakness2() {
		return weakness2;
	}
	public void setWeakness2(String weakness2) {
		this.weakness2 = weakness2;
	}
	public Boolean getEvolves() {
		return evolves;
	}
	public void setEvolves(Boolean evolves) {
		this.evolves = evolves;
	}
	
}
