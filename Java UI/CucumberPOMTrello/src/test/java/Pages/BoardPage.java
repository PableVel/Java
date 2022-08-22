package Pages;

import org.openqa.selenium.By;

import java.io.IOException;

public class BoardPage extends CommonPage {
    private By showMenuLink;
    private By moreLink;
    private By closeBoardLink;
    private By closeBoardConfirmationLink;
    private By deleteBoardPermanentlyBtn;

    private By deleteBoardPermanentlyConfirmationBtn;


    public BoardPage() throws IOException {
        takeScreenShot(driver.getTitle());
        showMenuLink = By.linkText("Show menu");
        moreLink = By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']");
        closeBoardLink = By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']");
        closeBoardConfirmationLink = By.xpath("//*[@id='chrome-container']/div[4]/div/div[2]/div/div/div/input");
        deleteBoardPermanentlyBtn = By.xpath("//button[@data-test-id='close-board-delete-board-button']");
        deleteBoardPermanentlyConfirmationBtn = By.xpath("//button[@data-test-id=\"close-board-delete-board-confirm-button\"]");

    }

    public void deleteActualBoard(){
        waitAndClick(showMenuLink);
        waitAndClick(moreLink);
        waitAndClick(closeBoardLink);
        waitAndClick(closeBoardConfirmationLink);
        waitAndClick(deleteBoardPermanentlyBtn);
        waitAndClick(deleteBoardPermanentlyConfirmationBtn);
    }


}
