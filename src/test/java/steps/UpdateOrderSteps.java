package steps;

import cucumber.api.java.en.When;
import entities.Order;
import entities.Products;
import helpers.ResponseHelper;
import net.serenitybdd.core.Serenity;

public class UpdateOrderSteps {

    @When("^I send an update to order with \"([^\"]*)\" with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iSendAnUpdateToOrderWithWith(String orderId,
                                             String status,
                                             String quantity, String productId,
                                             String costumerId) {
        Products products =
                new Products(quantity,
                        productId);
        Order order =
                new Order(status,
                        products,
                        costumerId);

        ResponseHelper.responsePut(orderId, order.toString());
        Serenity.getCurrentSession().put("order", order);
    }

    @When("^I send an update to order with not existing \"([^\"]*)\"$")
    public void iSendAnUpdateToOrderWithNotExisting(String orderId) {
       Order order = new Order();

        ResponseHelper.responsePut(orderId, order.toString());
        Serenity.getCurrentSession().put("order", order);
    }
}
