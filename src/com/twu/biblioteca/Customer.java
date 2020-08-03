package com.twu.biblioteca;

public class Customer extends Person {
    private String email;
    private String phone;
    private String password;

    public Customer(String name, String email, String phone, String password) {
        super(name);
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
