package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.ResponseHelper;

public class DeleteCustomerSteps {

    @When("^i delete the customer with\"([^\"]*)\"$")
    public void iDeleteTheCustomerWith(String id) {
        ResponseHelper.responseDelete(id);
    }

    @And("^the customer with that \"([^\"]*)\" must not exists$")
    public void theCustomerWithThatMustNotExists(String id) {
        ResponseHelper.responseGet(id);
        ResponseHelper.getResponse().then().assertThat().statusCode(404);
    }
}
