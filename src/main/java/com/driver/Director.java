package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;


    public Director() {
    }

    public Director(String name, int numberOfMovies, double imbdRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImbdRating() {
        return imdbRating;
    }

    public void setImbdRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
