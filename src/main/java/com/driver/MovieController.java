package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director)
    {
        String result = movieService.addDirectors(director);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie)
    {
        String result = movieService.addMovies(movie);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String moviename,@RequestParam("director") String directorname)
    {
        String result = movieService.pairing(moviename,directorname);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String name)
    {
        Movie resultantMovie = movieService.getMoviebyName(name);
        return new ResponseEntity<>(resultantMovie, HttpStatus.OK);
    }
    @GetMapping("/movies/get-Director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String name)
    {
        Director resultantDirector = movieService.getDirectorbyName(name);
        return new ResponseEntity<>(resultantDirector, HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name")String name)
    {
        List<String> movielist = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movielist,HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List st=movieService.getAllMovies();
        return new ResponseEntity<>(st,HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name)
    {
        String res = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        String res = movieService.deleteAllDirectors();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
