package Pages;

import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage extends  CommonPage{

    private By userField = By.id("user");

    private By passwordField = By.xpath("//*[@id='password']");
    private By loginAtlassianBtn = By.id("login");
    private By loginSubmitBtn = By.id("login-submit");
    public LoginPage() throws IOException {
        takeScreenShot(driver.getTitle());
    }
    public WelcomePage typeUserData(String user, String password) throws InterruptedException, IOException {
        waitAndSendKeys(userField, user);
        waitAndClick(loginAtlassianBtn);
        assertTitle("Log in to continue - Log in with Atlassian account");
        waitAndSendKeys(passwordField, password);
        waitAndClick(loginSubmitBtn);
        return new WelcomePage();
    }
}
