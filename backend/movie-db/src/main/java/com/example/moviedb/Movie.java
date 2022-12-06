package com.example.moviedb;

import jakarta.persistence.*;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    private String yearReleased;
    private String runtime;
    //    @Transient
    private String genres;
    private String director;
    private String actors;
    private String plot;
    private String posterUrl;

    public Movie(int id, String title, String yearReleased, String runtime, String genres, String director, String actors, String plot, String posterUrl) {
        this.id = id;
        this.title = title;

        this.yearReleased = yearReleased;
        this.runtime = runtime;
        this.genres = genres;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterUrl = posterUrl;
    }

    public Movie() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return yearReleased;
    }

    public void setYear(String yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    //    @Transient
    public String getGenres() {


        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }


    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
