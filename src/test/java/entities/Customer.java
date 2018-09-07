package entities;

public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
    private PhoneNumber phoneNumber;
    private String email;
    private String age;

    public Customer(String firstName, String lastName, Address address, PhoneNumber phoneNumber, String email, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"firstName\": \"" + firstName + "\", \n" +
                "\"lastName\": \"" + lastName + "\", \n" +
                "\"address\": \"" + address.toString() + "\", \n" +
                "\"phoneNumber\": \"" + phoneNumber.toString() + "\", \n" +
                "\"Email\": \"" + email + "\", \n" +
                "\"age\": \"" + age + "\" \n"  +
                '}';
    }
}


