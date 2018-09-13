package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.ResponseHelper;

public class DeleteOrderSteps {
    @When("^I delete the order with: \"([^\"]*)\"$")
    public void iDeleteTheOrderWith(String orderId) {
        ResponseHelper.responseDelete(orderId);
    }

    @And("^I wont be able to see the order with that \"([^\"]*)\"$")
    public void iWontBeAbleToSeeTheOrderWithThat(String orderId) {
        try{
            ResponseHelper.responseGetOne(orderId);
        } catch (Exception ex) {
            ResponseHelper.getResponse()
                    .then().assertThat().statusCode(404);
        }
    }
}
