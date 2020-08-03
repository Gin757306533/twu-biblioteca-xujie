package com.twu.biblioteca;

public class Movie extends Item{
    private String year;
    private String director;
    private int movieRating;

    public Movie(String title, String year, String director, int movieRating) {
        super(title);
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
