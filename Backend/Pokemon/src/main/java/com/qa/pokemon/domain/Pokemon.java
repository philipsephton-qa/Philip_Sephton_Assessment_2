package com.qa.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attack == null) ? 0 : attack.hashCode());
		result = prime * result + ((defence == null) ? 0 : defence.hashCode());
		result = prime * result + ((evolves == null) ? 0 : evolves.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pokeDex == null) ? 0 : pokeDex.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
		result = prime * result + ((weakness1 == null) ? 0 : weakness1.hashCode());
		result = prime * result + ((weakness2 == null) ? 0 : weakness2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (attack == null) {
			if (other.attack != null)
				return false;
		} else if (!attack.equals(other.attack))
			return false;
		if (defence == null) {
			if (other.defence != null)
				return false;
		} else if (!defence.equals(other.defence))
			return false;
		if (evolves == null) {
			if (other.evolves != null)
				return false;
		} else if (!evolves.equals(other.evolves))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokeDex == null) {
			if (other.pokeDex != null)
				return false;
		} else if (!pokeDex.equals(other.pokeDex))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		if (type1 == null) {
			if (other.type1 != null)
				return false;
		} else if (!type1.equals(other.type1))
			return false;
		if (type2 == null) {
			if (other.type2 != null)
				return false;
		} else if (!type2.equals(other.type2))
			return false;
		if (weakness1 == null) {
			if (other.weakness1 != null)
				return false;
		} else if (!weakness1.equals(other.weakness1))
			return false;
		if (weakness2 == null) {
			if (other.weakness2 != null)
				return false;
		} else if (!weakness2.equals(other.weakness2))
			return false;
		return true;
	}
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
