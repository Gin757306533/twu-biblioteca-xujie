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

    public BibliotecaApp() throws ParseException {
        this.outputer = new Outputer();
        this.outputer.displayMessage(welcomeMessage);
        this.bookList = this.getBookList();


        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        this.menu = new Menu<String>(listOfOptions);
        this.menu.displayMenu();
    }

    public static void main(String[] args) throws ParseException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.interActWithCustomerOnMenu();


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

    public void interActWithCustomerOnMenu(){
        int menu_i = this.getMenuInput();
        String option = this.menu.getIndexOption(menu_i);
        if(option == "List of Books"){
            this.outputer.displayBookListTitle(this.bookList);
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
