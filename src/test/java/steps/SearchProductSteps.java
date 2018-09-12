package steps;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.JsonHelper;
import helpers.PropertiesHelper;
import helpers.ResponseHelper;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class SearchProductSteps {

    @When("^I search for product with: \"([^\"]*)\"$")
    public void iSearchForProductWith(String productId) {
        ResponseHelper.responseGetOne(productId);
    }

    @When("^I search for all products$")
    public void iSearchForAllProducts(){
        ResponseHelper.responseGetAll();
    }

    @And("^I can see the specified product$")
    public void iCanSeeATheSpecifiedProduct() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(DRAFTV4).freeze()).freeze();

        await().atMost(3, SECONDS)
                .untilAsserted(() -> ResponseHelper.getResponse()
                        .then().assertThat()
                        .body(matchesJsonSchemaInClasspath("jsonSchema/product-schema.json")
                                .using(jsonSchemaFactory)));

    }

    @And("^the system returns all products with specific format$")
    public void theSystemReturnsAllProductsWithSpecificFormat() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(DRAFTV4).freeze()).freeze();

        await().atMost(3, SECONDS)
                .untilAsserted(() -> JsonHelper.getJsonObjectListFromResponse(ResponseHelper.getResponse())
                        .forEach(x -> x.getAsJsonObject()
                                .equals(matchesJsonSchemaInClasspath("jsonSchema/product-schema.json")
                                        .using(jsonSchemaFactory))));
    }

}
