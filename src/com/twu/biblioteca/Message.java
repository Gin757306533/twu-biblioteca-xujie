package com.twu.biblioteca;

public class Message {
    public static final String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String InvalidOptionMessage = "Please select a valid option";
    public static final String CheckoutFailedMessage = "Sorry, that book is not available";
    public static final String CheckoutSuccessfulMessage = "Thank you! Enjoy the book";
    public static final String ReturnBookSuccessfulMessage = "Thank you for returning the book";
    public static final String ReturnBookFailedMessage = "That is not a valid book to return.";

    public static String getWelcomeMessage() {
        return welcomeMessage;
    }

    public static String getInvalidOptionMessage() {
        return InvalidOptionMessage;
    }

    public static String getCheckoutFailedMessage() {
        return CheckoutFailedMessage;
    }

    public static String getCheckoutSuccessfulMessage() {
        return CheckoutSuccessfulMessage;
    }

    public static String getReturnBookSuccessfulMessage() {
        return ReturnBookSuccessfulMessage;
    }

    public static String getReturnBookFailedMessage() {
        return ReturnBookFailedMessage;
    }

    public static String ReturnBookSuccessfulMessage() {
        return ReturnBookSuccessfulMessage;
    }
}
