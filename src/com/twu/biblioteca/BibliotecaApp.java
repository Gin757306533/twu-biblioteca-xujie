package com.twu.biblioteca;

import java.text.ParseException;

public class BibliotecaApp{
    private Biblioteca biblioteca;


    public BibliotecaApp() throws ParseException {
        biblioteca = new Biblioteca();

    }


    public static void main(String[] args) throws ParseException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Biblioteca biblioteca = bibliotecaApp.getBiblioteca();
        biblioteca.getMenu().displayMenu();

        while(true){
            int ret = biblioteca.interActWithCustomerOnMenu();
            if (ret == -1){
                break;
            }else{
                biblioteca.getMenu().displayMenu();
            }
        }


    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
}
