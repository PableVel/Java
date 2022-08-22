package Pages;

import org.openqa.selenium.By;

import java.io.IOException;

public class WelcomePage extends CommonPage{
    private By createNewBoardBtn;
    private By boardTitleField;
    //last btn to create board
    private By createBtn;
    private By templateBtn;
    private By createTemplateBtn;
    private By templateOptionBtn;

    public WelcomePage() throws IOException {
        takeScreenShot(driver.getTitle());
        templateBtn = By.xpath("//*[@id='header']/div[2]/div/div[1]/button[4]");
        createTemplateBtn = By.xpath("//button[@data-test-id='create-board-submit-button']");
        createNewBoardBtn = By.xpath("//*/div[1]/div/ul/li[@data-test-id=\"create-board-tile\"]");
        boardTitleField = By.xpath("//*/input[@data-test-id=\"create-board-title-input\"]");
        createBtn = By.xpath("//*/button[@data-test-id=\"create-board-submit-button\"]");


    }

    public void clickCreateNewBoardBtn() {
        waitAndClick(createNewBoardBtn);
    }

    public void typeBoardTitle(String boardTitle) {
        waitAndSendKeys(boardTitleField,boardTitle);
    }

    public BoardPage clickCreateBtn() throws IOException {
        waitAndClick(createBtn);
        return new BoardPage();
    }

    public void clickTemplate() {
        waitAndClick(templateBtn);
    }


    public BoardPage selectTemplate(String templateTitle) throws IOException {
        templateOptionBtn = By.xpath("//button[@class=\"_5Cw3S+fhiegkgA\"]/div[text()='"+templateTitle+"']");
        waitAndClick(templateOptionBtn);
        waitAndClick(createTemplateBtn);
        return new BoardPage();
    }
}
