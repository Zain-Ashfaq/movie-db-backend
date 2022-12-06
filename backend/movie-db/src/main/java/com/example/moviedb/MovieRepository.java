package com.example.moviedb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> getAllMovies();
//    @Query(value = "SELECT * FROM movie WHERE runtime BETWEEN  CAST(':#{#num1}' AS SIGNED) AND CAST(':#{#num2}' AS SIGNED)",nativeQuery = true)
@Query(value = "SELECT * FROM movie WHERE runtime BETWEEN  CAST('0' AS SIGNED) AND CAST(:maxNum AS SIGNED);",nativeQuery = true)

List<Movie> getMovieReleaseDateBetween(@Param("maxNum") String maxNum);

}
