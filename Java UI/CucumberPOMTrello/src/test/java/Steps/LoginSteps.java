package Steps;



//C:\Users\Pablo_Velazquez\Documents\ProyectosDePrueba\Java\Java UI\CucumberPOMTrello\src\test\java\Steps\LoginSteps.java
//C:\Users\Pablo_Velazquez\Documents\ProyectosDePrueba\Java\Java UI\CucumberPOMTrello\src\main\java\Steps\CreateBoardSteps.java
import Pages.CommonPage;
import Pages.LoginPage;
import Pages.WelcomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {
        private static CommonPage commonPage;
        private static LoginPage loginPO;
        private static WelcomePage welcomePage;



        @Given("User opens trello in {string}")
        public void openTrello(String browser) throws IOException {
                commonPage = new CommonPage();
                commonPage.driverConstructor(browser);
                loginPO = commonPage.goToTrello();

        }

        @When("^User logs in$")
        public void logIn() throws InterruptedException, IOException {
                welcomePage = loginPO.typeUserData("pablo__akd@hotmail.com", "Baloncito98.");
        }

        @Then("User is in a page with title {string}")
        public void assertTitlePage(String expectedTitle) throws InterruptedException {
                welcomePage.assertTitle(expectedTitle);
        }


        /*@Given("User Logs in with {string}")
        public void userLogsInWith(String browser) throws IOException, InterruptedException {

                commonPage = new CommonPage();
                commonPage.driverConstructor(browser);
                commonPage.goToTrello();

                loginPO = new LoginPage();
                loginPO.typeUserData("pablo__akd@hotmail.com", "Baloncito98.");

                commonPage.assertTitle("Boards | Trello");

        }*/
}
