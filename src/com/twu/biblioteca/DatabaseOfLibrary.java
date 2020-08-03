package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfLibrary {
    private List<Customer> customerList;

    public DatabaseOfLibrary() {
        this.customerList = this.createUserInfo();
    }

    public List<Customer> createUserInfo(){
        ArrayList<Customer> userList = new ArrayList<>();
        Customer customer = new Customer("xujie", "757306533@qq.com","17674013080");
        userList.add(customer);

        customer = new Customer("chenhuan", "18624034615@163.com","18624034615");
        userList.add(customer);
        return userList;

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
