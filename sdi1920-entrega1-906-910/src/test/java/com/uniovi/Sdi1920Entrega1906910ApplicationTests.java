package com.uniovi;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.pageobjects.PO_HomeView;
import com.uniovi.pageobjects.PO_Properties;

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
	
	//PR01. Acceder a la página principal /  
	@Test  
	public void PR01() {  
		PO_HomeView.checkWelcome(driver, PO_Properties.getSPANISH()); 
	} 
	
	//PR02. OPción de navegación. Pinchar en el enlace Registro en la página home 
	@Test
	public void PR02() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
	}
	
	//PR03. OPción de navegación. Pinchar en el enlace Identificate en la página home 
	@Test
	public void PR03() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
	}
	
	//PR04. OPción de navegación. Cambio de idioma de Español a Ingles y vuelta a Español 
	@Test  
	public void PR04() {   
		PO_HomeView.checkChangeIdiom(driver, "btnSpanish", "btnEnglish", PO_Properties.getSPANISH(), PO_Properties.getENGLISH()); 
		//SeleniumUtils.esperarSegundos(driver, 2); 
		driver.quit(); 
	}
	
	//Al finalizar la última prueba 
//	@AfterClass 
//	@Test
//	static public void end() { 
//		//Cerramos el navegador al finalizar las pruebas 
//		driver.quit(); 
//	}
}