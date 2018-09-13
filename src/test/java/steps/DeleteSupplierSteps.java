package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.ResponseHelper;

public class DeleteSupplierSteps {
    @When("^i delete the supplier with\"([^\"]*)\"$")
    public void iDeleteTheSupplierWith(String id) {
        ResponseHelper.resposeDelete(id);
    }

    @And("^the supplier with that \"([^\"]*)\" must not exists$")
    public void theSupplierWithThatMustNotExists(String id) {
        ResponseHelper.resposeGet(id);
        ResponseHelper.getResponse().then().assertThat().statusCode(404);

    }
}
