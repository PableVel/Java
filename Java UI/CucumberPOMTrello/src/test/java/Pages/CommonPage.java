package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;

public class CommonPage {
    static WebDriverWait wait;

    public static WebDriver driver;




    public void driverConstructor(String browser){
        browser = browser.toLowerCase(Locale.ROOT);
        switch (browser){
            case "google":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pablo_Velazquez\\Documents\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", "en-GB");
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);

                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pablo_Velazquez\\Documents\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver(options);
                break;
            default: System.out.println("Check your browser name (Google and Firefox accepted)");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }





    public LoginPage openTrello(String browser) throws IOException {
        driverConstructor(browser);
        return goToTrello();
    }


    public LoginPage goToTrello() throws IOException {
        driver.get("https://trello.com/login");
        return new LoginPage();
    }

    public void assertTitle(String expectedTitle) throws InterruptedException {

        try {
            wait.until(driver ->driver.getTitle().equals(expectedTitle));
        } catch (Exception e) {
            throw new RuntimeException("Incorrect title"+"\nExpected title: "+expectedTitle+".\nActual title: "+driver.getTitle()+"\n"+e);
        }

    }

    public void waitAndSendKeys(By element,String stringToSend){
        try{
            WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            myElement.sendKeys(stringToSend);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void waitAndClick(By element){

        try {
            WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            //WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.findElement(element));
            myElement.click();
        } catch (Exception e) {
            System.out.println("The element was not located: "+element);
            throw new RuntimeException(e);
        }
    }

    public void takeScreenShot(String title) throws IOException {
        try{
            wait.until(driver ->driver.getTitle().equals(title));
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd HH:mm:ss");
            //LocalDateTime now = LocalDateTime.now();
            //String time = dtf.format(now).replaceAll(":","_");
            File scFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scFile, new File(".//screenshot/"+title+".png"));
        }catch (Exception e){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------");
            System.out.println(e);
            System.out.println("--------------------------------------------------------------------");
        }

    }
}

