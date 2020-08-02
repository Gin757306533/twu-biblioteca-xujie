package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.contrib.java.lang.system.SystemOutRule;
public class ExampleTest {
//    private SomeCode somecode;
    public BibliotecaApp bibliotecaApp;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Before
    public void init() throws ParseException {
        this.bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testMovieList(){
        assertThat(bibliotecaApp.movieList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBook() throws ParseException {
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", authers);
        assertThat(book.getTitle(), CoreMatchers.is("Le Petit Prince"));
        assertThat(book.getPublishDateString(), CoreMatchers.is("1942-10-01"));
        assertThat(book.getAuthorList(), CoreMatchers.is(new ArrayList(authers)));
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


    @Test
    public void testMenu(){
        log.clearLog();
        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        Menu<String> menu = new Menu<String>(listOfOptions);
        menu.displayMenu();
        assertThat(log.getLog(), CoreMatchers.containsString("Hello, Welcome to Biblioteca Menu"));
    }

}
