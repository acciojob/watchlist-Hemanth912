package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository

public class MovieRepository {

    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<String, ArrayList<String>> pairDb = new HashMap<>();


    String addMovieToDb(Movie movie)
    {
        String key = movie.getName();

        movieDb.put(key,movie);

        return "Successfully Added";
    }
    String addDirectorToDb(Director director)
    {
        String key = director.getName();

        directorDb.put(key,director);

        return "Successfully Added";
    }

    String addMovieDirectorPairToDb(String movie,String director)
    {
        if(movieDb.containsKey(movie) && directorDb.containsKey(director)) {
            if (pairDb.containsKey(director))
                pairDb.get(director).add(movie);
            else {
                ArrayList<String> newmv = new ArrayList<>();
                newmv.add(movie);
                pairDb.put(director,newmv);
            }
        }
        return "Successfully Paired";
    }

    Movie getMovieByName(String mname)
    {
        return movieDb.get(mname);
    }

    Director getDirectorByName(String mname)
    {
        return directorDb.get(mname);
    }

    ArrayList<String> getMoviesByDirectorName(String name)
    {
        ArrayList<String> res = new ArrayList<>();
        if(pairDb.containsKey(name))
            res=pairDb.get(name);

        return res;
    }
    ArrayList<String> getAllMovies()
    {
        ArrayList<String> movielist = new ArrayList<>();
        for(String s:movieDb.keySet())
            movielist.add(s);

        return movielist;
    }
    String deleteDirectorByName(String name)
    {
        if(directorDb.containsKey(name))
        {
            if(pairDb.containsKey(name))
            {
                ArrayList<String> m1 = pairDb.get(name);
                for(String s:m1)
                    movieDb.remove(s);

                pairDb.remove(name);
            }
            directorDb.remove(name);
            return "Successfully deleted";
        }
        return null;
    }

    String deleteAllDirectors()
    {
        ArrayList<String> list = new ArrayList<>();
        for(String s:pairDb.keySet())
        {
            for(String m:pairDb.get(s))
            {
                list.add(m);
            }
        }
        for(String i:list)
            movieDb.remove(i);

        return "Deleted all directors";
    }

}
