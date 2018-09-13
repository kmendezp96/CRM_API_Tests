package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.Order;
import helpers.JsonHelper;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.containsString;

public class SearchOrderSteps {
    @When("^I search for all orders$")
    public void iSearchForAllOrders() {
        ResponseHelper.responseGetAll();
    }

    @When("^I search for order with: \"([^\"]*)\"$")
    public void iSearchForOrderWith(String orderId) {
        ResponseHelper.responseGetOne(orderId);
    }

    @Then("^Order has the attributes that i set$")
    public void orderHasTheAttributesThatISet() {
        Order order = (Order) Serenity.getCurrentSession().get("order");
        ResponseHelper.getResponse().then().assertThat().body(containsString(order.getStatus()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(order.getProducts().getQuantity()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(order.getProducts().getProductId()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(order.getCustomerId()));
    }

    @And("^I can see the specified order$")
    public void iCanSeeTheSpecifiedOrder() {
        await().atMost(3, SECONDS)
                .untilAsserted(() -> ResponseHelper.getResponse()
                        .then().assertThat()
                        .body(matchesJsonSchemaInClasspath("jsonSchema/order-schema.json")
                                .using(JsonHelper.schemaFactory())));
    }

    @And("^the system returns all orders with specific format$")
    public void theSystemReturnsAllOrdersWithSpecificFormat() {
        await().atMost(3, SECONDS)
                .untilAsserted(() -> JsonHelper.getJsonObjectListFromResponse(ResponseHelper.getResponse())
                        .forEach(x -> x.getAsJsonObject()
                                .equals(matchesJsonSchemaInClasspath("jsonSchema/order-schema.json")
                                        .using(JsonHelper.schemaFactory()))));
    }
}
