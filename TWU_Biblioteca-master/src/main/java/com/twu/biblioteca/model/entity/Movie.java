package com.twu.biblioteca.model.entity;

import com.twu.biblioteca.model.enums.RentStatus;

public class Movie {

    private String movieName;
    private String year;
    private String diector;
    private String movieRating;
    private RentStatus rentStatus;

    public Movie(String movieName, String year, String diector, String movieRating, RentStatus rentStatus) {
        this.movieName = movieName;
        this.year = year;
        this.diector = diector;
        this.movieRating = movieRating;
        this.rentStatus = rentStatus;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDiector() {
        return diector;
    }

    public void setDiector(String diector) {
        this.diector = diector;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "  " + movieName +
                "  " + year +
                "  " + diector +
                "   " + movieRating + "\n";
    }
}
