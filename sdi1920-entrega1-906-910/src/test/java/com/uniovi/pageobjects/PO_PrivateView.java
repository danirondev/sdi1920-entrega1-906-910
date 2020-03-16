package com.uniovi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uniovi.utils.SeleniumUtils;

public class PO_PrivateView extends PO_View{
	
		/**
		 * * Selecciona la opción de Gestion de Usuarios y posteriormente
		 * el botón de Ver Usuarios.
		 * * @param driver: apuntando al navegador abierto actualmente.
		 */
		public static void accessSeeker(WebDriver driver) {
			//clicamos la opcion de gestion de usuarios
			List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "users-menu", getTimeout());
			elementos.get(0).click();   
			//Esperamos a que aparezca el menú de opciones.   
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "users-menu", getTimeout());   
			//Clickamos la opcion Ver Usuarios
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id", "btnSeeUsers", getTimeout());
			elementos.get(0).click(); 
		}
		
		/**
		 * Escribe en la barra de busqueda lo introducido en la variable texto.
		 * @param driver
		 * @param texto
		 */
		public static void writeOnSeeker(WebDriver driver, String texto) {
			//Escribimos lo pasado como parametro dentro del buscador de usuarios
			WebElement userSeeker = driver.findElement(By.id("userSeeker"));
			userSeeker.click();
			userSeeker.clear();
			userSeeker.sendKeys(texto);
			//Pulsamos el boton de buscar
			By boton = By.id("btnSeek");
			driver.findElement(boton).click();
		}

		public static void clickNextPage(WebDriver driver) {
			//Pulsamos el boton de siguiente pag
			By boton = By.id("btnNext");
			driver.findElement(boton).click();
		}
		
		public static void addFirstUser2(WebDriver driver) {
			//Pulsamos en el link de agregar del primer usuario
			WebElement btn = driver.findElement(By.id("btnAdd1"));
			btn.click();
		}
		
		public static void addUser(WebDriver driver, String URL) {
			driver.navigate().to(URL);
		}
		
		public static void acceptUser(WebDriver driver, String URL) {
			driver.navigate().to(URL);
		}
		
		public static void goToFriends(WebDriver driver, String URL) {
			driver.navigate().to(URL);
		}
		
		public static void goToPetitions(WebDriver driver) {
			//Navegamos hasta la pestaña de solicitudes
			driver.navigate().to("http://localhost:8090/user/petitions");
		}

}
