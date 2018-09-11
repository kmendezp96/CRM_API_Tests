package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import entities.Address;
import entities.Customer;
import entities.PhoneNumber;
import helpers.ResponseHelper;

import java.util.HashMap;
import java.util.Map;

public class CreateCustomer {

    @When("^i send a post request with the \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendAPostRequestWithTheAnd(String firstName, String lastName, String address,
                                            String city, String phoneNumber, String phoneNumberType,
                                            String email, String age) {
        Customer customer = new Customer(
                firstName,
                lastName,
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                age);
        //Map<String, String> customerMap = new HashMap<>();
        ResponseHelper.responsePost(customer.toString());
        System.out.println(customer.toString());

    }


}
