package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class MenuTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testMenu(){
        log.clearLog();
        ArrayList<String> listOfOptions = new ArrayList<String>();
        listOfOptions.add("List of Books");
        Menu<String> menu = new Menu<String>(listOfOptions);
        menu.displayMenu();
        assertThat(log.getLog(), CoreMatchers.containsString("Hello, Welcome to Biblioteca Menu"));
    }
}
