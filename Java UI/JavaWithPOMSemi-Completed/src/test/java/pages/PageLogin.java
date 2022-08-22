package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageLogin  extends PageBase{
	Helpers helper = new Helpers();
	private By userField;
	private By loginBtn;
	private By passwordField;
	private By login2Btn;
	public PageLogin() throws IOException {

		userField = By.name("user");
		loginBtn = By.id("login");
		passwordField = By.id("password");
		login2Btn = By.id("login-submit");
		helper.screenShot(driver, "LOGIN");
		takeScreenShot(driver.getTitle());
	}
	public PageMain login(String user, String pass) throws IOException {
		waitAndType(userField,user);
		//driver.findElement(userField).sendKeys(user);
		waitAndClick(loginBtn);
		takeScreenShot("Log in to continue - Log in with Atlassian account");
		waitAndType(passwordField,pass);
		/*helper.waitForVisibleElement(driver, 10, passwordField);
		helper.sleepSeconds(2);
				
		driver.findElement(passwordField).sendKeys(pass);*/
		waitAndClick(login2Btn);
		/*driver.findElement(login2Btn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
		return new PageMain();
	}
}
