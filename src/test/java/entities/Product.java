package entities;

public class Product {
    private String status;
    private	String category;
    private	String description;
    private	String weightUnit;
    private	String quantity;
    private String productId;
    private String mainCategory;
    private	String depth;
    private	String name;
    private	String currencyCode;
    private	String dimUnit;
    private	String supplierId;
    private	String taxTarifCode;
    private	String uoM;
    private	String weightMeasure;
    private	String price;
    private	String height;
    private	String width;

    public Product(){

    }

    public Product(String status, String category, String description, String weightUnit, String quantity, String productId, String mainCategory, String depth, String name, String currencyCode, String dimUnit, String supplierId, String taxTarifCode, String uoM, String weightMeasure, String price, String height, String width) {
        this.status = status;
        this.category = category;
        this.description = description;
        this.weightUnit = weightUnit;
        this.quantity = quantity;
        this.productId = productId;
        this.mainCategory = mainCategory;
        this.depth = depth;
        this.name = name;
        this.currencyCode = currencyCode;
        this.dimUnit = dimUnit;
        this.supplierId = supplierId;
        this.taxTarifCode = taxTarifCode;
        this.uoM = uoM;
        this.weightMeasure = weightMeasure;
        this.price = price;
        this.height = height;
        this.width = width;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
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

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDimUnit() {
        return dimUnit;
    }

    public void setDimUnit(String dimUnit) {
        this.dimUnit = dimUnit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getTaxTarifCode() {
        return taxTarifCode;
    }

    public void setTaxTarifCode(String taxTarifCode) {
        this.taxTarifCode = taxTarifCode;
    }

    public String getUoM() {
        return uoM;
    }

    public void setUoM(String uoM) {
        this.uoM = uoM;
    }

    public String getWeightMeasure() {
        return weightMeasure;
    }

    public void setWeightMeasure(String weightMeasure) {
        this.weightMeasure = weightMeasure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"Status\": \"" + status + "\", \n" +
                "\"Category\": \"" + category + "\", \n" +
                "\"Description\": \"" + description + "\", \n" +
                "\"WeightUnit\": \"" + weightUnit + "\", \n" +
                "\"Quantity\": \"" + quantity + "\", \n" +
                "\"ProductId\": \"" + productId + "\", \n" +
                "\"MainCategory\": \"" + mainCategory + "\", \n" +
                "\"Depth\": \"" + depth + "\", \n" +
                "\"Name\": \"" + name + "\", \n" +
                "\"CurrencyCode\": \"" + currencyCode + "\", \n" +
                "\"DimUnit\": \"" + dimUnit + "\", \n" +
                "\"SupplierId\": \"" + supplierId + "\", \n" +
                "\"TaxTarifCode\": \"" + taxTarifCode + "\", \n" +
                "\"UoM\": \"" + uoM + "\", \n" +
                "\"WeightMeasure\": \"" + weightMeasure + "\", \n" +
                "\"Price\": \"" + price + "\", \n" +
                "\"Height\": \"" + height + "\", \n" +
                "\"Width\": \"" + width + "\" \n"  +
                '}';

    }
}
