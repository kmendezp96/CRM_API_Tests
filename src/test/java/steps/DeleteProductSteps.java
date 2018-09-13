package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.ResponseHelper;

public class DeleteProductSteps {
    @When("^I delete the product with: \"([^\"]*)\"$")
    public void iDeleteTheProductWith(String productId) {
        ResponseHelper.responseDelete(productId);
    }

    @And("^I wont be able to see the product with that \"([^\"]*)\"$")
    public void iWontBeAbleToSeeTheProductWithThat(String productId) {
        try{
            ResponseHelper.responseGetOne(productId);
        } catch (Exception ex) {
                ResponseHelper.getResponse()
                        .then().assertThat().statusCode(404);
        }
    }
}
