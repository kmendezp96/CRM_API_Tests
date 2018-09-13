package steps;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Address;
import entities.Customer;
import entities.PhoneNumber;
import helpers.JsonHelper;
import helpers.ResponseHelper;
import org.hamcrest.CoreMatchers;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class CreateCustomerSteps {
    private Customer customer;
    private String id;
    @When("^i send a post request with the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendAPostRequestWithTheAnd(String firstName, String lastName, String address,
                                            String city, String phoneNumber, String phoneNumberType,
                                            String email, String age) {
        customer = new Customer(
                firstName,
                lastName,
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                age);
        id = JsonHelper.
                getJsonObjectFromResponse(ResponseHelper.
                        responsePost(customer.toString())).
                get("id").
                getAsString();

    }

    @Then("^i should see the new customer in the customers list$")
    public void iShouldSeeTheNewCustomerInTheCustomersList() {
        new ResponseHelper("customer", "read permission");
        boolean isInList = false;
        JsonArray customers = JsonHelper.
                                getJsonObjectFromResponse(
                                        ResponseHelper.resposeGet()
                                ).get("data").getAsJsonArray();
        for (int i = 0; i<customers.size();i++){
            if (customers.get(i).getAsJsonObject().get("id").getAsString().equals(id))
                isInList = true;
        }
        System.out.println(customers.get(customers.size()-1));
        assertThat("the customers list must contains the new customer",
                isInList, CoreMatchers.is(true));
        ;


    }

}
