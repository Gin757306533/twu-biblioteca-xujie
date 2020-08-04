package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

public class OutputerTest {
    @Test
    public void testDisplayCheckout() throws ParseException {
        //given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();
        ArrayList<Customer> customerArrayList = (ArrayList<Customer>)databaseOfLibrary.getCustomerList();
        ArrayList<Book> bookArrayList = (ArrayList<Book>)databaseOfLibrary.getBookList();
        Outputer outputer = new Outputer();

        //when
        databaseOfLibrary.checkoutBook(customerArrayList.get(1), bookArrayList.get(1));


        //then
        outputer.displayWhoCheckoutTheBook(databaseOfLibrary.getBookCheckoutMapper());
    }
}
