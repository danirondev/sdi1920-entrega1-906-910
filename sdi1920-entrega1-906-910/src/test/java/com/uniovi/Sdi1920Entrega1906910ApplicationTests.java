package com.uniovi;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters; 

//Ordenamos las pruebas por el nombre del método 
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 

public class Sdi1920Entrega1906910ApplicationTests {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizaciones automáticas)): 
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe"; 
	static String Geckdriver024 = "C:\\Path\\geckodriver024win64.exe"; 
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024); 
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	//Antes de cada prueba se navega al URL home de la aplicaciónn 
	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL); 
	}

	//Después de cada prueba se borran las cookies del navegador 
	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies(); 
	}

	//Antes de la primera prueba   
	@BeforeClass 
	static public void begin() { 
		
	}
	
	//Al finalizar la última prueba 
	@AfterClass 
	@Test
	static public void end() { 
		//Cerramos el navegador al finalizar las pruebas 
		driver.quit(); 
	}
	
	public void test() {
		fail("Not yet implemented");
	}

}