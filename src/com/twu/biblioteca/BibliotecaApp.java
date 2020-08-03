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
            }else if (ret == 1){
                biblioteca.getMenu().displayMenu();

            }else if (ret == 2){
                biblioteca.getMenu().displayMenu();

            }else if (ret == 3){
                biblioteca.getMenu().displayMenu();

            }else if (ret == 4){
                biblioteca.getMenu().displayMenu();

            }
        }


    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
}
