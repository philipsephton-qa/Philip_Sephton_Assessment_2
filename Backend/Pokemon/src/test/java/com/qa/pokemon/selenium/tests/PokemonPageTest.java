package com.qa.pokemon.selenium.tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pokemon.selenium.pages.PokemonHomePage;

public class PokemonPageTest {
	public WebDriver driver;
	
	@BeforeEach
	void init() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 763));
	}
	
	@Test
	void getIndexPage() {
		driver.get("http://127.0.0.1:5500/index.html");
		assertTrue(driver.getTitle().contains("Home"));
	}
	@Test
	void createPokemonTest() {
		driver.get("http://127.0.0.1:5500/index.html");
		PokemonHomePage page = PageFactory.initElements(driver, PokemonHomePage.class);
		page.getModalButton().click();
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getAddBtn()));
		page.pokemonCreate("1", "bulbasaur", "3", "3", "3", "grass", "poison", "fire", "ground", "true");
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getDatabank()));
		assertTrue(page.getDatabank().getText().contains("bulbasaur"));
	}
	
	
	
	
	
	@AfterEach
	void closeDriver() {
		driver.close();
	}

}
