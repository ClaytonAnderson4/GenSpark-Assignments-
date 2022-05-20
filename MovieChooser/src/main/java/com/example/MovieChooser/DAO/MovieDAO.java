package com.example.MovieChooser.DAO;

import com.example.MovieChooser.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDAO extends JpaRepository<Movie, Integer> {
}
