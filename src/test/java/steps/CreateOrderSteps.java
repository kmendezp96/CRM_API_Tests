package steps;

import cucumber.api.java.en.When;

public class CreateOrderSteps {
    @When("^I send a new order with: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iSendANewOrderWith(String status, String quantity, String productId, String costumerId) {

    }
}
