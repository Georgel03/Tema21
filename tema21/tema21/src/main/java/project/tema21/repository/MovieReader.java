package project.tema21.repository;

import project.tema21.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieReader {

    public static List<Movie> generateMovies() {

        List<Movie> movieList = new ArrayList<>();
        Movie firstMovie = new Movie("Interstellar", 2010);
        Movie secondMovie = new Movie("Pacific-Rim", 2013);
        Movie thirdMovie = new Movie("Tenet", 2020);
        Movie fourthMovie = new Movie("Barbie", 2023);
        movieList.add(firstMovie);
        movieList.add(secondMovie);
        movieList.add(thirdMovie);
        movieList.add(fourthMovie);

        return movieList;
    }
}
