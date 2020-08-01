package com.twu.biblioteca;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {
    @Test
    public void test() {
        assertEquals(1, 1);
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
        List<Book> bookList = getBookList();
        assertThat(bookList.size(), CoreMatchers.is(3));
        Outputer outputer = new Outputer();
        outputer.displayBookListTitle(bookList);
    }

    @Test
    public void testBookListDetail() throws ParseException {
        List<Book> bookList = getBookList();
        assertThat(bookList.size(), CoreMatchers.is(3));
        Outputer outputer = new Outputer();
        outputer.displayBookListDetail(bookList);
    }


    public static List<Book> getBookList() throws ParseException {
        List<Book> bookList = new ArrayList<Book>();
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", (ArrayList<String>)authers.clone());
        bookList.add(book);

        authers.clear();
        authers.add("Khaled Hosseini");
        book = new Book("The Kite Runner", "2003-01-01",  (ArrayList<String>)authers.clone());
        bookList.add(book);

        authers.clear();
        authers.add("George Orwell");
        book = new Book("Nineteen Eighty-Four", "1949-01-01",  (ArrayList<String>)authers.clone());
        bookList.add(book);

        return bookList;
    }
}
