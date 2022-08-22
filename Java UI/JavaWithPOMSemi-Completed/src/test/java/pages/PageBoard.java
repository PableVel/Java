package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageBoard extends PageBase {


	Helpers helper = new Helpers();
	By title;
	By showMenuBtn;
	By moreBtn;
	By closeBoardBtn;

	By closeConfirmBtn;
	By archiveListBtn;
	By archiveTitle;
	List listOfLists;

	private By threePointsLink;
	public PageBoard() throws IOException {
		title = By.xpath("/html/head/title");
		showMenuBtn = By.xpath("//*[@class='board-header-btn mod-show-menu js-show-sidebar']");
		moreBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[1]/li[5]/a");
		closeBoardBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[2]/div/ul[3]/li/a");
		closeConfirmBtn = By.xpath("//*[@class='js-confirm full nch-button nch-button--danger']");
		archiveListBtn = By.xpath("//*[@id=\"chrome-container\"]/div[4]/div/div[2]/div/div/div/ul[4]/li/a");
		helper.waitForVisibleElement(driver,10,title);
		takeScreenShot(driver.getTitle());
	}

	public void deleteActualBoard() {
		List<By> listClicks = Arrays.asList(showMenuBtn,moreBtn,closeBoardBtn,closeConfirmBtn);
		serieOfClicks(listClicks);
	}

	public void archiveList(int option) throws InterruptedException {
		threePointsLink = By.xpath("//*[@id=\"board\"]/div["+option+"]/div/div[1]/div[2]/a");
		archiveTitle = By.xpath("//*[@id=\"board\"]/div["+option+"]/div/div[1]/textarea");
		String listTitle = getText(archiveTitle);
		listOfLists = driver.findElements(By.xpath("//*[@id=\"board\"]/div/div/div[1]/textarea"));
		waitAndClick(threePointsLink);
		waitAndClick(archiveListBtn);
		Thread.sleep(1);
		for (int i = 1; i < listOfLists.size(); i++) {
			String currentTitle = getText(By.xpath("//*[@id=\"board\"]/div["+i+"]/div/div[1]/textarea"));
			Assert.assertNotEquals(currentTitle,listTitle);
		}
	}



}
