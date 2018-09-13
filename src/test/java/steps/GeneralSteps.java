package steps;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import helpers.PropertiesHelper;
import helpers.ResponseHelper;

import java.io.IOException;

public class GeneralSteps {

    @Before
    public  void setup() throws IOException {
        new PropertiesHelper();
    }

    @Given("^I have access to CRM \"([^\"]*)\" service with \"([^\"]*)\"$")
    public void iHaveAccessToCRMServiceWith(String serviceCRM, String typeKey) {
           new ResponseHelper(serviceCRM, typeKey);
    }

    @Then("^the system response with a \"([^\"]*)\" status code$")
    public void theSystemResponseWithAStatusCode(String statusCode) {
        switch (statusCode){
            case "200":
                ResponseHelper.getResponse().then().assertThat().statusCode(200);
                break;
            case "201":
                ResponseHelper.getResponse().then().assertThat().statusCode(201);
                break;
            case "204":
                ResponseHelper.getResponse().then().assertThat().statusCode(204);
                break;
            case "400":
                ResponseHelper.getResponse().then().assertThat().statusCode(400);
                break;
            case "403":
                ResponseHelper.getResponse().then().assertThat().statusCode(403);
                break;
            case "408":
                ResponseHelper.getResponse().then().assertThat().statusCode(408);
                break;
        }
    }
}
