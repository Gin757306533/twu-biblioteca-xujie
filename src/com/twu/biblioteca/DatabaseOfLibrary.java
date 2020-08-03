package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOfLibrary {
    private List<Customer> customerList;
    private List<Movie> movieList;
    private List<Book> bookList;

    public DatabaseOfLibrary() throws ParseException {
        this.customerList = this.createUserInfo();
        this.movieList = this.getMovieListBegain();
        this.bookList = this.getBookListBegain();
    }

    public List<Customer> createUserInfo(){
        ArrayList<Customer> userList = new ArrayList<>();
        Customer customer = new Customer("xujie", "757306533@qq.com","17674013080");
        userList.add(customer);

        customer = new Customer("chenhuan", "18624034615@163.com","18624034615");
        userList.add(customer);
        return userList;

    }

    public List<Book> getBookListBegain() throws ParseException {
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

    public List<Movie> getMovieListBegain(){
        List<Movie> movieList = new ArrayList<Movie>();
        Movie movie = new Movie("he Shawshank Redemption", "1994", "Frank Darabont", 10);
        movieList.add(movie);
        movie = new Movie("Léon", "1994", "Luc Besson", 9);
        movieList.add(movie);
        movie = new Movie(" Green Book", "2018", "Peter Farrelly", 8);
        movieList.add(movie);
        return movieList;

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
