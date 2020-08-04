package com.twu.biblioteca;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private Menu<String> menu;
    private Outputer outputer;
    private List<Book> bookList;
    private List<Book> backupOfBookList;
    private List<Movie> movieList;
    private DatabaseOfLibrary databaseOfLibrary;

    public Biblioteca() throws ParseException {
        this.databaseOfLibrary = new DatabaseOfLibrary();
        this.outputer = new Outputer();
        this.outputer.displayMessage(Message.getWelcomeMessage());
        this.bookList = databaseOfLibrary.getBookList();
        this.backupOfBookList = new ArrayList<Book>();
        this.backupOfBookList.addAll(this.bookList);
        this.movieList = databaseOfLibrary.getMovieList();


        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        listOfOptions.add("Checkout a book");
        listOfOptions.add("Return a book");
        listOfOptions.add("View a list of available movies");
        listOfOptions.add("Checkout a movie");
        listOfOptions.add("To see Who has checkout the book");
        listOfOptions.add("Quit");
        this.menu = new Menu<String>(listOfOptions);
    }

    public int getMenuInput(){
        int menu_i;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            try{
                menu_i = sc.nextInt();
                if (isIndexInList(menu_i, this.menu.getlistOfOptions().size()))break;
                else{
                    this.outputer.displayMessage(Message.getInvalidOptionMessage());
                    continue;
                }

            }catch (Exception e){
                this.outputer.displayMessage(Message.getInvalidOptionMessage());

            }
        }
        return menu_i;
    }

    public String getString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public String[] getCustomerInfoInput(){
        String [] phone_password = new String[2];
        System.out.println("Please input your phone: ");
        String phone = getString();
        System.out.println("Please input your password: ");
        String password = getString();
        phone_password[0] = phone;
        phone_password[1] = password;
        return phone_password;

    }

    public int interActWithCustomerOnMenu() throws ParseException {
        int menu_i = this.getMenuInput();
        String option = this.menu.getIndexOption(menu_i);
        if(option == "List of Books"){
            this.outputer.displayBookListDetail(this.bookList);
            return 1;
        }else if (option == "Checkout a book"){
            String[] phone_password = this.getCustomerInfoInput();
            Customer customer = databaseOfLibrary.CustomerLogin(phone_password[0], phone_password[1]);
            if (customer != null ){
                int book_i = this.getCheckOutInput(this.bookList);

                this.checkoutItem(customer, book_i, this.getBookList());

            }

            return 2;
        }else if (option == "Return a book"){
            Book book = this.getBookInfo();
            this.ReturnBook(book);
            return 3;
        }else if (option == "View a list of available movies"){
            this.outputer.displayMovieListDetail(this.movieList);
            return 4;
        }else if (option == "Checkout a movie"){
            int book_i = this.getCheckOutInput(this.movieList);
            this.checkoutItem(null, book_i, this.getMovieList());
            return 5;
        }else if (option == "To see Who has checkout the book"){
            outputer.displayWhoCheckoutTheBook(databaseOfLibrary.getBookCheckoutMapper());
            return 6;
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
            this.outputer.displayMessage(Message.getReturnBookSuccessfulMessage());
            this.bookList.add(book);
            this.outputer.displayLists(this.bookList);
            return true;
        }else if(!this.backupOfBookList.contains(book)){
            this.outputer.displayMessage(Message.getReturnBookFailedMessage());
            return false;
        }else{
            this.outputer.displayMessage(Message.getReturnBookFailedMessage());
            return false;
        }
    }




    public int getCheckOutInput(List<? extends Item> list){
        int item_i;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Please input the ID of the item you want to lend");
                item_i = sc.nextInt();
                if (isIndexInList(item_i, list.size()))break;
                else if (item_i != -1){
                    Item item = list.get(0);
                    if (item instanceof Book){
                        this.outputer.displayMessage(Message.getCheckoutFailedMessage());
                    }else if(item instanceof Movie){
                        this.outputer.displayMessage(Message.getCheckoutMovieFailedMessage());
                    }

                    this.outputer.displayMessage("If you want to quit the checkout mode, enter -1");
                    continue;
                }else{
                    return -1;
                }

            }catch (Exception e){
                this.outputer.displayMessage(Message.getCheckoutFailedMessage());
                this.outputer.displayMessage("If you want to quit the checkout mode, enter -1");
                continue;

            }
        }
        return item_i;
    }

    private boolean isIndexInList(int item_i, int size) {
        return item_i > 0 && item_i <= size;
    }


    public boolean checkoutItem(Customer customer, int item_i, List<? extends Item> list){
        if(item_i != -1){
            Item item = list.remove(item_i-1);
            if (item instanceof Book){
                this.outputer.displayMessage(Message.getCheckoutSuccessfulMessage());
                this.databaseOfLibrary.checkoutBook(customer, (Book)item);
            }else if(item instanceof Movie){
                this.outputer.displayMessage(Message.getCheckoutMovieFailedMessage());
            }

            this.outputer.displayLists(list);
            return true;
        }else{
            return false;
        }
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
