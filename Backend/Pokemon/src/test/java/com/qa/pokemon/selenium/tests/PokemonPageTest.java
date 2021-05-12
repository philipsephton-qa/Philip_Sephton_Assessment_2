package com.qa.pokemon.selenium.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import com.qa.pokemon.selenium.pages.PokemonHomePage;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PokemonPageTest {
	
	@LocalServerPort
	int randomPort;

	private static final String URLPre = "http://127.0.0.1:";
	private static final String URLSuff = "/index.html";
	
	public WebDriver driver;

	@BeforeEach
	void init() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1366, 763));
	}

	@Test
	void getIndexPage() {
		driver.get(URLPre+randomPort+URLSuff);
		assertTrue(driver.getTitle().contains("Home"));
	}

	@Test
	void createPokemonTest() {
		driver.get(URLPre+randomPort+URLSuff);
		PokemonHomePage page = PageFactory.initElements(driver, PokemonHomePage.class);
		page.getModalButton().click();
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getAddBtn()));
		page.pokemonCreate("1", "bulbasaur", "3", "3", "3", "grass", "poison", "fire", "ground", "yes");
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getDatabank()));
		assertTrue(page.getDatabank().getText().contains("bulbasaur"));
	}

	@Test
	void updatePokemonTest(){
		driver.get(URLPre+randomPort+URLSuff);
		PokemonHomePage page = PageFactory.initElements(driver, PokemonHomePage.class);
		page.getUpdateBtn().click();
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getUpdBtn()));
		page.updatePokemon("7", "charmander", "4", "4", "3", "fire", "flying", "water", "rock", "yes");
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(page.getDatabank()));
		assertFalse(page.getDatabank().getText().contains("charmander"));

	}
	
	@Test
	void deletePokemonTest() {
		driver.get(URLPre+randomPort+URLSuff);
		PokemonHomePage page = PageFactory.initElements(driver, PokemonHomePage.class);
		Object initialPage = page.getDatabank().getText();
		page.getRmBtn().click();
		Object finalPage = page.getDatabank().getText();
		assertFalse(finalPage == initialPage);
	}

	@AfterEach
	void closeDriver() {
		driver.close();
	}

}
