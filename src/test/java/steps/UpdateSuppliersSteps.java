package steps;

import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import entities.Address;
import entities.PhoneNumber;
import entities.Supplier;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import helpers.ResponseHelper;
import org.hamcrest.CoreMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateSuppliersSteps {
    Supplier supplier;
    @And("^the supplier with \"([^\"]*)\" exists$")
    public void theSupplierWithExists(String id) {
        ResponseHelper.resposeGet(id).then().assertThat().statusCode(200);
    }

    @When("^i send a put request to specifying the supplier \"([^\"]*)\" with the fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" that want to update$")
    public void iSendAPutRequestToSpecifyingTheSupplierWithTheFieldsAndThatWantToUpdate(String id, String address,
                                                                                        String city, String phoneNumber,
                                                                                        String phoneNumberType, String email,
                                                                                        String supplierName, String twitter,
                                                                                        String url) {
        supplier = new Supplier(
                new Address(address,city),
                new PhoneNumber(phoneNumber,phoneNumberType),
                email,
                supplierName,
                twitter,
                url
        );
        ResponseHelper.responsePut(id, supplier.toString());
    }

    @And("^the supplier with that \"([^\"]*)\" must have the updated attributes$")
    public void theSupplierWithThatMustHaveTheUpdatedAttributes(String id) {
        new ResponseHelper("supplier", PropertiesHelper.getKeyReadOnly());
        JsonObject newSupplier = JsonHelper.getJsonObjectFromResponse(ResponseHelper.resposeGet(id));
        List<Boolean> equalsAttributes= new ArrayList<>();
        equalsAttributes.add(newSupplier.get("address").getAsJsonObject().get("address").getAsString().equals(supplier.getAddress().getAddress()));
        equalsAttributes.add(newSupplier.get("address").getAsJsonObject().get("city").getAsString().equals(supplier.getAddress().getCity()));
        equalsAttributes.add( newSupplier.
                get("phoneNumber").
                getAsJsonArray().get(0)
                .getAsJsonObject()
                .get("number").getAsString().equals(supplier.getPhoneNumber().getNumber()));
        equalsAttributes.add( newSupplier.
                get("phoneNumber").
                getAsJsonArray().
                get(0).
                getAsJsonObject().
                get("type").getAsString().equals(supplier.getPhoneNumber().getType()));

        equalsAttributes.add(newSupplier.get("email").getAsString().equals(supplier.getEmail()));
        equalsAttributes.add(newSupplier.get("supplierName").getAsString().equals(supplier.getSupplierName()));
        equalsAttributes.add(newSupplier.get("twitter").getAsString().equals(supplier.getTwitter()));
        equalsAttributes.add(newSupplier.get("url").getAsString().equals(supplier.getUrl()));
        boolean equals = true;
        for (int i = 0; i<equalsAttributes.size();i++){
            equals = equals && equalsAttributes.get(i);
        }
        assertThat("the supplier must have the new attributes of the update request",
                equals, CoreMatchers.is(true));
    }
}
