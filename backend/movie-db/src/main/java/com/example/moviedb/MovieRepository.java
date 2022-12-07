package com.example.moviedb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query(value = "SELECT * FROM movie WHERE runtime BETWEEN  CAST(:minNum AS SIGNED) AND CAST(:maxNum AS SIGNED);", nativeQuery = true)
    List<Movie> getMovieReleaseDateBetween(@Param("minNum") String minNum, @Param("maxNum") String maxNum);

    @Query(value = "SELECT * FROM movie WHERE LOCATE(:userGenre, genres)>0;", nativeQuery = true)
    List<Movie> getMovieGenres(@Param("userGenre") String whichGenre);

    //DELETE
    void deleteMovieById(long id);
}
