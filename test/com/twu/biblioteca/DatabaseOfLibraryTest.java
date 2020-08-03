package com.twu.biblioteca;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class DatabaseOfLibraryTest {
    @Test
    public void testDatabaseOfLibrary() throws ParseException {
        // given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();

        // when
        ArrayList<Customer> customerArrayList = (ArrayList<Customer>)databaseOfLibrary.getCustomerList();
        ArrayList<Movie> movieArrayList = (ArrayList<Movie>)databaseOfLibrary.getMovieList();
        ArrayList<Book> bookArrayList = (ArrayList<Book>)databaseOfLibrary.getBookList();

        // then
        assertThat(customerArrayList.size(), CoreMatchers.is(2));
        assertThat(movieArrayList.size(), CoreMatchers.is(3));
        assertThat(bookArrayList.size(), CoreMatchers.is(3));

    }

    @Test
    public void testCheckoutBook() throws ParseException {
        // given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();

        // when
        ArrayList<Customer> customerArrayList = (ArrayList<Customer>)databaseOfLibrary.getCustomerList();
        ArrayList<Book> bookArrayList = (ArrayList<Book>)databaseOfLibrary.getBookList();
        databaseOfLibrary.checkoutBook(customerArrayList.get(1), bookArrayList.get(1));
        // then
        assertThat(databaseOfLibrary.getBookCheckoutMapper().size(), CoreMatchers.is(1));

    }

    @Test
    public void testReturnBook() throws ParseException {
        // given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();

        // when
        ArrayList<Customer> customerArrayList = (ArrayList<Customer>)databaseOfLibrary.getCustomerList();
        ArrayList<Book> bookArrayList = (ArrayList<Book>)databaseOfLibrary.getBookList();
        Customer customer = customerArrayList.get(1);
        Book book = bookArrayList.get(1);
        Book book2 = bookArrayList.get(2);
        databaseOfLibrary.checkoutBook(customer, book);
        databaseOfLibrary.checkoutBook(customer, book2);

        databaseOfLibrary.returnBook(customer, book);
        // then
        assertThat(databaseOfLibrary.getBookCheckoutMapper().size(), CoreMatchers.is(1));

    }
}
