package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
public class MessageTest {

    @Test
    public void testMessage(){
        //given

        //when
        String welcomeMessage = Message.getWelcomeMessage();
        String InvalidOptionMessage = Message.getInvalidOptionMessage();
        String CheckoutFailedMessage = Message.getCheckoutFailedMessage();
        String CheckoutSuccessfulMessage = Message.getCheckoutSuccessfulMessage();
        String ReturnBookSuccessfulMessage = Message.ReturnBookSuccessfulMessage();
        String ReturnBookFailedMessage = Message.getReturnBookFailedMessage();
        String CheckoutMovieFailedMessage = Message.getCheckoutMovieFailedMessage();
        String CheckoutMovieSuccessfulMessage = Message.getCheckoutMovieSuccessfulMessage();

        //then
        assertThat(welcomeMessage, CoreMatchers.is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
        assertThat(InvalidOptionMessage, CoreMatchers.is("Please select a valid option"));
        assertThat(CheckoutFailedMessage, CoreMatchers.is("Sorry, that book is not available"));
        assertThat(CheckoutSuccessfulMessage, CoreMatchers.is("Thank you! Enjoy the book"));
        assertThat(ReturnBookSuccessfulMessage, CoreMatchers.is("Thank you for returning the book"));
        assertThat(ReturnBookFailedMessage, CoreMatchers.is("That is not a valid book to return."));
        assertThat(CheckoutMovieFailedMessage, CoreMatchers.is("Sorry, that movie is not available"));
        assertThat(CheckoutMovieSuccessfulMessage, CoreMatchers.is("Thank you! Enjoy the movie"));

    }
}
