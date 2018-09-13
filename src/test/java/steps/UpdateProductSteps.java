package steps;

import cucumber.api.java.en.When;
import entities.Product;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;

public class UpdateProductSteps {

    @When("^I send an update to product with \"([^\"]*)\" with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendAnUpdateToProductWithWithAnd(String id,
                                                  String status, String category, String description, String weightUnit,
                                                  String quantity, String productId, String mainCategory, String depth,
                                                  String name, String concurrencyCode, String dimUnit, String suppliedrId,
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
                        dimUnit,
                        suppliedrId,
                        taxTarifCode,
                        UoM,
                        weightMeasure,
                        price,
                        height,
                        width);

        ResponseHelper.responsePut(id, product.toString());
        Serenity.getCurrentSession().put("product", product);
    }

    @When("^I send an update to product with not existing \"([^\"]*)\"$")
    public void iSendAnUpdateToProductWithNotExisting(String productId) {
        Product product =
                new Product();

        ResponseHelper.responsePut(productId, product.toString());
        Serenity.getCurrentSession().put("product", product);
    }
}
