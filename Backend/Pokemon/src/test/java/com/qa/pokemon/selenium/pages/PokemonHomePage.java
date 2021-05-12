package com.qa.pokemon.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PokemonHomePage {
	
	@FindBy(id= "imabutton")
	private WebElement modalButton;
	
	@FindBy(id= "pokedex")
	private WebElement pokedex;
	
	@FindBy(id= "pokemonName")
	private WebElement pokemonName;
	
	@FindBy(id= "pokemonAtt")
	private WebElement pokemonAtt;
	
	@FindBy(id= "pokemonDef")
	private WebElement pokemonDef;
	
	@FindBy(id= "pokemonSpd")
	private WebElement pokemonSpd;
	
	@FindBy(id= "pokemonPrimaryType")
	private WebElement pokemonPrimaryType;
	
	@FindBy(id= "pokemonSecondaryType")
	private WebElement pokemonSecondaryType;
	
	@FindBy(id= "pokemonPrimaryWeakness")
	private WebElement pokemonPrimaryWeakness;
	
	@FindBy(id= "pokemonSecondaryWeakness")
	private WebElement pokemonSecondaryWeakness;

	@FindBy(id= "evolves")
	private WebElement evolves;

	@FindBy(id= "addBtn")
	private WebElement addBtn;
	
	@FindBy(id="dataBank")
	private WebElement dataBank;
	
	@FindBy(id= "updateSubmitButton")
	private WebElement updateSubmitButton;
	
	@FindBy(id="updBtn")
	private WebElement updBtn;
	
	@FindBy(id= "pokedexUp")
	private WebElement dexUp;
	
	@FindBy(id= "pokemonNameUp")
	private WebElement nameUp;
	
	@FindBy(id= "pokemonAttUp")
	private WebElement attUp;
	
	@FindBy(id= "pokemonDefUp")
	private WebElement defUp;
	
	@FindBy(id= "pokemonSpdUp")
	private WebElement spdUp;
	
	@FindBy(id= "pokemonPrimaryTypeUp")
	private WebElement type1Up;
	
	@FindBy(id= "pokemonSecondaryTypeUp")
	private WebElement type2Up;
	
	@FindBy(id= "pokemonPrimaryWeaknessUp")
	private WebElement weakness1Up;
	
	@FindBy(id= "pokemonSecondaryWeaknessUp")
	private WebElement weakness2Up;

	@FindBy(id= "evolvesUp")
	private WebElement evUp;
	
	@FindBy(id="removePokemonButton")
	private WebElement rmBtn;
	
	public WebElement getRmBtn() {
		return rmBtn;
	}
	
	public WebElement getDatabank() {
		return dataBank;
	}

	public WebElement getModalButton() {
		return modalButton;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}
	
	public WebElement getUpdateBtn() {
		return updateSubmitButton;
	}
	
	public WebElement getUpdBtn() {
		return updBtn;
	}

	public void pokemonCreate(String pokedex1, String pokemonName1, String pokemonAtt1, String pokemonDef1,
			String pokemonSpd1, String pokemonPrimaryType1, String pokemonSecondaryType1,
			String pokemonPrimaryWeakness1, String pokemonSecondaryWeakness1, String evolves1) {
		pokedex.sendKeys(pokedex1);
		pokemonName.sendKeys(pokemonName1);
		pokemonAtt.sendKeys(pokemonAtt1);
		pokemonDef.sendKeys(pokemonDef1);
		pokemonSpd.sendKeys(pokemonSpd1);
		pokemonPrimaryType.sendKeys(pokemonPrimaryType1);
		pokemonSecondaryType.sendKeys(pokemonSecondaryType1);
		pokemonPrimaryWeakness.sendKeys(pokemonPrimaryWeakness1);
		pokemonSecondaryWeakness.sendKeys(pokemonSecondaryWeakness1);
		evolves.sendKeys(evolves1);
		addBtn.click();
	}
	
	public void updatePokemon(String poke, String pNameUp, String pAttUp, String pDefUp, String pSpdUp, String pType1Up, String pType2Up, String pWeakness1Up, String pWeakness2Up, String pEvUp) {
		dexUp.sendKeys(poke);
		nameUp.sendKeys(pNameUp);
		attUp.sendKeys(pNameUp);
		defUp.sendKeys(pDefUp);
		spdUp.sendKeys(pSpdUp);
		type1Up.sendKeys(pType1Up);
		type2Up.sendKeys(pType2Up);
		weakness1Up.sendKeys(pWeakness1Up);
		weakness2Up.sendKeys(pWeakness2Up);
		evUp.sendKeys(pEvUp);
		updBtn.click();
	}
	


}
