package prueba;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Tests extends Base{
    WebDriver driver;
    @Parameters({"Password"})
    @Test
    public void driverTest(String Password) throws InterruptedException {
        WebDriver driver = noSingletonDriver("ChromeDriver");
        driver.get("https://trello.com/login");
        WebElement userField = driver.findElement(By.id("user"));
        userField.sendKeys("pablo__akd@hotmail.com");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(Password);
        WebElement loginButton2 = driver.findElement(By.id("login-submit"));
        loginButton2.click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        Assert.assertEquals("Boards | Trello",driver.getTitle());
    }



   @Test(enabled = false)
    public void otherTest() throws InterruptedException
    {
        driver = noSingletonDriver("FirefoxDriver");
        driver.get("https://trello.com/login");

        Assert.assertNotEquals("Log in to Trello",driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }




}

