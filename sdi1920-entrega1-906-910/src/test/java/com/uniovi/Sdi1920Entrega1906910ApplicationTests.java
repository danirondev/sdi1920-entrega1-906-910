package com.uniovi;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.pageobjects.PO_HomeView;
import com.uniovi.pageobjects.PO_LoginView;
import com.uniovi.pageobjects.PO_PrivateView;
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
	
//	//PR01. Registro de Usuario con datos válidos /  
//		@Test
//		public void PR01() {
//			//Vamos al formulario de registro
//			PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_RegisterView.fillForm(driver, "ramonGlez@email.com", "Glo", "Perez", "99009900", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//		}
//		
//		//PR02. Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos vacíos). /  
//		@Test
//		public void PR02() {
//			//Vamos al formulario de registro
//			PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_RegisterView.fillForm(driver, "", "", "", "99009900", "99009900");
//			//Comprobamos que muestra los errores correspondientes
//			PO_View.checkElement(driver, "text", "Registrate como usuario");
//		}
//		
//		//PR03. Registro de Usuario con datos inválidos (repetición de contraseña inválida). /  
//		@Test
//		public void PR03() {
//			//Vamos al formulario de registro
//			PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_RegisterView.fillForm(driver, "Eustaquio@email.com", "Eustaquio", "Perez Perez", "99009900", "1");
//			//Comprobamos que muestra los errores correspondientes
//			PO_View.checkElement(driver, "text", "Las contraseñas no coinciden");
//		}
//		
//		//PR04. Registro de Usuario con datos inválidos (email existente). /
//		@Test
//		public void PR04() {
//			//Vamos al formulario de registro
//			PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_RegisterView.fillForm(driver, "ramon@email.com", "Eustaquio", "Perez Perez", "99009900", "99009900");
//			//Comprobamos que muestra los errores correspondientes
//			PO_View.checkElement(driver, "text", "Este email ya existe.");
//		}
//		
//		//PR05. Inicio de sesión con datos válidos (administrador). /
//		@Test
//		public void PR05() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "admin@email.com", "admin");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//		}
//		
//		//PR06. Inicio de sesión con datos válidos (usuario estándar). /
//		@Test
//		public void PR06() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//		}
//		
//		//PR07. Inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos). /
//		@Test
//		public void PR07() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "", "");
//			//Comprobamos que muestra los errores correspondientes
//			PO_View.checkElement(driver, "text", "Identifícate");
//		}
//		
//		//PR08.  Inicio de sesión con datos válidos (usuario estándar, email existente, pero contraseña incorrecta). /
//		@Test
//		public void PR08() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramon@email.com", "vvvvv");
//			//Comprobamos que muestra los errores correspondientes		
//			PO_View.checkElement(driver, "text", "Your username and password is invalid.");
//		}
//		
//		//PR09.  Hacer click en la opción de salir de sesión y comprobar que se redirige a la página de inicio de sesión (Login). /
//		@Test
//		public void PR09() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//			//Comprobamos que muestra la vista para identificarse	
//			PO_View.checkElement(driver, "text", "Identifícate");
//		}
//		
//		//PR10. Comprobar que el botón cerrar sesión no está visible si el usuario no está autenticado. /
//		@Test
//		public void PR10() {
//			//Comprobamos que no se muestra el boton de desconectar.
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Desconectar", PO_View.getTimeout());
//		}
//		
//		//PR11.  Mostrar el listado de usuarios y comprobar que se muestran todos los que existen en el sistema.
//		@Test
//		public void PR11() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Comprobamos cada usuario que debería de aparecer
//			PO_View.checkElement(driver, "text", "pedro@email.com");
//			PO_View.checkElement(driver, "text", "laura@email.com");
//			PO_View.checkElement(driver, "text", "maria@email.com");
//			PO_View.checkElement(driver, "text", "marta@email.com");
//			PO_View.checkElement(driver, "text", "pelayo@email.com");
//			//Pasamos a la segunda página
//			PO_PrivateView.clickNextPage(driver);
//			//Comprobamos cada usuario que debería de aparecer
//			PO_View.checkElement(driver, "text", "ramon@email.com");
//			PO_View.checkElement(driver, "text", "adrimart@email.com");
//			PO_View.checkElement(driver, "text", "dario@email.com");
//			PO_View.checkElement(driver, "text", "pedro12Bel@email.com");
//		}
//		
//		//PR12. Hacer una búsqueda con el campo vacío y comprobar que se muestra la página que corresponde con el listado usuarios existentes en el sistema. 
//		@Test
//		public void PR12() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Vamos al buscador y dejamos el campo vacío. Luego, clicamos el botón de "buscar".
//			PO_PrivateView.writeOnSeeker(driver, "");
//			//Comprobamos cada usuario que debería de aparecer
//			PO_View.checkElement(driver, "text", "pedro@email.com");
//			PO_View.checkElement(driver, "text", "laura@email.com");
//			PO_View.checkElement(driver, "text", "maria@email.com");
//			PO_View.checkElement(driver, "text", "marta@email.com");
//			PO_View.checkElement(driver, "text", "pelayo@email.com");
//			//Pasamos a la segunda página
//			PO_PrivateView.clickNextPage(driver);
//			//Comprobamos cada usuario que debería de aparecer
//			PO_View.checkElement(driver, "text", "ramon@email.com");
//			PO_View.checkElement(driver, "text", "adrimart@email.com");
//			PO_View.checkElement(driver, "text", "dario@email.com");
//			PO_View.checkElement(driver, "text", "pedro12Bel@email.com");
//		
//		}
//		
//		//PR13. Hacer una búsqueda escribiendo en el campo un texto que no exista y comprobar que se muestra la página que corresponde, con la lista de usuarios vacía. 
//		@Test
//		public void PR13() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Vamos al buscador y dejamos el campo vacío. Luego, clicamos el botón de "buscar".
//			PO_PrivateView.writeOnSeeker(driver, "superman");
//			//Comprobamos cada usuario que debería de aparecer
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "pedro@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "laura@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "maria@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "marta@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "pelayo@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "ramon@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "adrimart@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "dario@email.com", PO_View.getTimeout());
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "pedro12Bel@email.com", PO_View.getTimeout());
//		}
//		
//		//PR14. Hacer una búsqueda con un texto específico y comprobar que se muestra la página que corresponde, con la lista de usuarios en los que el texto especificados sea parte de su nombre, apellidos o de su email.
//		@Test
//		public void PR14() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramonGlez@email.com", "99009900");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Vamos al buscador y dejamos el campo vacío. Luego, clicamos el botón de "buscar".
//			PO_PrivateView.writeOnSeeker(driver, "pedro");
//			//Comprobamos cada usuario que debería de aparecer
//			PO_View.checkElement(driver, "text", "pedro@email.com");
//			PO_View.checkElement(driver, "text", "pedro12Bel@email.com");	
//		}
////		
//		//PR15.  Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario. Comprobar que la solicitud de amistad aparece en el listado de invitaciones (punto siguiente).	
//		@Test
//		public void PR15() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramon@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario.
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//			//Comprobamos que muestra la vista para identificarse	
//			PO_View.checkElement(driver, "text", "Identifícate");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "pedro@email.com", "123456");
//			//Navegamos hasta la vista de peticiones
//			PO_PrivateView.goToPetitions(driver);
//			//Comprobamos que tiene una solicitud de Ramon
//			PO_HomeView.checkElement(driver, "text", "Ramon");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//		}
//		
//		//PR16.  Desde el listado de usuarios de la aplicación, enviar una invitación de amistad a un usuario. Comprobar que la solicitud de amistad aparece en el listado de invitaciones (punto siguiente).	
//		@Test
//		public void PR16() {
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramon@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario.
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Comprobamos que sale el dialogo informativo
//			PO_HomeView.checkElement(driver, "text", "Usuario ya añadido");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//		}
//		
//		//PR17. Mostrar el listado de invitaciones de amistad recibidas. Comprobar con un listado que contenga varias invitaciones recibidas. 
//		@Test
//		public void PR17() {
//			// RAMON AÑADE A PEDRO
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "ramon@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario (pedro).
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//			
//			// MARIA AÑADE A PEDRO
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "maria@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario (pedro).
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//			
//			// MARTA AÑADE A PEDRO
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "marta@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario (pedro).
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");	
//			
//			// PELAYO AÑADE A PEDRO
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "pelayo@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a gestion de usuarios y seleccionamos la opcion de ver usuarios. /
//			PO_PrivateView.accessSeeker(driver);
//			//Comprobamos que entramos en la seccion de ver usuarios
//			PO_View.checkElement(driver, "text", "Usuarios");
//			//Añadimos (mandamos una peticion de amistad) al primer usuario (pedro).
//			PO_PrivateView.addUser(driver, "http://localhost:8090/user/1/resend");
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");	
//
//			// PEDRO COMPRUEBA INVITACIONES RECIBIDAS
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "pedro@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a la vista de peticiones recibidas
//			PO_PrivateView.goToPetitions(driver);
//			//Comprobamos que salen los 4 usuarios que han mandado la petición
//			PO_HomeView.checkElement(driver, "text", "Ramon");
//			PO_HomeView.checkElement(driver, "text", "Marta");
//			PO_HomeView.checkElement(driver, "text", "María");
//			PO_HomeView.checkElement(driver, "text", "Pelayo");
//			
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//		}
//		
//		//PR18. Sobre el listado de invitaciones recibidas. Hacer click en el botón/enlace de una de ellas y comprobar que dicha solicitud desaparece del listado de invitaciones. 
//		@Test
//		public void PR18() {
//			// PEDRO SE LOGGEA
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "pedro@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a la vista de peticiones recibidas
//			PO_PrivateView.goToPetitions(driver);
//			//Pedro acepta la primera invitación
//			PO_PrivateView.acceptUser(driver, "http://localhost:8090/user/7/agregar");
//			//Comprobamos que la petición de Ramon ya no está
//			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Ramon", PO_View.getTimeout());
//
//			//Clickamos en el boton de deslogearnos
//			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");		
//		}
//		
//		//PR19. Mostrar el listado de amigos de un usuario. Comprobar que el listado contiene los amigos que deben ser. 
//		@Test
//		public void PR19() {
//			// PEDRO SE LOGGEA
//			//Vamos al formulario de identificación
//			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
//			//Rellenamos el formulario.
//			PO_LoginView.fillForm(driver, "pedro@email.com", "123456");
//			//Comprobamos que entramos en la seccion privada
//			PO_View.checkElement(driver, "text", "Esta zona solo es visible para ti");
//			//Vamos a la vista de amistades
//			PO_PrivateView.goToFriends(driver, "http://localhost:8090/friend/list");
//			//Comprobamos que está Ramon
//			PO_HomeView.checkElement(driver, "text", "Ramon");
//		}
	
	//PR20.  Visualizar al menos cuatro páginas en Español/Inglés/Español (comprobando que algunas de las etiquetas 
	//cambian al idioma correspondiente). Ejemplo, Página principal/Opciones Principales de Usuario/Listado de Usuarios. 
	@Test
	public void PR20() {
		
	}
		
		
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
//		}
	
	//Al finalizar la última prueba 
//	@AfterClass 
//	@Test
//	static public void end() { 
//		//Cerramos el navegador al finalizar las pruebas 
//		driver.quit(); 
//	}
}