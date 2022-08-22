package helpers;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helpers {
	private WebDriver driver;
	ArrayList<String> tabs;
	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean waitForVisibleElement(WebDriver driver, int i, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(i));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("The following element was visible: " + locator);
			return true;
		}catch (Exception e) {
			System.out.print("The following element was not visible: " + locator);
			System.out.print(e);
		    return false;
		}
	}
	
	public void screenShot(WebDriver driver, String nameFile) {
		this.driver = driver;
		File myScreenshot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		try {
			int time = (int)(System.currentTimeMillis()/10000L);
			FileUtils.copyFile(myScreenshot, new File("ScreenShots/"+nameFile+TimeUnit.MILLISECONDS.toSeconds(time)+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openTab(WebDriver driver, String url) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		String newTab = "window.open('"+url+"')";
		javaScriptExecutor.executeScript(newTab);
	}
	
	public void switchTab(WebDriver driver, int indexTab) {
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(indexTab));
	}

	public void closeTab(WebDriver driver, int indexTab) {
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(indexTab)).close();
	}
	

}
