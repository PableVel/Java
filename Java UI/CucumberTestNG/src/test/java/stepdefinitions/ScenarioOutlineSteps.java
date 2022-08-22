package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ScenarioOutlineSteps {
    int InitialBillAmount;
    double TaxRate;
    @Given("I have a Customer")
    public void iHaveACustomer() {
    }

    @And("users enters initial bill amount as {int}")
    public void usersEntersInitialBillAmountAsInitialBillAmount(Integer initialBillAmount) {
        this.InitialBillAmount = initialBillAmount;
        System.out.println("initialBillAmount value: "+ this.InitialBillAmount);
    }

    @And("Sales Tax Rate is {double} percent")
    public void salesTaxRateIsTaxRatePercent(double TaxRate) {
        this.TaxRate = TaxRate;
        System.out.println("TaxRate value: "+ this.TaxRate);
    }

    @Then("final bill amount calculate is {double}")
    public void finalBillAmountCalculateIsCalculatedBillAmount(double expectedValue) {
        double calclatedValue = this.InitialBillAmount + this.TaxRate;
        System.out.println("Expected value: "+ expectedValue);
        System.out.println("System Calculated value: "+ calclatedValue);
        Assert.assertEquals(expectedValue,calclatedValue);
    }
}

