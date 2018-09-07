package entities;

public class Order {
    private String status;
    private Products products;
    private String customerId;

    public Order(String status, Products products, String customerId) {
        this.status = status;
        this.products = products;
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"status\": \"" + status + "\", \n" +
                "\"products\": \"" + products + "\", \n" +
                "\"customerId\": \"" + customerId + "\" \n"  +
                '}';
    }
}
