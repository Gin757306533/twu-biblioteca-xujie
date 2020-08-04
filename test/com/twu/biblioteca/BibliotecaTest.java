package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    private Biblioteca biblioteca;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();


    @Before
    public void init() throws ParseException {
        this.biblioteca = new Biblioteca();
    }

    @Test
    public void testMovieList(){
        //given

        //when
        ArrayList<Movie> movieArrayList = (ArrayList<Movie>) biblioteca.getMovieList();

        //then
        assertThat(movieArrayList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookList() throws ParseException {
        //given

        //when
        ArrayList<Book> bookArrayList = (ArrayList<Book>)this.biblioteca.getBookList();

        //then
        assertThat(bookArrayList.size(), CoreMatchers.is(3));
    }

    @Test
    public void testBookListDetail() throws ParseException {
        this.biblioteca.getOutputer().displayBookListDetail(this.biblioteca.getBookList());
    }

    @Test
    public void testCheckoutBook() throws ParseException {
        //given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();

        //when
        int beforeCount = biblioteca.getBookList().size();
        biblioteca.checkoutItem(databaseOfLibrary.getCustomerList().get(1), 1, biblioteca.getBookList());

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getBookList().size()+1));
    }

    @Test
    public void testCheckoutMovie() throws ParseException {
        //given

        //when
        int beforeCount = biblioteca.getMovieList().size();
        biblioteca.checkoutItem(null, 1, biblioteca.getMovieList());

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getMovieList().size()+1));
    }

    @Test
    public void testReturn() throws ParseException {
        //given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();
        ArrayList<String> authers = new ArrayList<String>();
        authers.add("Antoine de Saint-Exupéry");
        Book book = new Book("Le Petit Prince", "1942-10-01", (ArrayList<String>)authers.clone());


        //when
        biblioteca.checkoutItem(databaseOfLibrary.getCustomerList().get(0), 1, biblioteca.getBookList());
        int beforeCount = biblioteca.getBookList().size();
        biblioteca.ReturnBook(book);

        //then
        assertThat(beforeCount, CoreMatchers.is(biblioteca.getBookList().size()-1));

    }

    @Test
    public void testGetCustomerInfoInput() throws IOException {
        //given
        //when
        String[] phone_password = getCustomerInfoInput();
        //then
        assertThat(phone_password[0] , CoreMatchers.is("222-3333"));
        assertThat(phone_password[1], CoreMatchers.is("123"));
    }

    @Test
    public void testLoginSuccessfulNeedDo() throws ParseException {
        //given
        DatabaseOfLibrary databaseOfLibrary = new DatabaseOfLibrary();


        //when
        int loginBeforeMenuOptionsSize = biblioteca.getMenu().getlistOfOptions().size();
        biblioteca.loginSuccessfulNeedDo(databaseOfLibrary.getCustomerList().get(0));
        int loginAfterMenuOptionsSize = biblioteca.getMenu().getlistOfOptions().size();

        //then
        assertThat(loginBeforeMenuOptionsSize, CoreMatchers.is(loginAfterMenuOptionsSize-1));
    }

    public String[] getCustomerInfoInput() throws IOException {
        String [] phone_password = new String[2];
        System.out.println("Please input your phone: ");
        ByteArrayInputStream strIn=new ByteArrayInputStream("222-3333".getBytes());
        System.setIn(strIn);
        String phone = new String(System.in.readAllBytes());
        System.out.println("Please input your password: ");
        ByteArrayInputStream strIn2=new ByteArrayInputStream("123".getBytes());
        System.setIn(strIn2);
        String password = new String(System.in.readAllBytes());
        phone_password[0] = phone;
        phone_password[1] = password;
        return phone_password;

    }
}
