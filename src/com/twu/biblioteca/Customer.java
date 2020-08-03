package com.twu.biblioteca;

public class Customer extends Person {
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        super(name);
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
