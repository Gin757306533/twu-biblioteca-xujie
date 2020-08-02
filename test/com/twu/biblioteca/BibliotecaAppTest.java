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
        assertThat(bibliotecaApp.getMovieList().size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookList() throws ParseException {
        assertThat(this.bibliotecaApp.getBookList().size(), CoreMatchers.is(3));
        this.bibliotecaApp.getOutputer().displayBookListTitle(this.bibliotecaApp.getBookList());
    }

    @Test
    public void testBookListDetail() throws ParseException {
        assertThat(this.bibliotecaApp.getBookList().size(), CoreMatchers.is(3));
        this.bibliotecaApp.getOutputer().displayBookListDetail(this.bibliotecaApp.getBookList());
    }

    @Test
    public void testCheckout() throws ParseException {
        int beforeCount = bibliotecaApp.getBookList().size();
        bibliotecaApp.checkoutBook(1);
        assertThat(beforeCount, CoreMatchers.is(bibliotecaApp.getBookList().size()+1));
    }

    @Test
    public void testReturn() throws ParseException {
        bibliotecaApp.checkoutBook(1);
        int beforeCount = bibliotecaApp.getBookList().size();
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", (ArrayList<String>)authers.clone());

        bibliotecaApp.ReturnBook(book);
        assertThat(beforeCount, CoreMatchers.is(bibliotecaApp.getBookList().size()-1));
    }
}
