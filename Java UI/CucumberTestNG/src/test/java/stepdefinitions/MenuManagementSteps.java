package stepdefinitions;

import cambiae.RestaurantMenu;
import cambiae.RestaurantMenuItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MenuManagementSteps {
    RestaurantMenuItem NewMenuItem;
    RestaurantMenu LocationMenu = new RestaurantMenu();
    String ErrorMessage;
    @Given("I have a menu item with name {string} and price ($){int}")
    public void miMetodo(String newMenuItemName, Integer price) {
        NewMenuItem = new RestaurantMenuItem(newMenuItemName,newMenuItemName,price);
        System.out.println("Step 1");
    }

    @When("I add that menu item")
    public void miMetodo2() {
        try{
            LocationMenu.addMenuItem(NewMenuItem);
        }catch (IllegalArgumentException ex){
            ErrorMessage = ex.getMessage();
        }
        System.out.println("Step 2");
    }

    @Then("Menu Item with name {string} should be added")
    public void miMetodo3(String string) {
        boolean Exists = LocationMenu.DoesItemExists(NewMenuItem);
        System.out.println("Step 3: "+ Exists);
    }

    @Then("Should display an error message {string}")
    public void shouldDisplayAnErrorMessage(String arg0) {
        Assert.assertEquals(arg0, ErrorMessage);
    }
}

