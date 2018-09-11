package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class UpdateProductSteps {
    @When("^I send an update to product with \"([^\"]*)\"$")
    public void iSendAnUpdateToProductWith(String productId) {

    }

    @And("^the product has \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theProductHasAnd(String status, String category, String description, String weightUnit,
                                 String quantity, String productId, String mainCategory, String depth,
                                 String name, String concurrencyCode, String dinUnit, String suppliedrId,
                                 String taxTarifCode, String UoM, String weightMeasure, String price,
                                 String height, String width) {

    }
}
