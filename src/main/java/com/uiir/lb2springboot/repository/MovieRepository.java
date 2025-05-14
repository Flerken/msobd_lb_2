package com.uiir.lb2springboot.repository;

import com.uiir.lb2springboot.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByGenre(String genre);
    List<Movie> findByRatingGreaterThanEqual(double rating);
}
