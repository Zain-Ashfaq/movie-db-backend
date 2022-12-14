package com.example.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    MovieService movieService;


    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(MovieNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    //Create
    @PostMapping("/movie")
    public ResponseEntity<List<Movie>> createMovie(@RequestBody List<Movie> movie) {

        movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }


    //GET

    @GetMapping("/movie")
    public String sayHello() {
        return "hello world test movie db";
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(@RequestParam(defaultValue = "100") int limit) {

        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies(limit));


//        return ResponseEntity.status(HttpStatus.OK).body(movieService.movieRepository.findAll());

    }

    @GetMapping("/movies/{minRuntime}/{maxRuntime}")

    public ResponseEntity<List<Movie>> getMovieBetween(@PathVariable("minRuntime") String minNum, @PathVariable("maxRuntime") String maxNum) {
        if (Integer.parseInt(minNum) > Integer.parseInt(maxNum)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieReleaseDateBetween(minNum, maxNum));
    }

    @GetMapping("movies/{genre}")
    public ResponseEntity<List<Movie>> getMovieGenres(@PathVariable("genre") String userGenre) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieGenres(userGenre));
    }

    // DELETE
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //PUT
    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateGreeting(@RequestBody Movie movie, @PathVariable long id) {
        movie.setId(id);
        movieService.updateMovie(movie, id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }


}
