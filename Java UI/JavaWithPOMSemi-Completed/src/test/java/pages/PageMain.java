package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import helpers.Helpers;

public class PageMain extends PageBase {

	Helpers helper = new Helpers();
	private By userText;
	private By templateBtn;
	private By templateOption;
	private By titleBoardField;
	private By inputFields;
	private By board;

	private By createTemplateBtn;

	private By templatesSection;

	
	public PageMain() throws IOException {

		userText = By.className("_2LKdO6O3n25FhC");
		templateBtn = By.xpath("//*[@id='header']/div[2]/div/div[1]/button[4]");
		titleBoardField = By.xpath("//input[@class='nch-textfield__input _2N2CjUFKhgeXLO _2N2CjUFKhgeXLO']");
		createTemplateBtn = By.xpath("//button[@data-test-id='create-board-submit-button']");
		inputFields = By.tagName("input");
		templatesSection = By.xpath("//li[@data-test-id=\"templates\"]/a");
		takeScreenShot(driver.getTitle());
		                                  
	}
	public int countInputs() {
		List<WebElement> inputList = driver.findElements(inputFields);
		return inputList.size();
	}
	
	public void setTitleBoardField(String title) {
		helper.waitForVisibleElement(driver, 10, titleBoardField);
		driver.findElement(titleBoardField).sendKeys(title);
	}
	
	public void assertUserText(String text) {
		Assert.assertTrue((driver.findElement(userText)).getAttribute("title").contains(text));
	}
	
	public void templateBtnClick() {
		waitAndClick(templateBtn);
		//driver.findElement(templateBtn).click();
	}
	
	public PageBoard createTemplateBtnClick() throws IOException {
		waitAndClick(createTemplateBtn);
		return new PageBoard();
	}
	
	public PageBoard boardClickByTitle(String boardTitle) throws IOException {
		board = By.xpath("//*[@id='content']/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/ul/li[1]/a/div/div[@title='"+boardTitle+"']");
		driver.findElement(board).click();
		return new PageBoard();
	}
	
	public void selectTemplate(int numOption){
		templateOption = By.xpath("//li["+numOption+"]/div/button[@class='_5Cw3S+fhiegkgA']");
		waitAndClick(templateOption);
	}

	public PageTemplate templatesSectionClick(){
		waitAndClick(templatesSection);
		return new PageTemplate();
	}


	

}
