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

        //given
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", authers);

        // when
        String title = book.getTitle();
        String publishDateString = book.getPublishDateString();
        String autherString = book.getAuthorListString();
        ArrayList<String> authers2= (ArrayList<String>)book.getAuthorList();

        // then
        assertThat(title, CoreMatchers.is("Le Petit Prince"));
        assertThat(publishDateString, CoreMatchers.is("1942-10-01"));
        assertThat(autherString, CoreMatchers.is("Antoine de Saint-Exupéry"+"\t"));
        assertThat(authers2, CoreMatchers.is(new ArrayList(authers)));
    }
}
