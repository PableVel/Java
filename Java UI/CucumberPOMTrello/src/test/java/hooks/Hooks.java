package hooks;

import Pages.BoardPage;
import Pages.CommonPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends CommonPage {

    @Before
    public void beforeSimpleTest(){

        System.out.println("Before Test");
    }

    @After("@CreateBoard")
    public void AfterCreateBoard() throws IOException {
        BoardPage boardPage = new BoardPage();
        boardPage.deleteActualBoard();
    }

    @After
    public static void afterSimpleTest(){
        driver.close();
        driver.quit();
    }
}
