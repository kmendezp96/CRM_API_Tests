package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import helpers.ResponseHelper;
import io.restassured.response.Response;

public class DeleteCustomerSteps {

    @When("^i delete the customer with\"([^\"]*)\"$")
    public void iDeleteTheCustomerWith(String id) {
        Response a = ResponseHelper.resposeDelete(id);
        a.print();
    }

    @And("^the customer with that \"([^\"]*)\" must not exists$")
    public void theCustomerWithThatMustNotExists(String id) {
        ResponseHelper.resposeGet(id);
        ResponseHelper.getResponse().then().assertThat().statusCode(404);
    }
}
