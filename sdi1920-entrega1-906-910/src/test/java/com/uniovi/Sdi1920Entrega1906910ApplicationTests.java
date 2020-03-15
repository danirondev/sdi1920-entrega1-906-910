package com.uniovi;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.pageobjects.PO_HomeView;
import com.uniovi.pageobjects.PO_LoginView;
import com.uniovi.pageobjects.PO_Properties;
import com.uniovi.pageobjects.PO_RegisterView;
import com.uniovi.pageobjects.PO_View;
import com.uniovi.utils.SeleniumUtils;

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
	
	//PR01. Registro de Usuario con datos válidos /  
	@Test
	public void PR01() {
		//Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "ramonGlez@email.com", "Glo", "Perez", "99009900", "99009900");
		//Comprobamos que entramos en la seccion privada
		PO_View.checkElement(driver, "text", "Esta es una zona privada de la web");
	}
	
	//PR02. Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos vacíos). /  
	@Test
	public void PR02() {
		//Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "", "", "", "99009900", "99009900");
		//Comprobamos que muestra los errores correspondientes
		PO_View.checkElement(driver, "text", "Registráte como usuario");
	}
	
	//PR03. Registro de Usuario con datos inválidos (repetición de contraseña inválida). /  
	@Test
	public void PR03() {
		//Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "Eustaquio@email.com", "Eustaquio", "Perez Perez", "99009900", "1");
		//Comprobamos que muestra los errores correspondientes
		PO_View.checkElement(driver, "text", "Las contraseñas no coinciden");
	}
	
	//PR04. Registro de Usuario con datos inválidos (email existente). /
	@Test
	public void PR04() {
		//Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "ramon@email.com", "Eustaquio", "Perez Perez", "99009900", "99009900");
		//Comprobamos que muestra los errores correspondientes
		PO_View.checkElement(driver, "text", "Este email ya existe.");
	}
	
	//PR05. Inicio de sesión con datos válidos (administrador). /
	@Test
	public void PR05() {
		//Vamos al formulario de identificación
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "admin@email.com", "admin");
		//Comprobamos que entramos en la seccion privada
		PO_View.checkElement(driver, "text", "Esta es una zona privada de la web");
	}
	
	//PR06. Inicio de sesión con datos válidos (usuario estándar). /
	@Test
	public void PR06() {
		//Vamos al formulario de identificación
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
		//Comprobamos que entramos en la seccion privada
		PO_View.checkElement(driver, "text", "Esta es una zona privada de la web");
	}
	
	//PR07. Inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos). /
	@Test
	public void PR07() {
		//Vamos al formulario de identificación
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "", "");
		//Comprobamos que muestra los errores correspondientes
		PO_View.checkElement(driver, "text", "Idéntificate");
	}
	
	//PR08.  Inicio de sesión con datos válidos (usuario estándar, email existente, pero contraseña incorrecta). /
	@Test
	public void PR08() {
		//Vamos al formulario de identificación
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "ramon@email.com", "vvvvv");
		//Comprobamos que muestra los errores correspondientes		
		PO_View.checkElement(driver, "text", "Your username and password is invalid.");
	}
	
	//PR09.  Hacer click en la opción de salir de sesión y comprobar que se redirige a la página de inicio de sesión (Login). /
	@Test
	public void PR09() {
		//Clickamos en el boton de deslogearnos
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");		
		//Comprobamos que muestra la confirmación de habernos desloggeado.	
		PO_View.checkElement(driver, "text", "Idéntificate");
	}
	
	//PR10. Comprobar que el botón cerrar sesión no está visible si el usuario no está autenticado. /
	@Test
	public void PR10() {
		//Comprobamos que no se muestra el boton de desconectar.
		
	}
	
	//PR06. Buscador
//		@Test
//		public void PR0655555() {
//			//Vamos al formulario de registro
//			PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_RegisterView.fillForm(driver, "Eustaquio@email.com", "Eustaquio", "Perez Perez", "99009900", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Notas del usuario");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios
//			PO_HomeView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Vamos al buscador y tecleamos "Eustaquio". Luego, clicamos el botón de "buscar".
//			PO_HomeView.writeOnSeeker(driver, "Eustaquio");
//			//Comprobamos que encuentra el usuario recien creado
//			PO_View.checkElement(driver, "text", "Eustaquio@email.com");
//	}
		
	//Al finalizar la última prueba 
//	@AfterClass 
//	@Test
//	static public void end() { 
//		//Cerramos el navegador al finalizar las pruebas 
//		driver.quit(); 
//	}
}