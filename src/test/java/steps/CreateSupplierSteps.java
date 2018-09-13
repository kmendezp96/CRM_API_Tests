package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Address;
import entities.PhoneNumber;
import entities.Supplier;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import helpers.ResponseHelper;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateSupplierSteps {
    private Supplier supplier;
    private String id;
    @When("^i send a post request to the service with the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendAPostRequestToTheServiceWithTheAnd(String address, String city, String phoneNumber,
                                                        String phoneNumberType, String email, String supplierName,
                                                        String twitter, String url) {
        supplier = new Supplier(
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                supplierName,
                twitter,
                url
        );
        System.out.println(supplier.toString());
        id = JsonHelper.
                getJsonObjectFromResponse(ResponseHelper.
                        responsePost(supplier.toString())).
                get("id").
                getAsString();

    }

    @Then("^i should be able to consult the new supplier by its' id$")
    public void iShouldBeAbleToConsultTheNewSupplierByItsId() {
        new ResponseHelper("supplier", PropertiesHelper.getKeyReadOnly());
        ResponseHelper.responseGet(id).then().assertThat().statusCode(200);

    }


}
