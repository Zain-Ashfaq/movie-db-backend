package com.example.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    // GET
    public List<Movie> getAllMovies(int limit) {
//        return movieRepository
//                .findAll()
//                .stream()
//                .limit(limit)
//                .collect(Collectors.toList());
        List<Movie> movies = movieRepository.findAll();
        return movies;

    }
    public List<Movie>getMovieReleaseDateBetween(String minNum,String maxNum){

        return movieRepository.getMovieReleaseDateBetween(minNum,maxNum);
    }

    public List<Movie>getMovieGenres(String whichGenre){
        return movieRepository.getMovieGenres(whichGenre);
    }

}
