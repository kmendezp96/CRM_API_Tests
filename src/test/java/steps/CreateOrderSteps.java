package steps;

import cucumber.api.java.en.When;
import entities.Order;
import entities.Products;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;

public class CreateOrderSteps {
    @When("^I send a new order with: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iSendANewOrderWith(String status,
                                   String quantity,
                                   String productId,
                                   String costumerId) {
        Products products =
                new Products(quantity,
                        productId);
        Order order =
                new Order(status,
                        products,
                        costumerId);

        ResponseHelper.responsePost(order.toString());
        Serenity.getCurrentSession().put("order", order);
    }

    @When("^I send a new order with nothing$")
    public void iSendANewProductWithNothing() {
        Order order = new Order();
        ResponseHelper.responsePost(order.toString());
    }
}
