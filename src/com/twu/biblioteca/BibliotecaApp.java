package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp{
    private Menu<String> menu;

    private Outputer outputer;
    private List<Book> bookList;
    private List<Book> backupOfBookList;
    private List<Movie> movieList;

    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String InvalidOptionMessage = "Please select a valid option";
    public static final String CheckoutFailedMessage = "Sorry, that book is not available";
    public static final String CheckoutSuccessfulMessage = "Thank you! Enjoy the book";
    public static final String ReturnBookSuccessfulMessage = "Thank you for returning the book";
    public static final String ReturnBookFailedMessage = "That is not a valid book to return.";

    public BibliotecaApp() throws ParseException {
        this.outputer = new Outputer();
        this.outputer.displayMessage(welcomeMessage);
        this.bookList = this.getBookListBegain();
        this.backupOfBookList = new ArrayList<Book>();
        this.backupOfBookList.addAll(this.bookList);
        this.movieList = this.getMovieListBegain();


        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        listOfOptions.add("Checkout a book");
        listOfOptions.add("Return a book");
        listOfOptions.add("View a list of available movies");
        listOfOptions.add("Quit");
        this.menu = new Menu<String>(listOfOptions);

    }

    public static void main(String[] args) throws ParseException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.getMenu().displayMenu();

        while(true){
            int ret = bibliotecaApp.interActWithCustomerOnMenu();
            if (ret == -1){
                break;
            }else if (ret == 1){
                bibliotecaApp.getMenu().displayMenu();

            }else if (ret == 2){
                bibliotecaApp.getMenu().displayMenu();

            }else if (ret == 3){
                bibliotecaApp.getMenu().displayMenu();

            }else if (ret == 4){
                bibliotecaApp.getMenu().displayMenu();

            }
        }


    }

    public int getMenuInput(){
        int menu_i;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            try{
                menu_i = sc.nextInt();
                if (menu_i > 0 && menu_i <= this.menu.getlistOfOptions().size())break;
                else{
                    this.outputer.displayMessage(InvalidOptionMessage);
                    continue;
                }

            }catch (Exception e){
                this.outputer.displayMessage(InvalidOptionMessage);

            }
        }
        return menu_i;
    }

    public int interActWithCustomerOnMenu() throws ParseException {
        int menu_i = this.getMenuInput();
        String option = this.menu.getIndexOption(menu_i);
        if(option == "List of Books"){
            this.outputer.displayBookListDetail(this.bookList);
            return 1;
        }else if (option == "Checkout a book"){
            int book_i = this.getCheckOutInput();
            this.checkoutBook(book_i);
            return 2;
        }else if (option == "Return a book"){
            Book book = this.getBookInfo();
            this.ReturnBook(book);
            return 3;
        }else if (option == "View a list of available movies"){
            this.outputer.displayMovieListDetail(this.movieList);
            return 4;
        }else if (option == "Quit"){
            return -1;
        }
        return 1;
    }

    public Book getBookInfo() throws ParseException {
        Book book;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            try{
                this.outputer.displayMessage("Please input the title of the book:");
                String bookTitle = sc.nextLine().trim();
                this.outputer.displayMessage("Please input the publish date of the book:");
                String bookPublishDate = sc.nextLine().trim();
                int author_i = 0;
                ArrayList<String> authers = new ArrayList<String>();
                String author = "";
                do{
                    author_i += 1;
                    this.outputer.displayMessage("Please input the " + author_i + " author of the book:");
                    authers.add(sc.nextLine().trim());
                }while(author != "");
                book = new Book(bookTitle, bookPublishDate, authers);
                return book;


            }catch (Exception e){
                this.outputer.displayMessage("Something goes wrong when return a book!");
                continue;

            }
        }
    }


    public boolean ReturnBook(Book book) throws ParseException {


        if(this.backupOfBookList.contains(book) && !this.bookList.contains(book)){
            this.outputer.displayMessage(ReturnBookSuccessfulMessage);
            this.bookList.add(book);
            this.outputer.displayLists(this.bookList);
            return true;
        }else if(!this.backupOfBookList.contains(book)){
            this.outputer.displayMessage(ReturnBookFailedMessage);
            return false;
        }else{
            this.outputer.displayMessage(ReturnBookFailedMessage);
            return false;
        }
    }


    public int getCheckOutInput(){
        int book_i;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            try{
                book_i = sc.nextInt();
                if (book_i > 0 && book_i <= this.bookList.size())break;
                else if (book_i != -1){
                    this.outputer.displayMessage(CheckoutFailedMessage);
                    this.outputer.displayMessage("If you want to quit the checkout mode, enter -1");
                    continue;
                }else{
                    return -1;
                }

            }catch (Exception e){
                this.outputer.displayMessage(CheckoutFailedMessage);
                this.outputer.displayMessage("If you want to quit the checkout mode, enter -1");
                continue;

            }
        }
        return book_i;
    }

    public boolean checkoutBook(int book_i){
        if(book_i != -1){
            this.bookList.remove(book_i-1);
            this.outputer.displayMessage(CheckoutSuccessfulMessage);
            this.outputer.displayLists(this.bookList);
            return true;
        }else{
            return false;
        }
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


    public Menu<String> getMenu() {
        return menu;
    }

    public void setMenu(Menu<String> menu) {
        this.menu = menu;
    }

    public Outputer getOutputer() {
        return outputer;
    }

    public void setOutputer(Outputer outputer) {
        this.outputer = outputer;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }




}
