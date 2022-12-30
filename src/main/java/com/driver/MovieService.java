package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class MovieService {


    @Autowired
    MovieRepository movieRepository;


    String addMovies(Movie movie)
    {
        String result = movieRepository.addMovieToDb(movie);
        return result;
    }

    String addDirectors(Director director)
    {
        String result = movieRepository.addDirectorToDb(director);
        return result;
    }

    String pairing(String movie, String director)
    {
        String result = movieRepository.addMovieDirectorPairToDb(movie,director);
        return result;
    }

    Movie getMoviebyName(String mname)
    {
        return movieRepository.getMovieByName(mname);
    }
    Director getDirectorbyName(String mname)
    {
        return movieRepository.getDirectorByName(mname);
    }

    ArrayList<String> getMoviesByDirectorName(String name)
    {
        ArrayList<String> movielist=movieRepository.getMoviesByDirectorName(name);
        return movielist;
    }

    ArrayList<String> getAllMovies()
    {
        ArrayList<String> movieList = movieRepository.getAllMovies();
        return movieList;
    }

    String deleteDirectorByName(String director)
    {
        String res = movieRepository.deleteDirectorByName(director);
        return res;
    }

    String deleteAllDirectors()
    {
        String res = movieRepository.deleteAllDirectors();
        return res;
    }
}
