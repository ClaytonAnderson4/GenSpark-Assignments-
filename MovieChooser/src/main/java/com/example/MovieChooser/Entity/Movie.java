package com.example.MovieChooser.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_movies")
public class Movie {

    @Id
    @Column(name = "M_ID")
    private int umc;
    @Column(name = "M_rating")
    private double rating;
    @Column(name = "M_title")
    private String name;
    @Column(name = "M_year")
    private String year;

    public Movie() {
    }


    public Movie(int umc, double rating, String name, String year) {
        this.umc = umc;
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public int getUmc() {
        return umc;
    }

    public void setUmc(int umc) {
        this.umc = umc;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "umc=" + umc +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
