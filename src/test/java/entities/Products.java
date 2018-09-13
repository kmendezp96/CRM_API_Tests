package entities;

public class Products {
    private	String quantity;
    private	String productId;

    public Products(){
    }

    public Products(String quantity, String productId) {
        this.quantity = quantity;
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"quantity\": \"" + quantity + "\", \n" +
                "\"productId\": \"" + productId + "\" \n"  +
                '}';
    }
}
