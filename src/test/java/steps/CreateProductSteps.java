package steps;

import cucumber.api.java.en.When;
import entities.Product;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;


public class CreateProductSteps {

    @When("^I send a new product with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendANewProductWithAnd(String status, String category, String description, String weightUnit,
                                     String quantity, String productId, String mainCategory, String depth,
                                     String name, String concurrencyCode, String dinUnit, String suppliedrId,
                                     String taxTarifCode, String UoM, String weightMeasure, String price,
                                     String height, String width) {
        Product product =
                new Product(status,
                        category,
                        description,
                        weightUnit,
                        quantity,
                        productId,
                        mainCategory,
                        depth,
                        name,
                        concurrencyCode,
                        dinUnit,
                        suppliedrId,
                        taxTarifCode,
                        UoM,
                        weightMeasure,
                        price,
                        height,
                        width);
        ResponseHelper.responsePost(product.toString());
        Serenity.getCurrentSession().put("product", product);
    }

    @When("^I send a new product with nothing$")
    public void iSendANewProductWithNothing() {
        Product product = new Product();
        ResponseHelper.responsePost(product.toString());
    }
}
