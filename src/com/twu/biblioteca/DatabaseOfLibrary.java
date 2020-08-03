package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseOfLibrary {
    private List<Customer> customerList;
    private List<Movie> movieList;
    private List<Book> bookList;
    private Map<Customer, List<Book>> bookCheckoutMapper;

    public DatabaseOfLibrary() throws ParseException {
        this.customerList = this.createUserInfo();
        this.movieList = this.getMovieListBegain();
        this.bookList = this.getBookListBegain();
        this.bookCheckoutMapper = new HashMap<>();
    }

    public void checkoutBook(Customer customer, Book book){
        ArrayList<Book> customerCheckoutedBookBefore;
        if (bookCheckoutMapper.containsKey(customer)) {
            customerCheckoutedBookBefore = (ArrayList<Book>)bookCheckoutMapper.get(customer);

        }else{
             customerCheckoutedBookBefore = new ArrayList<>();

        }

        customerCheckoutedBookBefore.add(book);
        bookCheckoutMapper.put(customer, customerCheckoutedBookBefore);
    }

    public void returnBook(Customer customer, Book book){

        if (bookCheckoutMapper.containsKey(customer)){
            ArrayList<Book> customerCheckoutedBookBefore = (ArrayList<Book>)bookCheckoutMapper.get(customer);
            customerCheckoutedBookBefore.remove(book);
            if(customerCheckoutedBookBefore.size() == 0){
                bookCheckoutMapper.remove(customer);
            }else{
                bookCheckoutMapper.put(customer, customerCheckoutedBookBefore);
            }


        }
    }

    public Map<Customer, List<Book>> getBookCheckoutMapper() {
        return bookCheckoutMapper;
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
