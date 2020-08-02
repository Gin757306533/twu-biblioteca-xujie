package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp{
    Menu<String> menu;
    Outputer outputer;
    List<Book> bookList;
    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String InvalidOptionMessage = "Please select a valid option";
    public static final String CheckoutFailedMessage = "Sorry, that book is not available";
    public static final String CheckoutSuccessfulMessage = "Thank you! Enjoy the book";

    public BibliotecaApp() throws ParseException {
        this.outputer = new Outputer();
        this.outputer.displayMessage(welcomeMessage);
        this.bookList = this.getBookList();


        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        listOfOptions.add("Quit");
        this.menu = new Menu<String>(listOfOptions);
        this.menu.displayMenu();
    }

    public static void main(String[] args) throws ParseException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        while(true){
            int ret = bibliotecaApp.interActWithCustomerOnMenu();
            if (ret == -1){
                break;
            }else{
                boolean checkout = bibliotecaApp.checkoutBook();
                bibliotecaApp.menu.displayMenu();

            }
        }



//        System.out.println("-------------------------------------");
//        outputer.displayBookListDetail(bookList);

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

    public int interActWithCustomerOnMenu(){
        int menu_i = this.getMenuInput();
        String option = this.menu.getIndexOption(menu_i);
        if(option == "List of Books"){
            this.outputer.displayBookListTitle(this.bookList);
            return 1;
        }else if (option == "Quit"){
            return -1;
        }
        return 1;
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

    public boolean checkoutBook(){
        int book_i = this.getCheckOutInput();
        if(book_i != -1){
            this.bookList.remove(book_i-1);
            this.outputer.displayMessage(CheckoutSuccessfulMessage);
            this.outputer.displayLists(this.bookList);
            return true;
        }else{
            return false;
        }
    }


    public List<Book> getBookList() throws ParseException {
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
