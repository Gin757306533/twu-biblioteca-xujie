package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();


    @Before
    public void init() throws ParseException {
        this.bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testMovieList(){
        assertThat(bibliotecaApp.movieList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookList() throws ParseException {
        assertThat(this.bibliotecaApp.bookList.size(), CoreMatchers.is(3));
        this.bibliotecaApp.outputer.displayBookListTitle(this.bibliotecaApp.bookList);
    }

    @Test
    public void testBookListDetail() throws ParseException {
        assertThat(this.bibliotecaApp.bookList.size(), CoreMatchers.is(3));
        this.bibliotecaApp.outputer.displayBookListDetail(this.bibliotecaApp.bookList);
    }

    @Test
    public void testCheckout() throws ParseException {
        int beforeCount = bibliotecaApp.bookList.size();
        bibliotecaApp.checkoutBook(1);
        assertThat(beforeCount, CoreMatchers.is(bibliotecaApp.bookList.size()+1));
    }

    @Test
    public void testReturn() throws ParseException {
        bibliotecaApp.checkoutBook(1);
        int beforeCount = bibliotecaApp.bookList.size();
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", (ArrayList<String>)authers.clone());

        bibliotecaApp.ReturnBook(book);
        assertThat(beforeCount, CoreMatchers.is(bibliotecaApp.bookList.size()-1));
    }
}
