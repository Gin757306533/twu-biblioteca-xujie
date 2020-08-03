package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.text.ParseException;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void testMovie() throws ParseException {
        Movie movie = new Movie("he Shawshank Redemption", "1994", "Frank Darabont", 10);
        assertThat(movie.getName(), CoreMatchers.is("he Shawshank Redemption"));
        assertThat(movie.getDirector(), CoreMatchers.is("Frank Darabont"));
        assertThat(movie.getYear(), CoreMatchers.is("1994"));
        assertThat(movie.getMovieRating(), CoreMatchers.is(10));
    }
}
