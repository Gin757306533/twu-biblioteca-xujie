package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
public class MessageTest {

    @Test
    public void testMessage(){
        assertThat(Message.getWelcomeMessage(), CoreMatchers.is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));

    }
}
