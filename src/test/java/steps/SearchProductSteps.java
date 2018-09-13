package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import entities.Product;
import helpers.JsonHelper;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.containsString;

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
        await().atMost(3, SECONDS)
                .untilAsserted(() -> ResponseHelper.getResponse()
                        .then().assertThat()
                        .body(matchesJsonSchemaInClasspath("jsonSchema/product-schema.json")
                                .using(JsonHelper.schemaFactory())));
    }

    @And("^the system returns all products with specific format$")
    public void theSystemReturnsAllProductsWithSpecificFormat() {
         await().atMost(3, SECONDS)
                .untilAsserted(() -> JsonHelper.getJsonObjectListFromResponse(ResponseHelper.getResponse())
                        .forEach(x -> x.getAsJsonObject()
                                .equals(matchesJsonSchemaInClasspath("jsonSchema/product-schema.json")
                                        .using(JsonHelper.schemaFactory()))));
    }

    @And("^Product has the attributes that i set$")
    public void productHasTheAttributesThatISet() {
        Product product = (Product) Serenity.getCurrentSession().get("product");
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getStatus()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getCategory()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getDescription()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getWeightUnit()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getQuantity()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getProductId()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getMainCategory()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getDepth()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getName()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getCurrencyCode()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getDimUnit()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getSupplierId()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getTaxTarifCode()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getUoM()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getWeightUnit()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getPrice()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getHeight()));
        ResponseHelper.getResponse().then().assertThat().body(containsString(product.getWidth()));
    }

}
