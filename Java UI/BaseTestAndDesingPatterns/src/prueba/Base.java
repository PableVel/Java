package prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
    private static WebDriver driver;

    private static WebDriver Base(String typeDriver) {
        if(driver == null){
            switch (typeDriver){
                case "ChromeDriver":
                    //System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "FirefoxDriver":
                    //System.setProperty("webdriver.firefox.driver","Drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + typeDriver);
            }
        }
        return driver;
    }

    public static WebDriver driverContructor(String typeDriver){
        return Base(typeDriver);
    }
    public static WebDriver noSingletonDriver (String typeDriver){
        switch (typeDriver){
        case "ChromeDriver":
            //System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            break;
        case "FirefoxDriver":
            //System.setProperty("webdriver.firefox.driver","Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + typeDriver);
    }
    return driver;

    }

}
