package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();


    @Before
    public void init() throws ParseException {
        this.biblioteca = new Biblioteca();
    }

    @Test
    public void testMovieList(){
        //given

        //when
        ArrayList<Movie> movieArrayList = (ArrayList<Movie>) biblioteca.getMovieList();

        //then
        assertThat(movieArrayList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookList() throws ParseException {
        //given

        //when
        ArrayList<Book> bookArrayList = (ArrayList<Book>)this.biblioteca.getBookList();

        //then
        assertThat(bookArrayList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookListDetail() throws ParseException {
        this.biblioteca.getOutputer().displayBookListDetail(this.biblioteca.getBookList());
    }

    @Test
    public void testCheckoutBook() throws ParseException {
        //given

        //when
        int beforeCount = biblioteca.getBookList().size();
        biblioteca.checkoutItem(1, biblioteca.getBookList());

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getBookList().size()+1));
    }

    @Test
    public void testCheckoutMovie() throws ParseException {
        //given

        //when
        int beforeCount = biblioteca.getMovieList().size();
        biblioteca.checkoutItem(1, biblioteca.getMovieList());

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getMovieList().size()+1));
    }

    @Test
    public void testReturn() throws ParseException {
        //when
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", (ArrayList<String>)authers.clone());


        //given
        biblioteca.checkoutItem(1, biblioteca.getBookList());
        int beforeCount = biblioteca.getBookList().size();
        biblioteca.ReturnBook(book);

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getBookList().size()-1));

    }
}
