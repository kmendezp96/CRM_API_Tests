package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import helpers.ResponseHelper;

import java.util.HashMap;
import java.util.Map;

public class CreateProductSteps {

    @When("^I send a new product with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSendANewProductWithAnd(String status, String category, String description, String weightUnit,
                                     String quantity, String productId, String mainCategory, String depth,
                                     String name, String concurrencyCode, String dinUnit, String suppliedrId,
                                     String taxTarifCode, String UoM, String weightMeasure, String price,
                                     String height, String width) {

        Map<String, String> product = new HashMap<>();
        product.put("Status", status);
        product.put("Category", category);
        product.put("Description", description);
        product.put("WeightUnit", weightUnit);
        product.put("Quantity", quantity);
        product.put("ProductId", productId);
        product.put("MainCategory", mainCategory);
        product.put("Depth", depth);
        product.put("Name", name);
        product.put("CurrencyCode", concurrencyCode);
        product.put("DimUnit", dinUnit);
        product.put("SupplierId", suppliedrId);
        product.put("TaxTarifCode", taxTarifCode);
        product.put("UoM", UoM);
        product.put("WeightMeasure", weightMeasure);
        product.put("Price", price);
        product.put("Height", height);
        product.put("Width", width);
        ResponseHelper.responsePost(product);
    }
}
