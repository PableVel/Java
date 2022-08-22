package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageBase {

    public static WebDriver driver;
    private static WebDriverWait wait;


    public PageBase() {
        driverConstructor();
        waitConstructor();
    }

    public static WebDriver driverConstructor(){
        if (driver==null){
            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void waitConstructor(){
        if(wait==null){
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

    public void waitAndClick(By locator){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch(Exception e){
            System.out.println("----------------------------------------------");
            System.out.println("The element is no clickable by locator: "+locator);
            System.out.println(e);
            System.out.println("----------------------------------------------");
        }
    }

    public void waitAndType(By locator, String string){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(string);
        }catch(Exception e){
            System.out.println("----------------------------------------------");
            System.out.println("The element is no clickable by locator: "+locator);
            System.out.println(e);
            System.out.println("----------------------------------------------");
        }
    }

    public static void openTrello(){
        driver.get("https://trello.com/login");
    }

    public void takeScreenShot(String expectedTitle) throws IOException {
        try{
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            int time = (int)(System.currentTimeMillis()/10000L);
            String newTitle = expectedTitle.replaceAll("\\|", "");
            FileUtils.copyFile(screenShot, new File("ScreenShots/"+newTitle+TimeUnit.MILLISECONDS.toSeconds(time)+".png"));
        }catch (Exception e){
            System.out.println("----------------------------------------------");
            System.out.println("Title expected: "+expectedTitle);
            System.out.println("Actual title: "+ driver.getTitle());
            System.out.println(e);
            System.out.println("----------------------------------------------");
        }
    }
    public void serieOfClicks(List<By> listOfLocators){

        for (By currentLocator: listOfLocators) {
            waitAndClick(currentLocator);
        }
    }

    public String getText(By locator){
        String textLocator = null;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            textLocator = driver.findElement(locator).getText();
        }catch (Exception e){
            System.out.println("----------------------------------------------");
            System.out.println("Locator is not working: "+locator);
            System.out.println(e);
            System.out.println("----------------------------------------------");
        }
        return textLocator;
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
