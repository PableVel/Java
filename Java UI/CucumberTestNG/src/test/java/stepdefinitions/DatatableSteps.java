package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DatatableSteps {

    @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        //List<List<String>> BillData = dataTable.asLists();
        List<Map<String, String>> BillData = dataTable.asMaps();

        for(Map<String,String> BillItems : BillData){

            for(Map.Entry<String, String> Billtem:BillItems.entrySet()){
                System.out.println("Key: "+Billtem.getKey());
                System.out.println("Value: "+Billtem.getValue());
            }
        }

    }
    @When("I generate the bill")
    public void i_generate_the_bill() {
      }
    @Then("a bill for ${int} should be generated")
    public void a_bill_for_$_should_be_generated(Integer int1) {
       }
}
