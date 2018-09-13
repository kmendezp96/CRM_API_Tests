package entities;

public class Supplier {
    private Address address;
    private PhoneNumber phoneNumber;
    private String email;
    private String supplierName;
    private String twitter;
    private String url;

    public Supplier(Address address, PhoneNumber phoneNumber, String email, String supplierName, String twitter, String url) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.supplierName = supplierName;
        this.twitter = twitter;
        this.url = url;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"address\": " + address.toString() + ", \n" +
                "\"phoneNumber\": " + phoneNumber.toString() + ", \n" +
                "\"Email\": \"" + email + "\", \n" +
                "\"SupplierName\": \"" + supplierName + "\", \n" +
                "\"Twitter\": \"" + twitter + "\", \n" +
                "\"Url\": \"" + url + "\" \n"  +
                '}';
    }
}
