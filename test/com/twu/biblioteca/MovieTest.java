package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.text.ParseException;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void testMovie() throws ParseException {
        //given
        Movie movie = new Movie("he Shawshank Redemption", "1994", "Frank Darabont", 10);

        //when
        String title = movie.getTitle();
        String director = movie.getDirector();
        String year = movie.getYear();
        int movieRating = movie.getMovieRating();

        //then
        assertThat(title, CoreMatchers.is("he Shawshank Redemption"));
        assertThat(director, CoreMatchers.is("Frank Darabont"));
        assertThat(year, CoreMatchers.is("1994"));
        assertThat(movieRating, CoreMatchers.is(10));
    }
}
