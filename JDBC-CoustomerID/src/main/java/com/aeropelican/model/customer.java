package main.java.com.aeropelican.model;

public class Customer {

    private int customerId;
    private String customerName;
    private String email;
    private String phone;
    private String password;

    // Constructor
    public Customer(int customerId, String customerName, String email,
                    String phone, String password) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}