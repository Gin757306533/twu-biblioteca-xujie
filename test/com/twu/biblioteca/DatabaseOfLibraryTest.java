package com.twu.biblioteca;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class DatabaseOfLibraryTest {
    @Test
    public void testDatabaseOfLibrary(){
        // given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();

        // when
        ArrayList<Customer> customerArrayList = (ArrayList<Customer>)databaseOfLibrary.getCustomerList();

        // then
        assertThat(customerArrayList.size(), CoreMatchers.is(2));

    }
}
