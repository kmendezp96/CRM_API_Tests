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
import helpers.ResponseHelper;
import org.hamcrest.CoreMatchers;
import org.jruby.RubyProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateCustomer {

    JsonObject originalCustomer;
    Customer customer;
    @And("^the customer with \"([^\"]*)\" exists$")
    public void theCustomerWithExists(String id) {
        originalCustomer = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet());
    }

    @When("^i send a put request to specifying the customer \"([^\"]*)\" with the fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" or \"([^\"]*)\" that want to update$")
    public void iSendAPutRequestToSpecifyingTheCustomerWithTheFieldsOrThatWantToUpdate(String id, String firstName,
                                                                                       String lastName, String address,
                                                                                       String city, String phoneNumber,
                                                                                       String phoneNumberType, String email,
                                                                                       String age) {
        /*Map<String, String> customer = new HashMap<>();
        if (!firstName.isEmpty())
            customer.put("firstName", firstName);
        if (!lastName.isEmpty())
            customer.put("lastName", lastName);
        if (!address.isEmpty())
            customer.put("address", address);
        if (!city.isEmpty())
            customer.put("city", city);
        if (!phoneNumber.isEmpty())
            customer.put("phoneNumber", phoneNumber);
        if (!phoneNumberType.isEmpty())
            customer.put("phoneNumberType", phoneNumberType);
        if (!email.isEmpty())
            customer.put("Email", email);
        if (age.length()>0)
            customer.put("age", age);*/

        customer = new Customer(
                firstName,
                lastName,
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                age);
        ResponseHelper.responsePut(customer.toString());
        //System.out.println(ResponseHelper.getResponse().print());
    }


    @And("^the customer with that \"([^\"]*)\" must have the updated attributes$")
    public void theCustomerWithThatMustHaveTheUpdatedAttributes(String id) {
        /*ResponseHelper.resposeGet().print();
        JsonObject newCustomer = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet());
        List<Boolean> equalsAttributes= new ArrayList<>();
        equalsAttributes.add(newCustomer.get("firstName").getAsString().equals(customer.getFirstName()));
        equalsAttributes.add(newCustomer.get("lastName").getAsString().equals(customer.getLastName()));
        equalsAttributes.add(newCustomer.get("address").getAsString().equals(customer.getAddress().toString()));
        //equalsAttributes.add(newCustomer.get("city").getAsString().equals(customer.getAddress().getCity()));
        equalsAttributes.add(newCustomer.get("PhoneNumber").getAsString().equals(customer.getPhoneNumber().toString()));
        equalsAttributes.add(newCustomer.get("Email").getAsString().equals(customer.getEmail()));
        equalsAttributes.add(newCustomer.get("age").getAsString().equals(customer.getAge()));
        for (int i = 0; i<equalsAttributes.size();i++){
            System.out.println(equalsAttributes.get(i));
        }*/
        JsonObject newCustomer = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet());
        boolean equals = newCustomer.equals(originalCustomer);
        assertThat("the customer must have the same attributes than before the update request",
                equals, CoreMatchers.is(false));

        /*boolean equals = newCustomer.equals(originalCustomer);
        assertThat("the customer must have the same attributes than before the update request",
                equals, CoreMatchers.is(true));*/
    }
}
