package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class BookTest {
    @Test
    public void testBook() throws ParseException {
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", authers);
        assertThat(book.getTitle(), CoreMatchers.is("Le Petit Prince"));
        assertThat(book.getPublishDateString(), CoreMatchers.is("1942-10-01"));
        assertThat(book.getAuthorList(), CoreMatchers.is(new ArrayList(authers)));
    }
}
