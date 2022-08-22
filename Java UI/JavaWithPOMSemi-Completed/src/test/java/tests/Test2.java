package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PageBoard;
import pages.PageLogin;
import pages.PageMain;

import java.io.IOException;

import static pages.PageBase.driverConstructor;
import static pages.PageBase.openTrello;

public class Test2 {
    WebDriver driver;
    PageMain mainPage;
    PageBoard boardPage;

    @BeforeTest
    public void setUp() throws IOException {
        driver = driverConstructor();

        openTrello();


        PageLogin loginPage = new PageLogin();

        mainPage = loginPage.login("pablo__akd@hotmail.com", "Baloncito98.");
    }

    @Test
    public void archiveList() throws IOException, InterruptedException {
        mainPage.templateBtnClick();
        mainPage.selectTemplate(2);
        boardPage = mainPage.createTemplateBtnClick();
        boardPage.archiveList(1);
    }

    @AfterTest
    public void tearDown(){
        boardPage.deleteActualBoard();
        driver.close();
    }
}
