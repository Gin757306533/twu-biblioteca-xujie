package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {
    public static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";


    public static void main(String[] args) throws ParseException {
        Outputer outputer = new Outputer();
        outputer.displayMessage(welcomeMessage);

        List<Book> bookList = getBookList();
        outputer.displayBookListTitle(bookList);
        System.out.println("-------------------------------------");
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
