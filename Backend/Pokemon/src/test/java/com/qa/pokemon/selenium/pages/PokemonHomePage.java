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
	
	public WebElement getDatabank() {
		return dataBank;
	}

	public WebElement getModalButton() {
		return modalButton;
	}

	public WebElement getAddBtn() {
		return addBtn;
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
	


}
