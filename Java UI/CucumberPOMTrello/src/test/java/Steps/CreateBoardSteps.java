package Steps;

import Pages.BoardPage;
import Pages.CommonPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class CreateBoardSteps {
    private WelcomePage welcomePage;
    private CommonPage commonPage;
    private LoginPage loginPO;

    private BoardPage boardPage;


    @Given("User Logs in with {string}")
    public void userLogsInWith(String browser) throws IOException, InterruptedException {
        commonPage = new CommonPage();
        loginPO = commonPage.openTrello(browser);
        welcomePage = loginPO.typeUserData("pablo__akd@hotmail.com", "Baloncito98.");
        welcomePage.assertTitle("Boards | Trello");

    }
        @When("User clicks on -Create new board- from -YOUR WORKSPACES-")
    public void userClicksOnCreateNewBoardFromYOURWORKSPACES() throws IOException {
        welcomePage.clickCreateNewBoardBtn();
    }

    @And("User types board title {string}")
    public void userTypesTitle(String boardTitle) throws IOException {
        welcomePage.typeBoardTitle(boardTitle);
    }

    @And("User clicks -Create- Button")
    public void userClicksCreateButton() throws IOException {
        boardPage = welcomePage.clickCreateBtn();
    }

    @Then("User is in {string} page")
    public void userIsInPage(String expectedTitle) throws InterruptedException {
        boardPage.assertTitle(expectedTitle);
    }

    @When("User clicks templates")
    public void userClicksTemplates() {
        welcomePage.clickTemplate();
    }

    @And("User select {string} template")
    public void userSelectTemplate(String template) throws IOException {
        welcomePage.selectTemplate(template);
    }
}
