package com.example.moviedb;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService extends Movie {
    @Autowired
    MovieRepository movieRepository;

    //POST
    public void addMovie(List<Movie> movie) {
        System.out.println("this is movie " + movie.toString());


        movieRepository.save(movie.get(0));
    }


    // GET
    public List<Movie> getAllMovies(int limit) {

        List<Movie> movies = movieRepository.findAll();
        return movies;

    }

    public List<Movie> getMovieReleaseDateBetween(String minNum, String maxNum) {

        return movieRepository.getMovieReleaseDateBetween(minNum, maxNum);
    }

    public List<Movie> getMovieGenres(String whichGenre) {
        return movieRepository.getMovieGenres(whichGenre);
    }

    //DELETE
    @Transactional
    public void deleteMovieById(long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException();
        }

        movieRepository.deleteMovieById(id);
    }

    //PUT
    public void updateMovie(Movie movie, long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException();
        }

        movie.setId(id);

        movieRepository.save(movie);
    }

}
