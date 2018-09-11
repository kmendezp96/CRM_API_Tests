package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class UpdateOrderSteps {
    @When("^I send an update to order with \"([^\"]*)\"$")
    public void iSendAnUpdateToOrderWith(String orderId) {

    }

    @And("^the order has: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void theOrderHas(String status, String quantity, String productId, String costumerId) {

    }
}
