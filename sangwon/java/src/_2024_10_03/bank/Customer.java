package _2024_10_03.bank;

import java.sql.Timestamp;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt = null;
    private boolean isDeleted = false;

    public Customer(String name, String address, String password) {
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }
}