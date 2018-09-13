package steps;

import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Address;
import entities.Customer;
import entities.PhoneNumber;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import helpers.ResponseHelper;
import io.restassured.http.Header;
import org.hamcrest.CoreMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateCustomerSteps {

    JsonObject originalCustomer;
    JsonObject newCustomer;
    Customer customer;
    @And("^the customer with \"([^\"]*)\" exists$")
    public void theCustomerWithExists(String id) {
        originalCustomer = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet(id));
    }

    @When("^i send a put request to specifying the customer \"([^\"]*)\" with the fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" or \"([^\"]*)\" that want to update$")
    public void iSendAPutRequestToSpecifyingTheCustomerWithTheFieldsOrThatWantToUpdate(String id, String firstName,
                                                                                       String lastName, String address,
                                                                                       String city, String phoneNumber,
                                                                                       String phoneNumberType, String email,
                                                                                       String age) {
        customer = new Customer(
                firstName,
                lastName,
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                age);
        ResponseHelper.responsePut(id, customer.toString());
    }


    @And("^the customer with that \"([^\"]*)\" must have the updated attributes$")
    public void theCustomerWithThatMustHaveTheUpdatedAttributes(String id) {
        new ResponseHelper("customer", PropertiesHelper.getKeyReadOnly());
        newCustomer = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet(id));
        List<Boolean> equalsAttributes= new ArrayList<>();
        equalsAttributes.add(newCustomer.get("firstName").getAsString().equals(customer.getFirstName()));
        equalsAttributes.add(newCustomer.get("lastName").getAsString().equals(customer.getLastName()));
        equalsAttributes.add(newCustomer.get("address").getAsJsonObject().get("address").getAsString().equals(customer.getAddress().getAddress()));
        equalsAttributes.add(newCustomer.get("address").getAsJsonObject().get("city").getAsString().equals(customer.getAddress().getCity()));
        equalsAttributes.add( newCustomer.
                get("phoneNumber").
                getAsJsonArray().get(0)
                .getAsJsonObject()
                .get("number").getAsString().equals(customer.getPhoneNumber().getNumber()));
        equalsAttributes.add( newCustomer.
                get("phoneNumber").
                getAsJsonArray().
                get(0).
                getAsJsonObject().
                get("type").getAsString().equals(customer.getPhoneNumber().getType()));

        equalsAttributes.add(newCustomer.get("email").getAsString().equals(customer.getEmail()));
        equalsAttributes.add(newCustomer.get("age").getAsString().equals(customer.getAge()));
        boolean equals = true;
        for (int i = 0; i<equalsAttributes.size();i++){
            equals = equals && equalsAttributes.get(i);
        }
        assertThat("the customer must have the new attributes of the update request",
                equals, CoreMatchers.is(true));

    }


}
