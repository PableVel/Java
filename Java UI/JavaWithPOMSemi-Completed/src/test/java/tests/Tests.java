package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageBoard;
import pages.PageLogin;
import pages.PageMain;
import pages.PageBase;

import static pages.PageBase.driverConstructor;
import static pages.PageBase.openTrello;

public class Tests {
	WebDriver driver;
	PageMain mainPage;
	PageBoard pageBoardObject;
	Helpers helper = new Helpers();
	@BeforeMethod
	public void setUp() throws IOException {
		driver = driverConstructor();
		openTrello();


		PageLogin loginPage = new PageLogin();

		mainPage = loginPage.login("pablo__akd@hotmail.com", "Baloncito98.");
		//helper.openTab(driver, "https://www.google.com");
		//helper.switchTab(driver, 1);
		//helper.closeTab(driver, 1);
		//helper.switchTab(driver, 0);

		
	}
	/*@Test
	public void pruebaUno() {
		PageMain mainObject = new PageMain(driver);
		mainObject.assertUserText("Jos� Pablo Vel�zquez Michel (pablo__akd)");
	}*/
	
	@Test
	public void pruebaDos() throws IOException {
		mainPage.templateBtnClick();
		//PageMain mainObject = new PageMain();
		mainPage.selectTemplate(1);
		pageBoardObject = mainPage.createTemplateBtnClick();
		//PageBoard pageBoardObject = mainObject.selectTemplate(1);

		Assert.assertEquals(driver.getTitle(), "1-on-1 Meeting Agenda | Trello", "No son iguales");
	}/*
	
	@Test
	public void pruebaTres() {
		PageMain mainObject = new PageMain(driver);
		System.out.println("------------------"+mainObject.countInputs()+"---------");
		Assert.assertEquals(mainObject.countInputs(), 2);
	}
	
	@Test
	public void pruebaCuatro() {
		PageMain mainObject = new PageMain(driver);
		PageBoard pageBoardObject = mainObject.boardClickByTitle("1-on-1 Meeting Agenda");
		Assert.assertEquals(pageBoardObject.getTitleBoard(), "1-on-1 Meeting Agenda", "No son iguales");
		
	}
	*/
	@AfterMethod
	public void tearDown() {
		pageBoardObject.deleteActualBoard();
		driver.close();
	}
}
