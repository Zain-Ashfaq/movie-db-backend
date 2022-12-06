package com.example.moviedb;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(){
        super("Movie has not been found");
    }
}
